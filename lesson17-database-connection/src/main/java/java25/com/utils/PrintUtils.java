package java25.com.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

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

    public static <T> void generate(String text, T element) {
        System.out.println(text + " {");
        if (element == null) {
            System.out.println("Khong tim thay ...");
            return;
        }
        System.out.println(" - " + element);
        System.out.println("}\n");
    }
    public static <T, R> void generate(String text, Collection<T> elements, Function<T, List<R>> getterObjects) {
        System.out.println(text + " {");
        elements.forEach(element -> {
            System.out.println("  - " + element);
            List<R> objects = getterObjects.apply(element);
            objects.forEach(object -> {
                System.out.println("    - " + object);
            });
        });
        System.out.println("}\n");
    }


}
