package ex03;

public class Ex03 {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		System.out.println("adas");
		//1.Loại bỏ khoảng trắng 
		s = s.trim();
		while (s.contains("  ")) {
			s = s.replace(" ", " ");
			
		}
		
		
		//2.Đảo chuỗi 
		String[] words = s.split(" ");
		String result = "";
		for(int i = 0; i< words.length;i++) {
			String reversed = "";
			
			for(int j = words[i].length() - 1 ; j>=0;j--) {
				reversed += words[i].charAt(j);
				
			}
			result += reversed;
			if(i< words.length - 1) {
				result += "";
				
			}
		}
		System.out.printf("Result: %s ",result);
	}
}
