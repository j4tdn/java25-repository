package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import exception.AllocationException;
import model.Store;

public class AllocationService {

	public void fillExpectedSales(List<Store> stores) {

		List<Store> selectedStores = stores.stream().filter(Store::isSelected).toList();

		validateInput(selectedStores);

		Map<Long, Store> storeMap = stores.stream().collect(Collectors.toMap(Store::getStoreId, Function.identity()));

		double average = calculateAverageOriginalExpectedSales(selectedStores);

		for (Store store : selectedStores) {

			fillExpectedSalesForStore(store, storeMap, average);
		}
	}

	private void validateInput(List<Store> selectedStores) {

		boolean hasOwnExpectedSales = selectedStores.stream().anyMatch(store -> store.getExpectedSales() != null);

		if (!hasOwnExpectedSales) {
			throw new AllocationException("Expected sales cannot be calculated. "
					+ "Please add a reference store or include stores " + "with expected sales for interpolation");
		}
	}

	private double calculateAverageOriginalExpectedSales(List<Store> selectedStores) {

		List<Double> ownExpectedSales = selectedStores.stream().map(Store::getExpectedSales)
				.filter(value -> value != null).toList();

		double avg = ownExpectedSales.stream().mapToDouble(Double::doubleValue).average().orElse(0);

		return round(avg, 1);
	}

	private void fillExpectedSalesForStore(Store store, Map<Long, Store> storeMap, double average) {

		if (store.getExpectedSales() != null) {

			store.setExpectedSalesFinal(store.getExpectedSales());

			return;
		}

		Long referenceStoreId = store.getReferenceStoreId();

		if (referenceStoreId != null) {

			Store referenceStore = storeMap.get(referenceStoreId);

			if (referenceStore != null && referenceStore.getExpectedSales() != null) {

				store.setExpectedSalesFinal(referenceStore.getExpectedSales());

				return;
			}
		}

		store.setExpectedSalesFinal(average);
	}

	// step2
	public void calculateAllocationKey(List<Store> stores) {
		List<Store> selectedStores = stores.stream().filter(Store::isSelected).toList();
		double totalExpectedSales = selectedStores.stream().map(Store::getExpectedSalesFinal)
				.mapToDouble(Double::doubleValue).sum();
		for (Store store : selectedStores) {
			double allocationKey = store.getExpectedSalesFinal() / totalExpectedSales;
			store.setAllocationKey(round(allocationKey, 10));
		}

	}

	// step3
	public void calculatedAllocatedAmount(List<Store> stores, int warehouseAllocationAmount) {
		int totalStock = stores.stream().mapToInt(Store::getStockPreviousDay).sum();
		List<Store> selecteedStores = stores.stream().filter(Store::isSelected).toList();

		for (Store store : selecteedStores) {
			double allocated = store.getAllocationKey() * (warehouseAllocationAmount + totalStock)
					- store.getStockPreviousDay();
			int rounded = (int) Math.round(allocated);
			if (rounded < 0) {
				rounded = 0;
			}
			store.setAllocatedAmount(rounded);
		}

	}

	private double round(double value, int scale) {

		return BigDecimal.valueOf(value).setScale(scale, RoundingMode.HALF_UP).doubleValue();
	}
}