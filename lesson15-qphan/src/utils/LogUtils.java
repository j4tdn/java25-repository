package utils;

import static java.util.Comparator.comparing;

import java.util.Map;
import java.util.TreeMap;

import calculation.parameter.RefItemStoreId;

public class LogUtils {
	
	private LogUtils() {
	}
	
	public static void log(String message, Object ...arguments) {
		System.out.printf(message + "\n", arguments);
	}
	
	public static <T extends Number> void logRefItemStoreLevel(Map<RefItemStoreId, T> refItemStoreParams, String columnName) {
		Map<RefItemStoreId, T> sortedMap = new TreeMap<>(comparing(RefItemStoreId::getRefItemId).thenComparing(RefItemStoreId::getStoreId));
		sortedMap.putAll(refItemStoreParams);
		
		System.out.printf("%-15s %-15s %-15s\n", "RefItemId", "StoreId", columnName);
		sortedMap.forEach((refItemStoreId, param) -> {
			System.out.printf("%-15s %-15s %-15s\n", refItemStoreId.getRefItemId(), refItemStoreId.getStoreId(), param);
		});
	}
	
	public static <T extends Number> void logStoreLevel(Map<Long, T> storeParams, String columnName) {
		Map<Long, T> sortedMap = new TreeMap<>(storeParams);
		
		System.out.printf("%-15s %-15s\n", "StoreId", columnName);
		sortedMap.forEach((storeId, param) -> {
			System.out.printf("%-15s %-15s\n", storeId, param);
		});
	}
	
	public static <T extends Number> void logWhLevel(Map<Long, T> whParams, String columnName) {
		Map<Long, T> sortedMap = new TreeMap<>(whParams);
		
		System.out.printf("%-15s %-15s\n", "WhId", columnName);
		sortedMap.forEach((whId, param) -> {
			System.out.printf("%-15s %-15s\n", whId, param);
		});
	}
	
}
