import java.util.Scanner;

public class bai7 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int max = 1, min = s.length();
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                max = Math.max(max, count);
                min = Math.min(min, count);
                count = 1;
            }
	}
        max = Math.max(max, count);
        min = Math.min(min, count);

        System.out.println("Độ dài lớn nhất: " + max);
        System.out.println("Độ dài nhỏ nhất: " + min);
	}

}
