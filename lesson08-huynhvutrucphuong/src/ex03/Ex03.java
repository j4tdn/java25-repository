package ex03;

import java.text.Normalizer;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            String khongDau = Normalizer.normalize(s, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                    .replace('đ', 'd')
                    .replace('Đ', 'D');

            System.out.println(khongDau);
	}
	}
}
