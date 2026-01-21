package view;

public class Ex05Test02 {

    // Hàm tính tổng
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

    // Hàm tính tích
    public static int productArray(int[] arr) {
        int product = 1;
        for (int x : arr) product *= x;
        return product;
    }

    // Hàm tìm giá trị lớn nhất
    public static int maxArray(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
        }
        return max;
    }

    // Hàm tìm giá trị nhỏ nhất
    public static int minArray(int[] arr) {
        int min = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -1, 10};

        System.out.println("Tổng = " + sumArray(arr));
        System.out.println("Tích = " + productArray(arr));
        System.out.println("Max = " + maxArray(arr));
        System.out.println("Min = " + minArray(arr));
    }
}