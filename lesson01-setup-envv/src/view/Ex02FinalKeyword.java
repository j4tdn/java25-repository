package view;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		/*
		 Toán tử = luôn hoạt động ở stack
		 
		 * Biến KDL nguyên thủy
		 * - biến: stack
		 * - giá trị: stack
		 * -để cập nhật giá trịcủa biến nguyên thử:
		 * -->dùng toán tử =
		
		 * Biến KDL đối tượng:
		 * - biến: stack lưu trữ địa chỉ của ô nhớ tại heap mà biến đang trỏ đến
		 * - giá trị: heap
		 * - để cập nhật giá trị của biến đối tượng:
		 * --> dùng toán tử = để cập nhật giá trị đỉa chỉ tại stack
		 * --> gọi đến các thuộc tính(nếu cho phép) ở heap và cập nhật
		 * 
		 * Từ khóa final
		 * -Khoi thêm từ khóa final vào cho biến, biến đó trở thành hằng số(stack) 
		 * nghĩa là không thể cập nhật giá trị của ô nhớ đó ở stack
		 * - final ở stack
		 */
		
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		//c = b;
		
	}

}
