package model;

import java.util.List;

import bean.Apple;
import common.Color;

import static utils.NumberUtils.*;

public class DataModel {
	
	private DataModel() {
	}
	
	public static List<Apple> mockAppleList() {
		return List.of(
			new Apple(1, Color.GREEN, bd("100"), "VN"),
			new Apple(2, Color.BLUE, bd("200"), "LAO"),
			new Apple(3, Color.RED, bd("300"), "CAM"),
			new Apple(4, Color.GREEN, bd("500"), "VN"),
			new Apple(5, Color.BLUE, bd("200"), "VN"),
			new Apple(6, Color.RED, bd("600"), "VN"),
			new Apple(7, Color.GREEN, bd("400"), "LAO"),
			new Apple(8, Color.PURPLE, bd("220"), "CAM")
		);
	}
	
}
