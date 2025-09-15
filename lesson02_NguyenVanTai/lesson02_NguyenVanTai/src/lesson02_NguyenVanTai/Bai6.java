package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai6 {
public static void main(String[] args) {
	Scanner ip =new Scanner(System.in);
	int[] arr=new int[3];
	String[] text=new String[3];
	
	int count=6;
	int num =0;
			while(count>0) {
				for(int i=0;i<text.length;i++) {
				System.out.printf("Vui lòng nhập số thứ %s: ",(i+1));
				text[i]=ip.nextLine();
				if(isNumber(text[i])) {
					
					arr[i]=Integer.parseInt(text[i]);
					num++;
					if(num>arr.length-1) {
					bubbleSort(arr);
					count =0;
					}
					
				}else {
					count--;
					System.out.println("Nhập sai rồi vui lòng nhập lại");
					System.out.println("Bạn còn: "+count+" lần nhập");
				}
			
			}
				
			
			}		
	
	System.out.println(bubbleSort(arr));
	ip.close();
}
private static boolean isNumber(String text) {
	for(int i=0;i<text.length();i++) {
		if(!Character.isDigit(text.charAt(i))){
			return false;
		}
	}
	return true;
}
private static String bubbleSort(int[] arr) {
	for(int i=0;i<arr.length-1;i++) {
		for(int j=0;j<arr.length-1-i;j++) {
			if(arr[j]>arr[j+1]) {
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	
	}
	return "Số lớn nhất là: "+arr[arr.length-1]+"\nSố bé nhất là: "+arr[0] ;
	
}
}
