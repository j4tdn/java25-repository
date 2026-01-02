import java.util.Scanner;

public class bai2 {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	      String name = sc.nextLine().trim().toLowerCase();
	      
	      String[] words = name.split("\\s+");
	      String result = "";
	      
	      for (String w : words) {
	            result += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
	        }
	      
	      System.out.println(result.trim());
	}
}
