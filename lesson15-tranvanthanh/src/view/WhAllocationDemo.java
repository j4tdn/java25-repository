package view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;



import bean.DemandResult;
import bean.Item;
import bean.Store;
import model.DataModel;
import service.Step1;
import service.Step2;
import service.Step3;
import service.Step4;
import service.Step5;
import service.Step6;

public class WhAllocationDemo {

	public static void main(String[] args) {
		System.out.println("Step 01:");
		Step1 step01 = new Step1();
		
		boolean result = step01.execute(DataModel.planningAmount, DataModel.requiredMinPlanningAmount);
		
		if(!result) {
			System.out.println("Không hợp lê.");
			
			return;
		}
		
		System.out.println("Step1 hợp lệ. ");
		
		System.out.println("=========================================================\n");
		
		System.out.println("Step 02:");
		
		Map<Item, List<Store>> itemA77Data = DataModel.mockStoresOfRefItemA77();
		Item itemA77 = itemA77Data.keySet().iterator().next();
		
		List<Store> stores = itemA77Data.get(itemA77);
		Step2 step02= new Step2();
		step02.execute(stores, DataModel.mockRefStores());
		
		for(Store  store : stores) {
			
			System.out.println(store.getDesc()+ " -> "+store.getPotential());
			
		}
		
		
		
		System.out.println("=========================================================\n");
		System.out.println("Step 03:");
		
		Map<Item , List<Store>> item55Data = DataModel.mockStoresOfRefItemA55();
		Item item55 = item55Data.keySet().iterator().next();
		List<Store> stores55 = item55Data.get(item55);
		
		
		Map<Item , List<Store>> item77Data = DataModel.mockStoresOfRefItemA77();
		Item item77 = item77Data.keySet().iterator().next();
		List<Store> stores77 = item77Data.get(item77);
		
		step02.execute(stores77, DataModel.mockRefStores());
		
		Step3 step03 = new Step3();
		
		List<DemandResult> DemandResults = step03.execute(stores55, stores77, DataModel.mockStoreTrendFactors(), DataModel.mockRefWeights());
		
		for(DemandResult results : DemandResults) {
			System.out.println(results.getStore().getDesc()+" -> "+results.getDemand());
		}
		
		
		System.out.println("=========================================================\n");
		System.out.println("Step 04:");
		
		
		
		Step4 step04 = new Step4();

		Map<Integer, BigDecimal> wh = step04.execute(DemandResults);

		System.out.println("WH1 = " + wh.get(1));
		System.out.println("WH2 = " + wh.get(2));
		System.out.println("WH3 = " + wh.get(3));
		 
		
		
		System.out.println("=========================================================\n");
		System.out.println("Step 05:");
		
	

	Step5 step5 = new Step5();

	Map<Integer, BigDecimal> share = step5.execute(wh);

	for (Map.Entry<Integer, BigDecimal> e : share.entrySet()) {
	    System.out.println("WH" + e.getKey() + " -> " + e.getValue() + "%");
	}
	
	
	System.out.println("=========================================================\n");
	System.out.println("Step 06:");
	
	
	Step6 step6 = new Step6();

	Map<Integer, BigDecimal> allocation = step6.execute(
	        share,
	        BigDecimal.valueOf(DataModel.planningAmount)
	);


	for (Map.Entry<Integer, BigDecimal> e : allocation.entrySet()) {
	    System.out.println("WH" + e.getKey() + " -> " + e.getValue());
	}
	}
	
}
