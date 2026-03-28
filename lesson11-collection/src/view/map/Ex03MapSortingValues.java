package view.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex03MapSortingValues {

    public static void main(String[] args) {
        Map<String, Integer> models = new HashMap<>();
        models.put("Quảng Nam", 92);
        models.put("Đà Nẵng", 43);
        models.put("Huế", 75);
        models.put("Quảng Trị", 74);
        models.put("Quảng Bình", 73);
        // models.put(null, 9999);

        generate("1. Danh sách thành phố và mã xe", models);

        var sortedModels = sort(models, Entry.comparingByValue(Comparator.reverseOrder()));

        generate("2. Danh sách thành phố và mã xe [sắp xếp theo mã xe giảm dần]", sortedModels);
    }

    private static <K, V> Map<K, V> sort(Map<K, V> source, Comparator<Entry<K, V>> comparator) {
        var entries = new ArrayList<>(source.entrySet());
        entries.sort(comparator);
        var target = new LinkedHashMap<K, V>();
        for (var entry : entries) {
            target.put(entry.getKey(), entry.getValue());
        }
        return target;
    }

    private static <K, V> void generate(String title, Map<K, V> map) {
        System.out.println(title);
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }
}