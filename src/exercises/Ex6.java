package exercises;

import java.util.Scanner;

public class Ex6 {
    private static final Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) {
        int[] numbers = input(); 

        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Số lớn nhất là: " + max);
        System.out.println("Số nhỏ nhất là: " + min);
    }

    private static int[] input() {
        int[] arr = new int[3]; 

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Nhập số thứ " + (i + 1) + " từ (0 - 19): ");
                String input = sc.nextLine();

                try {
                    int value = Integer.parseInt(input);

                    if (value >= 0 && value < 20) {
                        arr[i] = value; 
                        break; 
                    } else {
                        System.out.println("Số phải nằm trong khoảng [0, 20).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nhập lại số nguyên hợp lệ!");
                }
            }
        }

        return arr; 
    }
}

