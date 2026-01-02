import java.util.Scanner;

public class bai1 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println("In mỗi ký tự trên một dòng: ");
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println("In ra mỗi từ trên một dòng: ");
		String[] n = s.split(" ");
		for(String w : n) {
			System.out.println(w);
		}
		
		System.out.println("Chuỗi đảo ngược theo kí tự: ");
		String t = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			t += s.charAt(i);
		}
		System.out.println(t);
		System.out.println("Chuỗi đảo ngược theo từ");
		for(int i = n.length - 1; i >= 0; i--) {
			System.out.println(n[i] + " ");
		}
	}

}
