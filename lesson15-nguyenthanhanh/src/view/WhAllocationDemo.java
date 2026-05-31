package view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.RefItemStoreId;
import model.DataModel;
import service.AllocateBySharesService;
import service.ApplyMinimumService;
import service.CalculateSharesService;
import service.CalculateStoreDemandService;
import service.FillingGapsByReferencesOrAverageService;
import service.SumUpDemandToWHLevelService;

public class WhAllocationDemo {
	
	public static void main(String[] args) {
		try {
			// Step 1: 
			System.out.println("=== Step 1: Check for planning amount ===");
			int planningAmount = DataModel.planningAmount;
			int requiredMinPlanningAmount = DataModel.requiredMinPlanningAmount;
			if(planningAmount <= requiredMinPlanningAmount) {
				throw new IllegalArgumentException("Invalid planningAmount");
			} else {
				// Step 2: 
				System.out.println("=== Step 2: Filling gaps by references or average ===");
				FillingGapsByReferencesOrAverageService fillingGapsByReferencesOrAverageService = 
						new FillingGapsByReferencesOrAverageService(
								DataModel.mockStoresOfRefItemA77(), 
								DataModel.mockRefStores());
				Map<RefItemStoreId, BigDecimal> a77StorePotentials = 
						fillingGapsByReferencesOrAverageService.execute();
				a77StorePotentials.forEach((refItemStore, potential) -> {
					System.out.println("\tItem : " + refItemStore.getRefItemId() + " | " +
							"Store: " + refItemStore.getStoreId() + " | " +
							"Potential: " + potential);
				});
				
				System.out.println("=== Step 2: End ===");
				
				// Step 3: 
				System.out.println("=== Step 3: Calculate Store Demand  ===");
				
				Map<RefItemStoreId, BigDecimal> a55StorePotentials = new HashMap<RefItemStoreId, BigDecimal>();
				DataModel.mockStoresOfRefItemA55().forEach((item, stores) -> {
					stores.forEach(store -> {
						RefItemStoreId refItemStoreId = new RefItemStoreId(item.getId(), store.getId());
						a55StorePotentials.put(refItemStoreId, store.getPotential());
					});
				});
				
				List<Map<RefItemStoreId, BigDecimal>> allItemStorePotentials = List.of(
						a55StorePotentials,
						a77StorePotentials
				);
				CalculateStoreDemandService calculateStoreDemandService = new CalculateStoreDemandService
						(allItemStorePotentials, DataModel.mockRefWeights(), 
						DataModel.mockStoreTrendFactors(), DataModel.mockItemStoreIds());
				Map<Integer, BigDecimal> storeDemands = calculateStoreDemandService.execute();
				storeDemands.forEach((storeId, demand) -> {
					System.out.println("\tStoreId : " + storeId + " | " +
							"Demand: " + demand);
				});
				
				System.out.println("=== Step 3: End ===");
				
				// Step 4: 
				System.out.println("=== Step 4: Sum up Demand to WH Level   ===");
				Map<Integer, Integer> storeWhIds = new HashMap<Integer, Integer>();
				DataModel.mockStoresOfRefItemA55().forEach((item, stores) -> {
					stores.forEach(store -> {
						storeWhIds.put(store.getId(), store.getWhId());
					});
				});
				
				SumUpDemandToWHLevelService sumUpDemandToWHLevel = 
						new SumUpDemandToWHLevelService(storeDemands, storeWhIds);
				Map<Integer, BigDecimal> whDemands = sumUpDemandToWHLevel.execute();
				whDemands.forEach((whId, demand) -> {
					System.out.println("\tWarehouseId : " + whId + " | " +
							"Demand: " + demand);
				});

				System.out.println("=== Step 4: End ===");
				
				// Step 5: 
				System.out.println("=== Step 5: Calculate Shares   ===");
				CalculateSharesService calculateSharesService = 
						new CalculateSharesService(whDemands);
				Map<Integer, BigDecimal> whShares = calculateSharesService.execute();
				whShares.forEach((whId, shares) -> {
					System.out.println("\tWarehouseId : " + whId + " | " +
							"Shares: " + shares);
				});
				
				System.out.println("=== Step 5: End ===");
				
				// Step 6: 
				System.out.println("=== Step 6: Allocate by Shares   ===");
				AllocateBySharesService allocateBySharesService = 
						new AllocateBySharesService(whShares, DataModel.planningAmount);
				Map<Integer, BigDecimal> whAllocationAmounts = 
						allocateBySharesService.execute();
				whAllocationAmounts.forEach((whId, allocationAmount) -> {
					System.out.println("\tWarehouseId : " + whId + " | " +
							"AllocationAmount: " + allocationAmount);
				});
				
				System.out.println("=== Step 6: End ===");
				
				// Step 7: 
				System.out.println("=== Step 7: Apply Minimum   ===");
				ApplyMinimumService applyMinimumService = 
						new ApplyMinimumService(whAllocationAmounts, 
								DataModel.minPerStore, storeWhIds);
				Map<Integer, BigDecimal> whAllocationAmountsAfterApplyMinimum =
						applyMinimumService.execute();
				whAllocationAmountsAfterApplyMinimum.forEach((whId, allocationAmount) -> {
					System.out.println("\tWarehouseId : " + whId + " | " +
							"AllocationAmount: " + allocationAmount);
				});
				
				System.out.println("=== Step 7: End ===");
				
			}
		} catch (Exception e) {
			System.err.print(e);
		}
	}
	
}
