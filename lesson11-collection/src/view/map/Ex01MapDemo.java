package view.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01MapDemo {

	/**
	 * Bai toan
	 * - Luu tru ds cac thanh pho va ma bien so xe o VN
	 * - Gia su moi thanh pho chi ho tro 1 ma so duy nhat
	 * 
	 * HashMap: 
	 * - unodered, unsorted --> hashing data
	 * - allow null key
	 * 
	 * TreeMap
	 * - unordered, sorted default by key[implements Comparable] or passing a Comparator
	 * - don't allow null key
	 * - sort by value [self custom]
	 * - special comparing method
	 * -- Comparator.naturalOrder()
	 * -- Comparator.reserveOrder()
	 * 
	 * LinkedHashMap
	 * -- ordered, unsorted
	 * -- allow null key
	 */
	
	public static void main(String[] args) {
		
		Map<String, Integer> models = new LinkedHashMap<>();
		
		models.put("Quang Nam", 92);
		models.put("Da Nang", 43);
		models.put("Hue", 75);
		models.put("Quang Tri", 74);
		models.put("Quang Binh", 73);
//		models.put(null, 9999);
		
		//models.put("Da Nang", 34); // neu phat hien key da ton tai, ghi de value
		models.putIfAbsent("Da Nang", 34);
		
//		models.remove(null);
		
		System.out.println("models size: " + models.size());
		System.out.println("models number of 'Quang Tri': " + models.get("Quang Tri"));
		System.out.println("models number of 'Quang Ngai': " + models.getOrDefault("Quang Ngai", -1));
		
		generic("\n1. DS cac phan tu", models);
	}
	
	private static void generic(String prefix, Map<String, Integer> map) {
		System.out.println(prefix + " {");
		// duyet theo key, value, entry
		Set<Entry<String, Integer>> entries = map.entrySet();
		for(Entry<String, Integer> entry: entries) {
			System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println("}\n");
	}
}
