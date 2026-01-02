import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập họ tên: ");
        String s = sc.nextLine();

        if (!isValidName(s)) {
            System.out.println("Họ tên không hợp lệ! Chỉ được chứa các kí tự [A-Za-z ]");
            return;
        }

        System.out.println(formatName(s));
    }

    private static boolean isValidName(String s) {
        if (s == null) return false;
        String trimmed = s.trim();
        if (trimmed.isEmpty()) return false;
        return trimmed.matches("[A-Za-z ]+");
    }

    private static String formatName(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String w = words[i].toLowerCase();
            String formatted = Character.toUpperCase(w.charAt(0)) + w.substring(1);
            sb.append(formatted);
            if (i < words.length - 1) sb.append(" ");
        }

        return sb.toString();
    }
}