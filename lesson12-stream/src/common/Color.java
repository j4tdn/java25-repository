package common;

import java.util.HashMap;
import java.util.Map;

public enum Color {
	RED,
	ORANGE,
	YELLOW,
	GREEN,
	BLUE,
	BROW,
	PURPLE;
	
	private static Map<String, Color> stringToEnums = new HashMap<>();
	
	static {
		for (Color color: Color.values()) {
			stringToEnums.put(color.name(), color); // 'RED', RED - 'ORANGE', ORANGE
		}
	}
	
	public static Color readValueFromString(String stringVal) {
		return stringToEnums.get(stringVal);
	}
}