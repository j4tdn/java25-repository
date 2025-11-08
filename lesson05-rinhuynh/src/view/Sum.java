package view;

public class Sum {
	public static void main(String[] args) {
		int[] a = {1,4,2,4,6,4,6,8,9,5,4,10};
		System.out.println("tong mang duoc tinh theo yeu cau la: " + sum(a));
	}
	
	private static int sum(int[] a) {
		int[] x = new int[a.length];
		int count = 0;
		
		for(int value : a) {
			int z = 0;
			for(int i = 0; i < count; i++) {
				if(value == x[i]) {
					z =1;
					break;
				}
			}
			if(z == 0) {
				x[count] = value;
				count++;
			}
		}
			
			if (count <=2) return 0;
			
			int min = x[0];
			int max = x[0];
			
			for(int i = 1; i < count; i++) {
				if ( x[i] < min) min = x[i];
				if ( x[i] > max) max = x[i];
			}
			
			int sum = 0;
			for(int value  : x) {
				if ( value != min && value != max && value != 0) {
					sum+= value;
				}
			}
			
			return sum;
		}
		
	}

