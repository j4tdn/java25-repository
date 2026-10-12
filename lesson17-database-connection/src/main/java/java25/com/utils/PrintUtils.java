package java25.com.utils;

import java.util.Collection;

public class PrintUtils {
    private PrintUtils() {
    }

    public static <T> void generate(String text, Collection<T> elements) {
        System.out.println(text + " {");
        elements.forEach(element -> {
            System.out.println(" - " + element);
        });
        System.out.println("}\n");
    }
}
