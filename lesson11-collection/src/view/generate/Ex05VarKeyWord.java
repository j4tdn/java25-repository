package view.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;

import bean.Item;

public class Ex05VarKeyWord {

    /*
     * var: xuất hiện từ JDK 10
     * - thay vì khai báo loại KDL bên trái
     * - thay thế bằng từ khóa var
     * - dựa vào giá trị vế phải để xác định KDL tại compile time
     *
     * Java: var (block scope)
     *
     * mục đích:
     * - giúp code ngắn gọn hơn
     * - giúp dễ đọc hơn trong một số trường hợp
     */

    public static void main(String[] args) {

        // Cách 1: khai báo thông thường
        char a1 = '#';
        String b1 = "welcome";
        Item c1 = new Item();
        List<Item> d1 = new ArrayList<>();
        List<Entry<Integer, String>> e1 = new ArrayList<>();
        List<Entry<Integer, String>> f1 = callList();

        Predicate<String> g1 = (String s) -> {
            return s.compareTo("a") > 0;
        };

        Predicate<String> h1 = (String s) -> {
            return s.compareTo("a") > 0;
        };

        // Cách 2: dùng var
        var a2 = '#';
        var b2 = "welcome";
        var c2 = new Item();
        var d2 = new ArrayList<>();
        var d3 = new ArrayList<Item>();
        var e2 = new ArrayList<Entry<Integer, String>>();
        var f2 = callList();

        Predicate<String> g2 = (String s) -> {
            return s.compareTo("a") > 0;
        };
    }

    private static List<Entry<Integer, String>> callList() {
        return List.of();
    }
}