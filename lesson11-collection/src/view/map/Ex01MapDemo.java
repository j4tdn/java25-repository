package view.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01MapDemo {
	
	/**
	 * Bài toán
	 * - Lưu trữ danh sách các thành phố và mã biển số xe ở Việt Nam
	 * - Giả sử: mỗi thành phố chỉ hỗ trợ 1 mã số duy nhất
	 *  
	 * HashMap: 
	 * - unordered, unsorted --> hashing data
	 * - allow null key 
	 * 
	 * TreeMap
	 * - unordered, sorted default by Key[implements Comparable] or passing a Comparator
	 * - don't allow null key
	 * - sort by value [self custom]
	 * - special comparing method
	 *   -- Comparator.naturalOrder()
	 *   -- Comparator.reverseOrder()
	 * 
	 * LinkedHashMap
	 * -- ordered, unsorted
	 * -- allow null key 
	 */
	
	public static void main(String[] args) {
		
		Map<String, Integer> models = new LinkedHashMap<>();
		models.put("Quảng Nam", 92);
		models.put("Đà Nẵng", 43);
		models.put("Huế", 75);
		models.put("Quảng Trị", 74);
		models.put("Quảng Bình", 73);
		models.put(null, 9999);
		
		// models.put("Đà Nẵng", 34); // nếu phát hiện key đã 'tồn tại', ghi đè value
		models.putIfAbsent("Đà Nẵng", 34);
		
		// models.remove(null); 
		
		System.out.println("models size: " + models.size());
		System.out.println("model number of 'Quảng Trị': " + models.get("Quảng Trị"));
		System.out.println("model number of 'Quảng Ngãi': " + models.getOrDefault("Quảng Ngãi", -1));
		
		generate("1. Danh sách các phần tử", models);
		
	}
	
	private static void generate(String prefix, Map<String, Integer> map) {
		System.out.println(prefix + " {");
		// duyệt theo key, value, entry
		Set<Entry<String, Integer>> entries = map.entrySet();
		for (Entry<String, Integer> entry: entries) {
			System.out.println("   - " + entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("}\n");
		
	}
	
}
