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
	        int[] arr = { 1, 2, 3, 4, 5, 6};

	       
	        System.out.println("Tổng phần tử: " + Sum(arr));
	        System.out.println("Tích phần tử:  " + Mul(arr));
	        System.out.println("Phần tử Max: " + Max(arr));
	        System.out.println("Phần tử Min: " + Min(arr));
	 }
	 public static long Sum(int[] arr) {
	        int total = 0;
	        for (int i = 0; i < arr.length; i++) {
	            total += arr[i];
	        }
	        return total;
	    }

	    public static long Mul(int[] arr) {
	        long m = 1;
	        for (int i = 0; i < arr.length; i++) {
	           m *= arr[i];
	        }
	        return m;
	    }

	    public static int Max(int[] arr) {
	        int max = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] > max) {
	            	max = arr[i];
	            }
	        }
	        return max;
	    }

	    public static int Min(int[] arr) {
	        int min = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] < min) {
	            	min = arr[i];
	            }
	        }
	        return min;
	    }
}
