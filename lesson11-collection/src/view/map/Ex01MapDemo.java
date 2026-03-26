package view.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Bài toán - Lưu trữ danh sách các thành phố và mã biển số xe ở Việt Nam - Giả
 * sử mỗi thành phố chỉ hỗ trợ 1 mã số duy nhất
 * 
 * HashMap
 * - unordered, unsorted --> hashing data
 * - allow null key
 * 
 * TreeMap
 * - unordered, sorted default by key[implements Comparable] or passing Comparator
 * - prevent null key
 * - sort by value [self custom]
 * - special comparing method
 * 	 -- Comparator.naturalOrder()
 *   -- Comparator.reverseOrder()
 * 
 * LinkedHashMap
 * -- ordered, unsorted
 * -- allow null key
 */

public class Ex01MapDemo {
	public static void main(String[] args) {

//		Map<String, Integer> models = new TreeMap<>((s1,s2) -> s1.compareTo(s2));
//		Map<String, Integer> models = new TreeMap<>(Comparator.reverseOrder());
		Map<String, Integer> models = new LinkedHashMap<>();
		models.put("Quảng Nam", 92);
		models.put("Bình Định", 77);	
		models.put("Cà Mau", 69);
		
		System.out.println("models size: " + models.size());
		System.out.println("model number of Bình Định: " + models.get("Bình Định"));
		
		generate("1. Danh sách các phần tử: ", models);
	}
	
	private static void generate(String prefix,Map<String, Integer> map) {
		System.out.println(prefix +" {");
//		Set<String> keys = map.keySet();
		var entries = map.entrySet();
		for(var entry : entries) {
			System.out.println("   - "+entry.getKey()+": " + entry.getValue());
		}
		System.out.println("}\n");
	}
}
