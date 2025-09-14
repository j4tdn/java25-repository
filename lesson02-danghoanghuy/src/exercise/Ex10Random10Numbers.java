package exercise;

import java.util.Random;

public class Ex10Random10Numbers {
	public static void main(String[] args) {
		Random rd = new Random();
	        int[] result = new int[5];
	        int count = 0;

	        while (count < 5) {
	        	int number = rd.nextInt(20, 30);
	            boolean available = false;
	            for (int i = 0; i < count; i++) {
	                if (result[i] == number) {
	                    available = true;
	                    break;
	                }
	            }
	            if (!available) {
	                result[count] = number;
	                count++;
	            }
	        }
	        for (int i = 0; i < 5; i++) {
	        	System.out.println(result[i]);
	        	}
	    }
}
