package utils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import calculation.parameter.RefItemStoreId;
import static java.util.Comparator.*;

public class LogUtils {
	
	private LogUtils() {
	}
	
	public static void log(String message, Object ...arguments) {
		System.out.printf(message + "\n", arguments);
	}
	
	public static void logRefItemStoreLevel(Map<RefItemStoreId, BigDecimal> refItemStoreParams, String columnName) {
		Map<RefItemStoreId, BigDecimal> sortedMap = new TreeMap<>(comparing(RefItemStoreId::getRefItemId).thenComparing(RefItemStoreId::getStoreId));
		sortedMap.putAll(refItemStoreParams);
		
		System.out.printf("%-15s %-15s %-15s\n", "RefItemId", "StoreId", columnName);
		sortedMap.forEach((refItemStoreId, param) -> {
			System.out.printf("%-15s %-15s %-15s\n", refItemStoreId.getRefItemId(), refItemStoreId.getStoreId(), param);
		});
	}
	
	public static void logStoreLevel(Map<Long, BigDecimal> storeParams, String columnName) {
		Map<Long, BigDecimal> sortedMap = new TreeMap<>(storeParams);
		
		System.out.printf("%-15s %-15s\n", "StoreId", columnName);
		sortedMap.forEach((storeId, param) -> {
			System.out.printf("%-15s %-15s\n", storeId, param);
		});
	}
	
}
