package bean;

// Tạo ra KDL đối tượng tên là Item
public class Item {
	
	// Các thuộc tính của KDL Item
	// KDL Item có 3 thuộc tính: id, name, salesPrice
	// Khi tạo ra 1 biến là KDL Item --> biến đó sẽ lưu trữ 3 thông tin: id, name, salesPrice
	public int id;
	public char name;
	public double salesPrice;
	
	// Hàm khởi tạo mặc định(có sẵn cho mọi class nếu chưa tồn tại hàm khởi tạo khác)
	// Item item = new Item();
	public Item() {
	}
	
	// Hàm khởi tạo với các tham số truyền vào
	// Item item = new Item(22, 'T', 222d)
	public Item(int id, char name, double salesPrice) {
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
	}
	
	// Khi in một biến là KDL đối tượng
	// Thay vì để tự động gọi hàm toString mặc định
	// của class Object
	
	// --> Định nghĩa lại hàm toString cho các class để in ra
	// dữ liệu phù hợp
	
	// i1 --> i1.toString   --> this là i1
	// i2 --> i2.toString() --> this là i2
	
	@Override
	public String toString() {
		return this.id + ", " + this.name + ", " + this.salesPrice;
	}
}