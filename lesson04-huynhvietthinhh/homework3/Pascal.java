package bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Pascal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so hang cua tam giac Pascal: ");
        int rows = scanner.nextInt();
        scanner.close();
        
        if (rows <= 0) {
            System.out.println("So hang phai lon hon 0");
            return;
        }
        
        List<List<Integer>> triangle = generatePascalTriangle(rows);
        printPascalTriangle(triangle);
    }

  
    public static List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                  
                    row.add(1);
                } else {
                    int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(value);
                }
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }

    public static void printPascalTriangle(List<List<Integer>> triangle) {
        System.out.println("\nTam giac Pascal:");
        
        for (List<Integer> row : triangle) {
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i));
                if (i < row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

