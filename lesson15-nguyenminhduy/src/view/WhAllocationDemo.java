package view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Store;
import bean.StoreDemand;
import bean.whAllocation;
import model.DataModel;
import service.AllocationService;

public class WhAllocationDemo {
	
	public static void main(String[] args) {
		System.out.println("====== Bat dau chuong trinh ======\n");
		
		AllocationService service = new AllocationService();
		
		Integer planningAmount = DataModel.planningAmount;
		Integer requiredMin = DataModel.requiredMinPlanningAmount;
		
		List<Store> storesA55 = DataModel.mockStoresOfRefItemA55().values().iterator().next();
		List<Store> storesA77 = DataModel.mockStoresOfRefItemA77().values().iterator().next();
		
		Map<Integer, Integer> refStoresMap = DataModel.mockRefStores();
		Map<Integer, BigDecimal> refWeights = DataModel.mockRefWeights();
		Map<Integer, BigDecimal> trendFactors = DataModel.mockStoreTrendFactors();
		
		System.out.println("======Step1: Check for palnning====");
		if(!service.checkpalnningAmount(planningAmount, requiredMin)) {
			System.out.println("planning amount (" + planningAmount + ") <= Required Min (" + requiredMin + "). Stop calculation");
			return;
		}
		System.out.println("OK! Planning hop le\n");
		
		System.out.println("=====Step2: Filling gaps by references or average====");
		service.fillGaps(storesA55, refStoresMap);
		service.fillGaps(storesA77, refStoresMap);
		System.out.println("hoan tat lap khoang trong\n");
		
		System.out.println("=====Step3: Calculate Store demand of current Item======");
		List<StoreDemand> demands = service.calculateStoreDemand(storesA55, storesA77, refWeights, trendFactors);
		
		System.out.println("ket qua: ");
		for(StoreDemand d : demands) {
			System.out.println(d.toString());
		}
		
		System.out.println("\n====Step 4: sum up Demand to WH level======");
		List<whAllocation> whAllocations = service.sumUpdemandToWhLevel(demands);
		System.out.println("Tong hop nhu cau theo kho hoan tat");
		
		System.out.println("\n===Step 5 & 6: Calculate Shares & allocate by shares=====");
		service.calculateSharesAndAllocate(whAllocations, planningAmount);
		
		for(whAllocation wh: whAllocations) {
			System.out.println(wh.toString());
		}
	}
	
}
