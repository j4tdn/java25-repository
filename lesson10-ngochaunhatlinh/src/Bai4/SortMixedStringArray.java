package Bai4;

import java.util.Arrays;

public class SortMixedStringArray {
	static boolean laSo(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static int getType(String s) {
        if (s == null) return 5;
        if (s.equalsIgnoreCase("Special")) return 1;
        if (laSo(s)) {
            int n = Integer.parseInt(s);
            if (n < 0) return 2;
            else return 3;
        }
        return 4;
    }

    public static void main(String[] args) {

        String[] arr = {"-2","-6","10",null,"4","8",null,"Special","a","c","b","xx"};

        Arrays.sort(arr, (a,b)->{

            int typeA = getType(a);
            int typeB = getType(b);

            if(typeA != typeB) return typeA - typeB;

            if(a == null || b == null) return 0;

            if(laSo(a) && laSo(b))
                return Integer.parseInt(a) - Integer.parseInt(b);

            return a.compareTo(b);
        });

        System.out.println(Arrays.toString(arr));
    }
}
