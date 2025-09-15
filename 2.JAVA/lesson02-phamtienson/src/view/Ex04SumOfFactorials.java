package view;
import java.util.Random;
public class Ex04SumOfFactorials {
	public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
    	
        Random random = new Random();
        int a = random.nextInt(10, 21); 
        int b = random.nextInt(10, 21); 
        int c = random.nextInt(10, 21); 
        int d = random.nextInt(10, 21); 
   
        long S = factorial(a) + factorial(b) + factorial(c) + factorial(d);
        System.out.println("Tổng giai thừa của các số nguyên S = " + a + "! + " + b + "! + " + c + "! + " + d + "! = " + S);
    }
}
