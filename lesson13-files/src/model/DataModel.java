package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataModel {
	
	private DataModel() {
	}
	
	public static Map<String, Integer> mockModelMap() {
		Map<String, Integer> models = new LinkedHashMap<>();
		models.put("Quảng Nam", 92);
		models.put("Đà Nẵng", 43);
		models.put("TP-Huế", 75);
		models.put("Quảng Trị", 74);
		models.put("Quảng Bình", 73);
		models.put("T-T-Huế", 75);
		return models;
	}
	
	public static List<String> readApplesFromFile() {
		return List.of(
			"1, GREEN, 100, VN",
			"2, BLUE, 200, VN",
			"3, RED, 300, CAM",
			"4, GREEN, 500, LAO",
			"5, PURPLE, 800, VN"
		);
	}
	
}