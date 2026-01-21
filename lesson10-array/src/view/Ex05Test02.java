	/*
	 Cho một mảng số nguyên gồm N phần tử
	 Viết chương trình
	 + Tìm tổng các phần tử trong mảng
	 + Tìm tích các phần tử trong mảng
	 + Tìm giá trị lớn nhất trong mảng
	 + Tìm giá trị nhỏ nhất trong mảng
	 
	 1: Mỗi yêu cầu viết 1 hàm để xử lý
	 2: Viết duy nhất 1 hàm để xử lý cho 4 yêu cầu trên
	 */
	
package view;

public class Ex05Test02 {

    // ====== (1) Mỗi yêu cầu 1 hàm ======
    public static int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    public static long product(int[] arr) {
        long p = 1;
        for (int i = 0; i < arr.length; i++) {
            p *= arr[i];
        }
        return p;
    }

    public static int max(int[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mx) mx = arr[i];
        }
        return mx;
    }

    public static int min(int[] arr) {
        int mn = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < mn) mn = arr[i];
        }
        return mn;
    }

    // ====== (2) Viết duy nhất 1 hàm xử lý cho 4 yêu cầu ======
    // type: 1=sum, 2=product, 3=max, 4=min
    // trả về long để dùng chung (sum có thể vừa int, product có thể lớn)
    public static long calc(int[] arr, int type) {
        if (arr == null || arr.length == 0) return 0;

        if (type == 1) { // sum
            long s = 0;
            for (int i = 0; i < arr.length; i++) s += arr[i];
            return s;
        }

        if (type == 2) { // product
            long p = 1;
            for (int i = 0; i < arr.length; i++) p *= arr[i];
            return p;
        }

        if (type == 3) { // max
            long mx = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > mx) mx = arr[i];
            }
            return mx;
        }

        if (type == 4) { // min
            long mn = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < mn) mn = arr[i];
            }
            return mn;
        }

        return 0; // type không hợp lệ
    }

    // Demo
    public static void main(String[] args) {
        int[] a = { 2, 5, -3, 10, 7 };

        // Cách 1
        System.out.println("Tong = " + sum(a));
        System.out.println("Tich = " + product(a));
        System.out.println("Max  = " + max(a));
        System.out.println("Min  = " + min(a));

        // Cách 2
        System.out.println("Tong (calc) = " + calc(a, 1));
        System.out.println("Tich (calc) = " + calc(a, 2));
        System.out.println("Max  (calc) = " + calc(a, 3));
        System.out.println("Min  (calc) = " + calc(a, 4));
    }
}
