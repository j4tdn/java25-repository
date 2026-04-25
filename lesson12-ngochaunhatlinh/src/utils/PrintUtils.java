package utils;

import java.util.List;

public class PrintUtils {
    private PrintUtils() {
    }

    public static <T> void generate(String title, List<T> list) {
        System.out.println("\n" + title);
        list.forEach(System.out::println);
    }

    public static void generate(String title, Object data) {
        System.out.println("\n" + title);
        System.out.println(data);
    }
}