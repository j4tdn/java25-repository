package view;

public class Ex01 {

	public static void main(String[] args) {
		
		String ip = "Đặng Hoàng Huy";
		int length = ip.length();
		
		System.out.println("Moi ki tu 1 dong:");
		for(int i = 0; i < length; i++) {
			System.out.println(ip.charAt(i));
		}

		System.out.println();
		
		System.out.println("Moi tu 1 dong:");
		String[] words = ip.split("[ \\.]+");
		for(String word: words) {
			System.out.println(word);
		}

		System.out.println();
		
		System.out.println("Chuoi dao nguoc theo ki tu:");
		for(int i = length-1; i >= 0; i--) {
			System.out.print(ip.charAt(i));
		}
		
		System.out.println("\n");
		
		System.out.println("Chuoi dao nguoc theo tu:");
		for(int i = words.length-1; i >= 0; i--) {
			System.out.print(words[i] + (i == 0 ? "" : " "));
		}
	}
	
}
