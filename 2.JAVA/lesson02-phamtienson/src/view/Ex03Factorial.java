package view;
import java.util.Scanner;
public class Ex03Factorial {
	public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int number = ip.nextInt();

       
            System.out.println( number + "!  =  " + factorial(number));
        }
    }
