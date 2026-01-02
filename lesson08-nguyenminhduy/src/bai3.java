import java.text.Normalizer;
import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String s = sc.nextLine();
	     
	     String noAccent = Normalizer.normalize(s, Normalizer.Form.NFD);
	     noAccent = noAccent.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

	     System.out.println(noAccent);
	}

}
