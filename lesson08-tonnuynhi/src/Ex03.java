import java.text.Normalizer;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(removeDiacritics(line));
        }
    }

    private static String removeDiacritics(String s) {
        String x = Normalizer.normalize(s, Normalizer.Form.NFD);
        x = x.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        x = x.replace('Đ', 'D').replace('đ', 'd');
        return x;
    }
}
