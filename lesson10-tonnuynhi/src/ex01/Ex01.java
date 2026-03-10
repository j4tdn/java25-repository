package ex01;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int n;

        do {
            System.out.print("Nhập số phần tử n (0 < n < 10): ");
            n = sc.nextInt();
        } while (n <= 0 || n >= 10);

        int[] arr = new int[n];
        System.out.print("Mảng ngẫu nhiên: ");
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(41) + 10; 
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n----------------------------");

        handleRemoveDuplicates(arr);
        handleCompareAvg(arr);
        handleFindThirdMax(arr);
        
        sc.close();
    }

    public static void handleRemoveDuplicates(int[] arr) {
        System.out.print("1. Các phần tử không bị trùng: ");
        boolean hasUnique = false;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(arr[i] + " ");
                hasUnique = true;
            }
        }
        if (!hasUnique) System.out.print("Không có số nào duy nhất.");
        System.out.println();
    }

    public static void handleCompareAvg(int[] arr) {
        int mid = arr.length / 2;
        if (mid == 0) {
            System.out.println("2. Mảng quá ngắn để chia đôi.");
            return;
        }

        double sumStart = 0, sumEnd = 0;
        for (int i = 0; i < mid; i++) {
            sumStart += arr[i];
        }
        for (int i = arr.length - 1; i >= arr.length - mid; i--) {
            sumEnd += arr[i];
        }

        double avgStart = sumStart / mid;
        double avgEnd = sumEnd / mid;

        System.out.printf("2. TB %d số đầu: %.2f | TB %d số cuối: %.2f\n", mid, avgStart, mid, avgEnd);
        if (avgStart > avgEnd) System.out.println("=> Nửa đầu có TB lớn hơn.");
        else if (avgStart < avgEnd) System.out.println("=> Nửa cuối có TB lớn hơn.");
        else System.out.println("=> Hai nửa bằng nhau.");
    }

    public static void handleFindThirdMax(int[] arr) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);

        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length - 1 - i; j++) {
                if (temp[j] < temp[j + 1]) {
                    int t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }
            }
        }

        int distinctCount = 1;
        int result = -1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] < temp[i - 1]) {
                distinctCount++;
            }
            if (distinctCount == 3) {
                result = temp[i];
                break;
            }
        }

        if (result != -1) {
            System.out.println("3. Số lớn thứ 3 (sau khi loại trùng): " + result);
        } else {
            System.out.println("3. Không đủ 3 giá trị khác nhau để tìm số lớn thứ 3.");
        }
    }
}