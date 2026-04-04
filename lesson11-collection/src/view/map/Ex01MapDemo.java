package view.map;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ex01MapDemo {

	/**
	 * Bài toán:
	 * - Store a list of city and license plates in Vietnam
	 * - Assume: each city only support 1 license plate
	 * 
	 * Hashmap: 
	 * 	- unordered, unsorted --> hashing data
	 * 	- allow null key
	 * 
	 * TreeMap:
	 * 	- unordered, sorted by default key[key implements Comparable]
	 * 		or passing a Comparator
	 * 	- sort by value [self custom]
	 * 	- not allow null key
	 * 	- special comparing methods
	 * 		+ Comparator.naturalOrder()
	 * 		+ Comparator.reverseOrder()
	 * 
	 * LinkedHashMap
	 * 	- ordered, unsorted
	 * 	- allow null key
	 */
	public static void main(String[] args) {
		
		Map<String, Integer> models = new TreeMap<String, Integer>();
		models.put("Quảng Nam", 92);
		models.put("Đà Nẵng", 43);
		models.put("Huế", 75);
		models.put("Quảng Trị", 74);
		models.put("Quảng Bình", 73);
//		models.put(null, 9999);
		
//		models.remove(null);
		
		System.out.println("model size --> " + models.size());
		System.out.println("model number of Quảng Trị --> " + models.get("Quảng Trị"));
		System.out.println
			("model number of Quảng Ngãi --> " + models.getOrDefault("Quảng Ngãi", -1));
		
		generate("1. List of all items", models);
		
	}
	
	private static void generate(String prefix, Map<String, Integer> map) {
		System.out.println(prefix + " {");
		var entries = map.entrySet();
		for(Entry<String, Integer> entry : entries) {
			System.out.println("	- " + entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("}\n");
	}
	
}
