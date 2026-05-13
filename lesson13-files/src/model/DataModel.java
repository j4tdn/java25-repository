package model;


import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bean.Apple;
import common.Color;

public class DataModel {

	private DataModel() {
	}
	
	public static List<Apple> mockAppleList() {
		return List.of(new Apple(1, Color.GREEN, bd("100"), "VN"), new Apple(2, Color.BLUE, bd("200"), "LAO"),
				new Apple(3, Color.RED, bd("300"), "CAM"), new Apple(4, Color.GREEN, bd("500"), "VN"),
				new Apple(5, Color.BLUE, bd("200"), "VN"), new Apple(6, Color.RED, bd("600"), "VN"),
				new Apple(7, Color.GREEN, bd("400"), "LAO"), new Apple(8, Color.PURPLE, bd("220"), "CAM"));
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
		return List.of("1, GREEN, 100, VN", "2, BLUE, 200, VN", "3, RED, 300, CAM", "4, GREEN, 500, LAO",
				"5, PURPLE, 800, VN");
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

}
