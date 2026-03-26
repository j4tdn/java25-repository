package view.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static utils.PrintUtils.*;

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
		
		
		// Thông thường sort: duyệt và hoán vị các phần tử bên trong danh sách --> return void
		// Không thể với map vì ko thể hỗ trợ hoán vị, function sort bên trong map [mặc định]
		
		// B1: Chuyển từ map -> set -> list [mỗi phần tử sẽ là 1 entry]
		List<Entry<String, Integer>> list = new ArrayList<>(models.entrySet());
		
		// B2: Sắp xếp các entry [key, value] trong list
		// VD: (e1, e2) -> e2.getValue().compareTo(e1.getValue())
		
		// Hỗ trợ 1 số comparator method đặc biệt với Entry.###
		list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		
		// B3: Chuyển các phần tử đã được sắp xếp bên trong list về lại map [mới]
		Map<String, Integer> sortedModels = new LinkedHashMap<>();
		for (Entry<String, Integer> entry: list) {
			sortedModels.put(entry.getKey(), entry.getValue());
		}
		
		// Về nhà: tự chuyển đổi B1, B2, B3 trên thành một hàm riêng
		// cho phép sort bất kỳ map nào và truyền Comparator vào
		
		generate("2. Danh sách thành phố và mã xe[sắp xếp theo mã xe giảm dần]", sortedModels);
		
	}
	
	
	
}
