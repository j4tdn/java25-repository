/*
 * Bài 4 (20đ): Cho mảng A gồm n phần tử (2 < n < 20). Ak = [0, 100]
Viết hàm liệt kê các phần tử chỉ xuất hiện một lần duy nhất trong mảng. Kết quả
trả về được sắp xếp tăng dần. Ví dụ
▪ int[] a = {3, 15, 21, 0, 15, 17, 21} → Kết quả: 0, 3, 17
Method signature: int[] getUniqueNumbers(....)
 */
public class Ex04UniqueNumbers {
	public static int getUniqueNumbers(int [] A) {
		int [] temp = new int[A.length];
		int countUnique = 0;
		
		for (int i = 0; i < A.length; i++) {
		int count = 0;
		
		
	}

	public static void main(String[] args) {
		int [] a  = {3, 15, 21, 0, 15, 17, 21};
		int [] unique = getUniqueNumbers(a);
		
		System.out.println("Các  phần tử chỉ xuất hiện một lần duy nhất: " );

	}

}
