package view;

public class Ex05Test02 {
	
	
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
	
	 public static void main(String[] args) {
	        int[] a = { 2, 5, -3, 10, 7 };

	       
	        System.out.println("Tổng: " + sum(a));
	        System.out.println("Tích:  " + mul(a));
	        System.out.println("Max: " + max(a));
	        System.out.println("Min: " + min(a));

	        
	        System.out.println("\n===============================\n");
	        
	        System.out.println("Tổng: " + oneForAll(a, 1));
	        System.out.println("Tích: " + oneForAll(a, 2));
	        System.out.println("Max:" + oneForAll(a, 3));
	        System.out.println("Min: " + oneForAll(a, 4));
	    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    public static long mul(int[] arr) {
        long p = 1;
        for (int i = 0; i < arr.length; i++) {
            p *= arr[i];
        }
        return p;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

   
    public static long oneForAll(int[] arr, int type) {
        if (arr == null || arr.length == 0) return 0;

        if (type == 1) { 
            long s = 0;
            for (int i = 0; i < arr.length; i++) s += arr[i];
            return s;
        }

        if (type == 2) { 
            long p = 1;
            for (int i = 0; i < arr.length; i++) 
            	p *= arr[i];
            return p;
        }

        if (type == 3) { // max
            long max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            return max;
        }

        if (type == 4) { // min
            long min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) min = arr[i];
            }
            return min;
        }

        return 0; 
    }

    
   
}