package view;

import java.util.*;

public class Ex02 {

	public static String[] getLargestNumbers(String[] ss) {
		List<Integer> list = new ArrayList<>();
		
		for(String s : ss) {
			int max = 0;
			String tem = "";
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if(Character.isDigit(c)) {
					tem += c;
				} else {
					if (!tem.isEmpty()) {
						int num = Integer.parseInt(tem);
						if (num > max) max = num;
						tem = "";
					}
				}
			}
			if (!tem.isEmpty()) {
				int num = Integer.parseInt(tem);
				if (num > max) max = num;
			}
			list.add(max);
		}
		Collections.sort(list);
		
		String[] result = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = String.valueOf(list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập n(số lượng chuỗi): ");
		int n = Integer.parseInt(sc.nextLine());
		
		String arr[] = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
			
		}
		String[] result = getLargestNumbers(arr);
		System.out.println();
		for(String s : result) {
			System.out.println(s + " ");
		}
	}
}
