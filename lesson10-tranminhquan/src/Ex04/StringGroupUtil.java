package Ex04;

public class StringGroupUtil {

    public static int getGroupAsc(String s) {
        if (s == null) return 4;
        if (s.equalsIgnoreCase("Special")) return 0;

        if (isNumber(s)) {
            return Integer.parseInt(s) < 0 ? 1 : 2;
        }
        return 3;
    }

    public static int getGroupDesc(String s) {
        if (s == null) return 0;
        if (s.equalsIgnoreCase("Special")) return 4;

        if (isNumber(s)) {
            return Integer.parseInt(s) > 0 ? 2 : 3;
        }
        return 1;
    }

    // check
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
