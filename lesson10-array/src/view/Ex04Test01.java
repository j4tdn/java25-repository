
	
	/*
	 * Cho một mảng số nguyên gồm N phần tử
	 * Viết chương trình
	 * + Tìm các phần tử chẵn trong mảng
	 * + Tìm các phần tử là số nguyên tố trong mảng
	 * + Tìm các phần tử là bội của 5 trong mảng
	 * 
	 * 1: Mỗi yêu cầu viết 1 hàm để xử lý
	 * 2: Viết duy nhất 1 hàm để xử lý cho 3 yêu cầu
	 */
	package view;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.function.IntPredicate;

	public class Ex04Test01 {

	    // ====== (1) Mỗi yêu cầu viết 1 hàm ======
	    public static List<Integer> findEven(int[] arr) {
	        List<Integer> result = new ArrayList<>();
	        if (arr == null) return result;

	        for (int x : arr) {
	            if (x % 2 == 0) result.add(x);
	        }
	        return result;
	    }

	    public static List<Integer> findPrime(int[] arr) {
	        List<Integer> result = new ArrayList<>();
	        if (arr == null) return result;

	        for (int x : arr) {
	            if (isPrime(x)) result.add(x);
	        }
	        return result;
	    }

	    public static List<Integer> findMultipleOf5(int[] arr) {
	        List<Integer> result = new ArrayList<>();
	        if (arr == null) return result;

	        for (int x : arr) {
	            if (x % 5 == 0) result.add(x);
	        }
	        return result;
	    }

	    private static boolean isPrime(int n) {
	        if (n < 2) return false;
	        if (n == 2) return true;
	        if (n % 2 == 0) return false;

	        // kiểm tra tới sqrt(n)
	        for (int i = 3; i * i <= n; i += 2) {
	            if (n % i == 0) return false;
	        }
	        return true;
	    }

	    // ====== (2) Viết duy nhất 1 hàm xử lý cho 3 yêu cầu ======
	    // Truyền điều kiện lọc vào predicate
	    public static List<Integer> filter(int[] arr, IntPredicate condition) {
	        List<Integer> result = new ArrayList<>();
	        if (arr == null || condition == null) return result;

	        for (int x : arr) {
	            if (condition.test(x)) result.add(x);
	        }
	        return result;
	    }

	    // Demo chạy thử
	    public static void main(String[] args) {
	        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 25, 29, 30, -5, 0 };

	        // Cách 1
	        System.out.println("Chan: " + findEven(a));
	        System.out.println("Nguyen to: " + findPrime(a));
	        System.out.println("Boi cua 5: " + findMultipleOf5(a));

	        // Cách 2 (1 hàm filter)
	        System.out.println("Chan (filter): " + filter(a, x -> x % 2 == 0));
	        System.out.println("Nguyen to (filter): " + filter(a, Ex04Test01::isPrime));
	        System.out.println("Boi cua 5 (filter): " + filter(a, x -> x % 5 == 0));
	    }
	}


