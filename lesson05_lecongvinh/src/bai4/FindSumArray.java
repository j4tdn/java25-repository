package bai4;

public class FindSumArray {
	public static void main(String[] args) {
		int[] a = {1, 5, 8, 9, 2, 5, 9};
		int[] numbers ;
		int count =0;
			
		
		for(int i=0; i < a.length;i++) {
			boolean check =true;
			int value = a[i];
			
			
			for(int j=0; j<i;j++) {
				if(value==a[j]) {
					check =false;
					break;
					}
				}
			
			if(check) { 
				
				a[count]=value;
				count++;
					}
				}
		
		int max = 0;
		int min=a[0];
		int total= 0;
		
		for(int i=0;i<count;i++) {
			if(a[i]<min) {
				min = a[i];
			}
			if(a[i]>max) {
			max = a[i];	
			}
		}
		for(int i=0; i<count;i++) {
			total= total +a[i];
		}
		
		
		System.out.println("Giá trị min và max trong Mảng a là: "+min +" "+max );
	System.out.println("Tổng các phần tử không trùng nhau trong mảng trừ max và min: " +(total -max -min));
	}
	
	
	}

