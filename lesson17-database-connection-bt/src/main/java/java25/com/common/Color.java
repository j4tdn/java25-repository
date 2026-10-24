package java25.com.common;

public enum Color {
    RED,
    GREEN,
    BLUE,
    WHITE,
    BLACK,
    YELLOW,
    ORIGIN,
    GRAY,
    GREY;

    public static Color getName(String name) {
        return Color.valueOf(name);
    }
}
