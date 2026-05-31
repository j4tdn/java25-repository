package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Store;
import model.DataModel;
import utils.RoundingUtils;

public class Step2 {
	public void execute(List<Store> stores) {
		System.out.println("/n=== Step 2: Filling gaps by references or average ===");

		// Get mock data
		Map<Integer, Integer> refStoreMap = DataModel.mockRefStores();

		// 1.take Potential of Reference own store
		double sumOwnPotential = 0;
		int countOwnPotential = 0;
		for (int i = 0; i < stores.size(); i++) {
			Store s = stores.get(i);

			// own potential mean >0 at the initial
			if (s.getPotential() != null && s.getPotential().compareTo(BigDecimal.ZERO) > 0) {
				sumOwnPotential += s.getPotential().doubleValue();
				countOwnPotential++;
			}

		}
		// Commercial Round 1 decimal
		double averagePotential = 0;
		if (countOwnPotential >= 0) {
			averagePotential = RoundingUtils.round(sumOwnPotential / countOwnPotential, 1);
		}
		System.out.println("Avarage Own Potential: " + averagePotential);

		// 2. Potential <=0 or null
		for (int i = 0; i < stores.size(); i++) {
			Store store = stores.get(i);

			if (store.getPotential() == null || store.getPotential().compareTo(BigDecimal.ZERO) <= 0) {

				// check if valid refstore
				Integer refStoreId = refStoreMap.get(store.getId());
				Store refStore = null;

				// if valid
				if (refStoreId != null) {
					for (int j = 0; j < stores.size(); j++) {
						if (stores.get(j).getId().equals(refStoreId)) {
							refStore = stores.get(j);
							break;
						}
					}
				}

				// Case1
				if (refStore != null && refStore.getPotential() != null
						&& refStore.getPotential().compareTo(BigDecimal.ZERO) > 0) {
					store.setPotential(refStore.getPotential());
					System.out.println("=> " + store.getDesc() + " get Potential from reference Store" + refStoreId
							+ "=" + store.getPotential());
				} else
				// Case2
				{
					store.setPotential(BigDecimal.valueOf(averagePotential));
					System.out.println("=> " + store.getDesc() + " no reference Store => get average  of potential = "
							+ averagePotential);

				}

			}
		}

	}

}
