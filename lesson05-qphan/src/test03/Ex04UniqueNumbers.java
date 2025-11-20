package test03;

import java.util.Arrays;

import bean.Tuple;

public class Ex04UniqueNumbers {
	
	/** Bài 4 (20đ): Cho mảng A gồm n phần tử (2 < n < 20). Ak = [0, 100]
	Viết hàm liệt kê các phần tử chỉ xuất hiện một lần duy nhất trong mảng. Kết quả
	trả về được sắp xếp tăng dần. Ví dụ
	▪ int[] a = {3, 15, 21, 0, 15, 17, 21} → Kết quả: 0, 3, 17
	*/
	public static void main(String[] args) {
		int[] numbers = {3, 15, 21, 0, 15, 17, 21, 15};
		Tuple[] tuples = statisticNumberRepeaters(numbers);
		System.out.println("Thống kê số lần xuất hiện: " + Arrays.toString(tuples));
	}
	
	// Đếm số lần xuất hiện của từng phần tử trong mảng numbers
	// Kết quả trả về 0,1 3,1 15,3 17,1 21,2
	private static Tuple[] statisticNumberRepeaters(int[] numbers) {
		Tuple[] tuples = new Tuple[numbers.length]; // {3,1} null null null null null null null
		int i = 0; // số phần tử thật sự có(!=null) trong mảng tuples
		
		// Kiểm tra từng number đã tồn tại trong tuples chưa
		// 1. Chưa --> tạo đối tượng tuple với number và số lần là 1 --> đưa vào tuples
		// 2. Rồi  --> tăng số lần xuất hiện lên
		
		for (int number: numbers) {
			Tuple found = find(number, tuples, i);
			if (found == null) {
				Tuple newTuple = new Tuple(number, 1);
				tuples[i++] = newTuple;
			} else {
				found.plusRight();
			}
		}
		
		return Arrays.copyOfRange(tuples, 0, i);
	}
	
	private static Tuple find(int number, Tuple[] tuples, int currentSize) {
		for (int i = 0; i < currentSize; i++) {
			Tuple tuple = tuples[i];
			if (tuple.getLeft() == number) {
				return tuple;
			}
		}
		return null;
	}
}
