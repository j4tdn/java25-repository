package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Item;
import bean.Store;
import model.DataModel;

public class WhAllocationService {

	private Step1 step1 = new Step1();
	private Step2 step2 = new Step2();
	private Step3 step3 = new Step3();

	public boolean runAllocationProcess() {
		// Step1
		boolean isStep10k = step1.execute();

		if (isStep10k == false) {
			return false;
		}
		// Step2
		Map<Item, List<Store>> dataMap = DataModel.mockStoresOfRefItemA55();

		List<Store> currentStores = new ArrayList<>();

		for (List<Store> list : dataMap.values()) {
			currentStores = list;
		}

		step2.execute(currentStores);

		// Step 3
		List<Store> storesA55 = layDanhsachStoreTuMap(DataModel.mockStoresOfRefItemA55());
		List<Store> storesA77 = layDanhsachStoreTuMap(DataModel.mockStoresOfRefItemA77());

		step2.execute(storesA55);
		step2.execute(storesA77);

		Map<Integer, BigDecimal> caculatedDemand = step3.execute(storesA55, storesA77);
		return true;

	}

	private List<Store> layDanhsachStoreTuMap(Map<Item, List<Store>> mockMap) {
		List<Store> listResult = new ArrayList<>();
		for (List<Store> list : mockMap.values()) {
			listResult = list;

		}
		return listResult;

	}

}
