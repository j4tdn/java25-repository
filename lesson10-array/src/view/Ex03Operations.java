package view;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex03Operations {
public static void main(String[] args) {
		
		//length: 5
		String[] seqs = {"A","T","Z","X","D"};
		
		
	/*
	 -Viết hàm trả về mảng mới 
	 - Thêm 1 phần tử vào vị trí bất kì trong mảng seqs
	 - Xoá 1 phần tử tại ví trí bất kì trong mảng seqs
	 */
		
		System.out.println("Thêm mới phần tử E vào vị trí 0--> "+Arrays.toString(add(seqs, 0, "E")));
		System.out.println("Thêm mới phần tử E vào vị trí 3--> "+Arrays.toString(insert(seqs, 0, "E")));
		System.out.println("Xoá phần tử thứ 1--> "+Arrays.toString(remove(seqs, 1)));

	}
	
	private static String[] remove(String[] source, int pos) {

		String[] target = Arrays.copyOfRange(source, 0, source.length);
		
		//dịch trái 1 đơn vị
		for(int i=pos; i< target.length -1 ;i++) {
			target[i] = target[i+1];
		}
		
		return Arrays.copyOfRange(target, 0, target.length-1);
	}
	
	
	
	private static String[] add(String[] source , int pos, String newVal) {
		
		String[] target = new String[source.length+1];
	//Thêm với copy từng phần 
//		for(int i = 0; i<source.length; i++) {
//			if(i<pos) {
//				target[i] = source[i];
//				
//			}else {
//				target[i+1]=source[i];
//				
//			}
//		}
//		target[pos] = newVal;
//		
//		return target;
//	}
	
		for(int i = 0; i<target.length; i++) {
			target[i] = (i<pos) ? source[i] : (i==pos) ? newVal : source[i-1];
		}
		return target;
	
	}
	
	//Cách 2 : thêm với copy toàn bộ rồi dịch phải 
	
private static String[] insert(String[] source , int pos, String newVal) {
		
		String[] target = new String[source.length+1];
		
		for(int i = 0; i<source.length; i++) {
			target[i]= source[i];
		}

		for(int i = target.length -1 ; i>pos;i--) {
			target[i] = target[i-1];
		}
		
		target[pos] = newVal;
		
		
		return target;

}
}
