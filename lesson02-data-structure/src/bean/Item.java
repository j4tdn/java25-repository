package bean;

// Tạo ra KDL đối tượng tên là Item
public class Item {
	// Các thuộc tính của KDL Item
	public int id;
	public char name;
	public double salesPrice;

	// KDL Item có 3 thuộc tính: id, name, salesPrice
	// Khi tạo ra 1 biến KDL Item -> biến đó sẽ có 3 ô nhớ
	public Item() {
	}

	// Hàm khởi tạo mặc định
	public Item(int id, char name, double salesPrice) {
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
	}

	// Khi in một biến là KDL đối tượng
	// Thay vì để tự động gọi hàm toString mặc định của class Object
	// --> định nghĩa lại hàm toString cho class Item để hiển thị dữ liệu phù hợp
	// i1 --> i1.toString() --> this là i1
	// i2 --> i2.toString() --> this là i2

	@Override
	public String toString() {
		return this.id + "," + this.name + "," + this.salesPrice;
	}
}
