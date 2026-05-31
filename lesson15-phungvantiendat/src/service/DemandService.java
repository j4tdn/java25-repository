package service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.NumberUtils.*;

import bean.Item;
import bean.Store;

public class DemandService {
	
	private DemandService() {
		
	}

	
	public static Map<String, BigDecimal> sumUpToWareHouse(List<BigDecimal> demands, Map<Integer, String> mocks, List<Store> stores) {
		Map<String, BigDecimal> results = new LinkedHashMap<String, BigDecimal>();
		double wh1 = 0;
		double wh2 = 0;
		double wh3 = 0;
		for(int i = 0;i<stores.size();++i) {
			var wh = mocks.get(stores.get(i).getId());
			if("WH1".equals(wh)) {
				wh1+=demands.get(i).doubleValue();
			}else if("WH2".equals(wh)) {
				wh2+=demands.get(i).doubleValue();
			}else {
				wh3+=demands.get(i).doubleValue();
			}
		}
		results.put("WH1", bd(wh1).setScale(1,RoundingMode.HALF_UP));
		results.put("WH2", bd(wh2).setScale(1,RoundingMode.HALF_UP));
		results.put("WH3", bd(wh3).setScale(1,RoundingMode.HALF_UP));
		return results;
	}
	
	public static List<BigDecimal> calcDemands(Map<Integer, BigDecimal> trendFactors, Map<Integer, BigDecimal> mockRefWeights, Map<Item, List<Store>> a55, Map<Item, List<Store>> a77) {
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
		
		List<BigDecimal> demands = new ArrayList<>();
		
		var allWeightRefs = getWeightRefs(mockRefWeights).doubleValue();
		
		for(int i = 0;i<store1.size();++i) {
			BigDecimal trendValue = mockRefWeights.get(store1.get(i).getId());
			if(trendValue == null) {
				trendValue = BigDecimal.ONE;
			}
			double sum = 0;
			sum = (store1.get(i).getPotential().doubleValue() * mockRefWeights.get(item1.getId()).doubleValue() + sum + store2.get(i).getPotential().doubleValue() * mockRefWeights.get(item2.getId()).doubleValue());
			sum/=allWeightRefs;
			sum*=trendValue.doubleValue();
			demands.add(bd(sum).setScale(1, RoundingMode.HALF_UP));
		}
		
		return demands;
	}

	
//	private static BigDecimal calcDemand(BigDecimal potential,Integer storeTrendFactor) {
//		return potential * 
//	}
	
	private static BigDecimal getWeightRefs(Map<Integer, BigDecimal> weightRefs) {
		double sum = 0;
		for(Entry<Integer, BigDecimal> item : weightRefs.entrySet()) {
			sum+=item.getValue().doubleValue();
		}
		return bd(sum).setScale(1, RoundingMode.HALF_UP);
	}

}
