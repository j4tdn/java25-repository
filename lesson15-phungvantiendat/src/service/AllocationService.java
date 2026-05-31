package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.NumberUtils.*;

public class AllocationService {
	
	private AllocationService() {
		
	}
	
	public static List<BigDecimal> allocateByShares(List<BigDecimal> shareWHs, Integer planningAmount) {
		List<BigDecimal> allocationAmounts = new ArrayList<BigDecimal>();
		var data = shareWHs.stream().map(BigDecimal::doubleValue).toList();
		data.stream()
			.forEach(it -> allocationAmounts.add(bd((it/100)*planningAmount).setScale(8,RoundingMode.HALF_UP)));
		return allocationAmounts;
	}
	
	public static List<BigDecimal> applyMinimums(List<BigDecimal> allocationAmountWHs, Integer minPerStore, Map<Integer, Integer> amountPerStores) {
		List<Double> list = new ArrayList<>();
		for(int i = 0;i<allocationAmountWHs.size();++i) {
			var amountEachStore = amountPerStores.get(i + 1);
			if(allocationAmountWHs.get(i).doubleValue() < minPerStore * amountEachStore) {
				list.add(Math.max(allocationAmountWHs.get(i).doubleValue(), minPerStore * amountEachStore));
			}
		}
		return list.stream().map(it -> bd(it.doubleValue())).toList();
	}
	
	public static List<BigDecimal> reAllocateShareWH(List<BigDecimal> allocationAmountWHs, Integer planningAmount) {
		var result = allocationAmountWHs.stream()
				.map(BigDecimal::doubleValue)
				.reduce(0d, (a,b) -> a + b);
		
		List<BigDecimal> shareNewWHs = new ArrayList<BigDecimal>();
		
		for(int i = 0;i<allocationAmountWHs.size();++i) {
			if(allocationAmountWHs.get(i).doubleValue() > 0d) {
				shareNewWHs.add(bd(allocationAmountWHs.get(i).doubleValue()/result).setScale(2,RoundingMode.HALF_UP));
			}
		}
		return shareNewWHs;
	}

}
