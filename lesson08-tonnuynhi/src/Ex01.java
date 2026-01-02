import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine().trim();

        if (!isValidVietnameseAndSpace(s)) {
            System.out.println("Chuỗi không hợp lệ! Chỉ được chứa chữ tiếng Việt và khoảng trắng.");
            return;
        }

        printEachChar(s);
        printEachWord(s);
        reverseByChar(s);
        reverseByWord(s);
    }

    private static boolean isValidVietnameseAndSpace(String s) {
        return s.matches("[\\p{L} ]+");
    }

    public static void printEachChar(String s) {
        System.out.println("\nMỗi kí tự:");
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }
    }

    public static void printEachWord(String s) {
        System.out.println("\nMỗi từ trên 1 dòng:");
        String[] words = s.trim().split("\\s+");
        for (String w : words) {
            System.out.println(w);
        }
    }

    public static void reverseByChar(String s) {
        System.out.println("\nChuỗi đảo ngược theo kí tự:");
        System.out.println(new StringBuilder(s).reverse().toString());
    }

    public static void reverseByWord(String s) {
        System.out.println("\nChuỗi đảo ngược theo từ:");
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i]);
            if (i != 0) System.out.print(" ");
        }
        System.out.println();
    }
}
