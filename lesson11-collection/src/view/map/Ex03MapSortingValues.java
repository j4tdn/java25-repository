package view.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static utils.PrintUtils.*;

public class Ex03MapSortingValues {
    
    public static void main(String[] args) {
        Map<String, Integer> models = new LinkedHashMap<>();
        models.put("Quảng Nam", 92);
        models.put("Đà Nẵng", 43);
        models.put("Huế", 75);
        models.put("Quảng Trị", 74);
        models.put("Quảng Bình", 73);

        generate("1. Danh sách thành phố và mã xe", models);

       
        var sortedModels = sort(models, Entry.comparingByValue(Comparator.reverseOrder()));

        generate("2. Danh sách thành phố và mã xe [sắp xếp giảm dần theo mã]", sortedModels);
    }
    
    private static <K, V>  Map<K, V> sort(Map<K, V> source, Comparator<Entry<K, V>> comparator){
    	 // B1: Map -> List (Entry)
        var entries = new ArrayList<>(source.entrySet());

        // B2: Sort theo value giảm dần
        entries.sort(comparator);

        // B3: List -> Map mới
        var target = new LinkedHashMap<K, V>();
        for (var entry : entries) {
            target.put(entry.getKey(), entry.getValue());
        }
        return target;
    }
}