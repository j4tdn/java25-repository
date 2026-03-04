package Ex04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] arr = {
                "-2", "-6", "10", null, "4", "8",
                null, "Special", "a", "c", "b", "xx"
        };

        // tăng dần
        Arrays.sort(arr, new StringComparator(SortOrder.ASC));
        System.out.println("ASC : " + Arrays.toString(arr));

        // giảm dần
        Arrays.sort(arr, new StringComparator(SortOrder.DESC));
        System.out.println("DESC: " + Arrays.toString(arr));
    }
}