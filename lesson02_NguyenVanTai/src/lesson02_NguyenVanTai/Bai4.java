package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai4 {
	public static void main(String[] args) {
			Scanner ip =new Scanner(System.in);
			String[] text =new String[4];
			int[] num =new int[4];
			
			long result = 0;
			int count =5;
			System.out.println("Chương trình tính tổng giai thừa");
			while(count>0) {
				
					for(int i=0;i<text.length;i++) {
					System.out.printf("Nhập số thứ " +(i+1)+" ");
					text[i]=ip.nextLine();
					if(isNumber(text[i])) {
						num[i]=Integer.parseInt(text[i]);
						result+=factorial(num[i]);
						
					}else {
						System.out.println("Vui lòng nhập lại");
						--count;
						System.out.println("Bạn còn "+count+" lượt nhập!!");
					}
					
				}
					count=0;
				
			
			}
			System.out.println("Giai thừa của 4 số trên là: "+result);
			ip.close();
	}
	private static boolean isNumber(String text) {
		for(int i=0;i<text.length();i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
			
		}
		return true;
	}
	private static int factorial(int num) {
		int result=1;
		if(num==1 || num ==0) {
			return 1;
		}
		for(int i=2;i<=num;i++) {
			result*=i;
		}
		return result;
	}

}
