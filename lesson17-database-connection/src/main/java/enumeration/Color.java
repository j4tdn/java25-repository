package enumeration;

public enum Color {
	RED,
	GREEN,
	BLUE,
	WHITE,
	BLACK,
	YELLOW,
	ORIGIN,
	ORANGE,
	GREY,
	GRAY;
	
	public static Color getName(String value) {
		return Color.valueOf(value);
	}
}