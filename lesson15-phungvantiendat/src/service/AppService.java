package service;

import static model.DataModel.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Item;
import bean.Store;


public class AppService {
	private AppService() {
		
	}
	
	public static void processor() {
		Map<Item, List<Store>> a55 = mockStoresOfRefItemA55();
		Map<Item, List<Store>> a77 = mockStoresOfRefItemA77();
		
		Item item1 = a55.entrySet().stream()
				.map(it -> it.getKey())
				.toList()
				.getFirst();
		
		Item item2 = a77.entrySet().stream()
				.map(it -> it.getKey())
				.toList()
				.getFirst();
		
		List<Store> store1 = a55.entrySet()
				.stream()
				.map(it -> it.getValue())
				.toList()
				.stream()
				.flatMap(list -> list.stream())
				.toList();
		
		List<Store> store2 = a77.entrySet()
				.stream()
				.map(it -> it.getValue())
				.toList()
				.stream()
				.flatMap(list -> list.stream())
				.toList();
		/**
		 * Step 1
		 */
		
		// Step 2
		if(!PlanningAmountService.isValidPlanningAmount(planningAmount, requiredMinPlanningAmount)) {
			return;
		}
		GapsService.fillingGapsByReferencesOrAvg(store1);
//		System.out.println(store2);
		GapsService.fillingGapsByReferencesOrAvg(store2);
		
		// Step 3
		List<BigDecimal> demands = DemandService.calcDemands(mockStoreTrendFactors(), mockRefWeights(), a55, a77);
//		System.out.println(demands);
		
		// Step 4
		Map<String,BigDecimal> demandPerWH = DemandService.sumUpToWareHouse(demands, mockWHStores(), store2);
//		System.out.println(demandPerWH);
		
		// Step 5
		List<BigDecimal> shareWHs = ShareWareHouseService.calcShares(demandPerWH);
	
		
		// Step 6
		List<BigDecimal> allocateByShares = AllocationService.allocateByShares(shareWHs, planningAmount);
		
		// Step 7
		List<BigDecimal> minimums = AllocationService.applyMinimums(allocateByShares, minPerStore, amountOfStores());
		
		// Step 8
		List<BigDecimal> shareNewWHs = AllocationService.reAllocateShareWH(allocateByShares, planningAmount);
//		System.out.println(shareNewWHs);
		
	}
}
