package view;

import static utils.NumberUtils.bd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Item;
import bean.Store;
import model.DataModel;
import model.WhData;
import utils.NumberUtils;

public class WhAllocationDemo {

	private static final int SCALE = 10;

	public static void main(String[] args) {
		
		System.out.println();

		// ===== STEP 1 =====
		System.out.println("=== STEP 1: Kiem tra Planning Amount ===");
		System.out.println("   Planning Amount Country: " + DataModel.planningAmount);
		System.out.println("   Required Min Planning Amount: " + DataModel.requiredMinPlanningAmount);

		if (DataModel.planningAmount <= DataModel.requiredMinPlanningAmount) {
			System.out.println("    Planning Amount <= Required Min.");
			return;
		}
		System.out.println("  OK. Tiep tuc.");
		System.out.println();

		
		Map<Item, List<Store>> refStoresA55 = DataModel.mockStoresOfRefItemA55();
		Map<Item, List<Store>> refStoresA77 = DataModel.mockStoresOfRefItemA77();
		Item itemA55 = findItem(refStoresA55, 55);
		Item itemA77 = findItem(refStoresA77, 77);

		List<Store> storesA55 = refStoresA55.get(itemA55);
		List<Store> storesA77 = refStoresA77.get(itemA77);
		Map<Integer, Integer> refStoreMapping = DataModel.mockRefStores();
		Map<Integer, BigDecimal> refWeights = DataModel.mockRefWeights();
		Map<Integer, BigDecimal> storeTrends = DataModel.mockStoreTrendFactors();

		// ====== STEP 2 =====
		System.out.println("=== STEP 2: Fill gaps cho Store co Potential ===");

		List<Store> filledA55 = fillGaps(storesA55, refStoreMapping);
		List<Store> filledA77 = fillGaps(storesA77, refStoreMapping);

		NumberUtils.printStores("   Store Potential - Ref Item A55 (sau fill gaps)", filledA55);
		NumberUtils.printStores("   Store Potential - Ref Item A77 (sau fill gaps)", filledA77);

		// ===== STEP 3 =====
		System.out.println("=== STEP 3: Tinh Store Demand ===");
		System.out.println("   Formula: Demand = ((Pot55 * W55 + Pot77 * W77) / (W55+W77)) * Trend");
		System.out.println();

		List<StoreDemand> storeDemands = calculateStoreDemand(filledA55, filledA77, refWeights, storeTrends);
		NumberUtils.printStoreDemands("   Store Demand", storeDemands);

		// ===== STEP 4 =====
		System.out.println("=== STEP 4: Sum Demand to WH Level ===");

		Map<Integer, List<StoreDemand>> demandByWh = storeDemands.stream()
				.collect(Collectors.groupingBy(StoreDemand::whId, LinkedHashMap::new, Collectors.toList()));

		Map<Integer, WhData> whDataMap = new LinkedHashMap<>();
		for (var entry : demandByWh.entrySet()) {
			Integer whId = entry.getKey();
			List<StoreDemand> sdList = entry.getValue();
			BigDecimal totalDemand = sdList.stream()
					.map(StoreDemand::demand)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			int storeCount = sdList.size();
			whDataMap.put(whId, new WhData(whId, storeCount, totalDemand));
		}
		NumberUtils.printWhDemand(whDataMap);

		// ===== STEP 5 =====
		System.out.println("=== STEP 5: Calculate Shares ===");

		BigDecimal totalDemandAllWh = whDataMap.values().stream()
				.map(wh -> wh.demand)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		for (WhData wh : whDataMap.values()) {
			wh.share = wh.demand.divide(totalDemandAllWh, SCALE, RoundingMode.HALF_UP);
		}
		NumberUtils.printWhShare(whDataMap);

		// ===== STEP 6 =====
		System.out.println("=== STEP 6: Allocate by Shares ===");

		for (WhData wh : whDataMap.values()) {
			wh.allocation = wh.share.multiply(bd(DataModel.planningAmount)).setScale(SCALE, RoundingMode.HALF_UP);
		}
		NumberUtils.printWhAllocation(whDataMap);
	}
		

	

	private static Item findItem(Map<Item, List<Store>> map, int itemId) {
		return map.keySet().stream()
				.filter(item -> item.getId() == itemId)
				.findFirst()
				.orElse(null);
	}



	private static List<Store> fillGaps(List<Store> stores, Map<Integer, Integer> refStoreMapping) {
		List<Store> storesWithOwnPotential = stores.stream()
				.filter(s -> s.getPotential() != null && s.getPotential().compareTo(BigDecimal.ZERO) > 0)
				.toList();

		BigDecimal sumOwn = storesWithOwnPotential.stream()
				.map(Store::getPotential)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		long countOwn = storesWithOwnPotential.size();
		BigDecimal avgPotential = sumOwn.divide(bd(countOwn), SCALE, RoundingMode.HALF_UP);

		Map<Integer, BigDecimal> potentialByStoreId = stores.stream()
				.collect(Collectors.toMap(Store::getId, Store::getPotential));

		List<Store> result = new ArrayList<>();
		for (Store store : stores) {
			if (store.getPotential() != null && store.getPotential().compareTo(BigDecimal.ZERO) > 0) {
				result.add(store);
			} else {
				Integer refStoreId = refStoreMapping.get(store.getId());
				BigDecimal filledPotential;

				boolean refExists = refStoreId != null
						&& potentialByStoreId.get(refStoreId) != null
						&& potentialByStoreId.get(refStoreId).compareTo(BigDecimal.ZERO) > 0;

				if (refExists) {
					filledPotential = potentialByStoreId.get(refStoreId);
				} else {
					filledPotential = avgPotential;
				}

				Store filled = new Store(store.getId(), store.getDesc(),
						filledPotential.setScale(SCALE, RoundingMode.HALF_UP), store.getWhId());
				result.add(filled);
			}
		}
		return result;
	}

	

	private static List<StoreDemand> calculateStoreDemand(
			List<Store> filledA55, List<Store> filledA77,
			Map<Integer, BigDecimal> refWeights, Map<Integer, BigDecimal> storeTrends) {

		BigDecimal weight55 = refWeights.get(55);
		BigDecimal weight77 = refWeights.get(77);
		BigDecimal sumWeights = weight55.add(weight77);

		List<StoreDemand> result = new ArrayList<>();
		for (int i = 0; i < filledA55.size(); i++) {
			Store s55 = filledA55.get(i);
			Store s77 = filledA77.get(i);

			BigDecimal numerator = s55.getPotential().multiply(weight55)
					.add(s77.getPotential().multiply(weight77));
			BigDecimal demand = numerator.divide(sumWeights, SCALE, RoundingMode.HALF_UP);

			BigDecimal trend = storeTrends.getOrDefault(s55.getId(), BigDecimal.ONE);
			demand = demand.multiply(trend).setScale(SCALE, RoundingMode.HALF_UP);

			result.add(new StoreDemand(s55.getId(), s55.getDesc(), demand, s55.getWhId(), trend));
		}
		return result;
	}

	

	public record StoreDemand(Integer storeId, String desc, BigDecimal demand, Integer whId, BigDecimal trend) {
	}

}
