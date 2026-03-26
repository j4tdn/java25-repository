package view.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static utils.PrintUtils.*;

public class Ex03MapSorting {
	
	public static void main(String[] args) {
		Map<String, Integer> models = new LinkedHashMap<>();
		models.put("Bình Định", 77);	
		models.put("Quảng Nam", 92);
		models.put("Cà Mau", 69);
		
		generate("1. Danh sách tỉnh và mã xe", models);
		
		List<Entry<String, Integer>> list = new ArrayList<>(models.entrySet());
		
		// Hỗ trợ một số comparator method đặc biệt trong Entry
		
		list.sort((s1, s2) -> {
			return s2.getValue() - s1.getValue();
		});

		
		Map<String, Integer> sortedModels = new LinkedHashMap<>();
		
		for(var entry : list) {
			sortedModels.put(entry.getKey(), entry.getValue());
		}
		
		// về nhà: tự chuyển đổi B1,B2,B3 trên thành một hàm riêng
		// cho phép sort bất kỳ map và truyền Comparator vào
	
		generate("2. Danh sách tỉnh và mã xe(sắp xếp mã xe giảm dần)", sortedModels);
	}

}
