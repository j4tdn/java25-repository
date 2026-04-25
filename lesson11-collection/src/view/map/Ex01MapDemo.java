package view.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01MapDemo {
	
	/*
	 * Bài toán
	 * -Lưu trữ danh schs các thành phố mã biến số xe ở Việt Nam
	 * -Giả sử: mỗi thành phố chỉ hỗ trợ 1 mã số duy nhất
	 * 
	 * HashMap: 
	 * - unorderes, únorted --> hashing data
	 * -allow null key
	 * 
	 * TreeMap
	 * -unordered, sorted default by key(inplements Comparable] or passing a Comparator
	 * - dont't allow null key
	 * - sort by value [self custom]
	 * Comparator.naturalOrder()
	 * Comparator.reverseOrder()
	 * 
	 * LinkedHashMap
	 * --ordered, unsorted
	 * --alow null key
	 * 
	 */
	
	public static void main(String[] args) {
		
		Map<String, Integer> models = new LinkedHashMap<>();
		models.put("Quảng Nam", 92);
		models.put("Đà nẵng", 43);
		models.put("Huế", 75);
		models.put("Quảng Trị", 74);
		models.put("Quảng Bình", 73);
		models.put(null, 999);
		
		models.putIfAbsent("Đà Nẵng", 34); // nếu phát hiện key đã tồn tại, ghi đè value
		
		System.out.println("models size: " + models.size());
		System.out.println("Model number of 'Quảng Trị': " + models.get("Quảng TRị"));
		System.out.println("Model number of 'Quảng Ngãi': " + models.getOrDefault("Quảng Ngãi", -1));
		
		generate("1. Danh sách các phần tử", models);
	}
	
	private static void generate(String prefix, Map<String, Integer> map) {
		System.out.println(prefix + "{");
		// duyệt theo key, value, entry
		Set<Entry<String, Integer>> entries = map.entrySet();
		for(Entry<String, Integer> entry: entries) {
			System.out.println("  -" + entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("}\n");
	}

}
