package service;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import static utils.NumberUtils.*;

import static model.DataModel.*;

import bean.Store;

public class GapsService {

	private GapsService() {

	}

	public static List<BigDecimal> fillingGapsByReferencesOrAvg(List<Store> stores) {
		var storeRefs = mockRefStores();
		var map = transformToMap(stores);
		fillingGapsSingleStore(storeRefs, map, stores);

		return stores.stream().map(Store::getPotential).toList();
	}

	private static void fillingGapsSingleStore(Map<Integer, Integer> storeRefs, Map<Integer, Store> stores,
			List<Store> data) {

//		Set<Entry<Integer, Integer>> dataForRefs = storeRefs.entrySet();

		for (Store item : data) {
			BigDecimal potential = item.getPotential();
//			if(!potential.equals(BigDecimal.ZERO) || storeRefs.get(item.getId()) != null) {
//				continue;
//			}
//		
//			Store store = stores.get(item.getId());
//			if(storeRefs.get(store.getId()) == null ) {
//				var value = calcAvgPotential(data);
//				store.setPotential(value);
//				return;
//			}
//			BigDecimal refPotential = stores.get(storeRefs.get(item.getId())).getPotential();
//			if(refPotential.equals(BigDecimal.ZERO)) {
//				var value = calcAvgPotential(data);
//				store.setPotential(value);
//				return;
//			}
//			
//			store.setPotential(refPotential);
//			return;

			if (storeRefs.get(item.getId()) != null) {
				BigDecimal refPotential = stores.get(storeRefs.get(item.getId())).getPotential();
				item.setPotential(refPotential);
				Store store = stores.get(storeRefs.get(item.getId()));
				if (store == null || store.getPotential().equals(BigDecimal.ZERO)) {
					var value = calcAvgPotential(data);
					item.setPotential(value);
				}
			} else {
				var value = calcAvgPotential(data);
				item.setPotential(value);
			}
		}

	

	}

	private static Map<Integer, Store> transformToMap(List<Store> stores) {
		return stores.stream().collect(Collectors.toMap(Store::getId, Function.identity()));
	}

	private static BigDecimal calcAvgPotential(List<Store> stores) {
		var potentials = stores.stream().filter(store -> !store.getPotential().equals(BigDecimal.ZERO))
				.map(Store::getPotential).toList();

		var results = potentials.stream().map(BigDecimal::doubleValue).reduce(0d, (a, b) -> a + b);
		var result = results / potentials.size();
		return bd(result).setScale(1, RoundingMode.HALF_UP);

	}

}
