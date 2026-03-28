package view.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static util.PrintUtils.*;

public class Ex03MapSortingValues {

	public static void main(String[] args) {

		Map<String, Integer> models = new LinkedHashMap<>();

		models.put("Quang Nam", 92);
		models.put("Da Nang", 43);
		models.put("Hue", 75);
		models.put("Quang Tri", 74);
		models.put("Quang Binh", 73);
		models.put(null, 9999);

		generate("1. DS thanh pho va ma xe", models);

		Map<String, Integer> sortedModels = sort(models, Entry.comparingByValue(Comparator.reverseOrder()));

		generate("2. DS thanh pho va ma xe giam dan", sortedModels);

	}

	private static <K, V> Map<K, V> sort(Map<K, V> source, Comparator<Entry<K, V>> comparator) {
		// Thong thuong sort: duyet va hoan vi cac phan tu trong ds --> return void
		// K the voi map vi k ho tro hoan vi, function sort ben trong map [mac dinh]

		// B1: Chuyen tu map -> list [moi phan tu se la 1 entry]
		List<Entry<K, V>> list = new ArrayList<>(source.entrySet());

		// B2: SX cac entry [key, value] trong list
		// list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		// Ho tro 1 so comparator method dac biet voi Entry.###
		list.sort(comparator);

		// B3: Chuyen cac phan tu ddad dc SX ben trong list ve lai map [moi]
		Map<K, V> target = new LinkedHashMap<>();
		for (Entry<K, V> entry : list) {
			target.put(entry.getKey(), entry.getValue());
		}
		
		return target;
	}

}
