package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static utils.NumberUtils.*;

public class ShareWareHouseService {
	
	private ShareWareHouseService() {
		
	}
	
	public static List<BigDecimal> calcShares(Map<String, BigDecimal> demandsPerWH) {
		List<BigDecimal> list = new ArrayList<>();
		List<Double> warehouses = demandsPerWH
				.entrySet()
				.stream()
				.map(it -> it.getValue().doubleValue())
				.toList();
		
		var sumOfWH = warehouses.stream().reduce(0d, (a,b) -> a+b);
		warehouses.forEach(it -> list.add(bd((it / sumOfWH) * 100).setScale(1, RoundingMode.HALF_UP)));
		return list;
	}


}
