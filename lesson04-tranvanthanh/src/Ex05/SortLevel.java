package Ex05;

import java.util.Scanner;

public class SortLevel {

    
    public static void main(String[] args) {
         	
    	Scanner ip = new Scanner(System.in);

        int n;
        do {
            System.out.print("Nhập số phần tử n: ");
            n = ip.nextInt();
        } while (n < 3 || n > 20);

        int[] arr = new int[n];      
        System.out.println("Nhập " + n + " phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = ip.nextInt();
        }

        
              
        System.out.println("\n Mảng ban đầu và level của từng phần tử:");
        for (int x : arr) {
            System.out.println(x + " có level = " + findLevel(x));
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (findLevel(arr[i]) > findLevel(arr[j])) {                   
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    
        System.out.print("\nMảng sau khi sắp xếp theo level tăng dần: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }     
    }
    
    public static int findLevel(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) { 
           	
                count++;
                
            }
        }
        return count;
    }
}