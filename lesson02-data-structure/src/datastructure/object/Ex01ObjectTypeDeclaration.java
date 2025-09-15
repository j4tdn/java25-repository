package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeDeclaration {
	public static void main(String[] args) {

		// KDL Nguyên Thủy
		int number = 22;
		char letter = 'Z';
		System.out.println("number: " + number);
		System.out.println("letter: " + letter);

		System.out.println("\n\n");

		// KDL Đối Tượng
		Item i1 = null;

		/*
		 * Khi gọi hàm khởi tạo, sẽ tạo ra một ô nhớ ở vùng heap với các giá trị mặc
		 * định cho các thuộc tính của kiểu dữ liệu Item, ban đầu của số là 0, của chuỗi
		 * là rỗng('').
		 */
		Item i4 = new Item(22, 'T', 222);
		Item i2 = new Item();

		System.out.println("i4: " + i4);
		System.out.println("i1: " + i1);
		System.out.println(i2);

	}
}
