package bean;

// Tạo ra 1 KDL đối tượng tên là Item
public class Item {
	
	//Các thuộc tính của KDL Item
	
	public int id;
	public char name;
	public double salePrice;
	
	//KDL Item có 3 thuộc tính: id, name, salePrice
	
	// Khi tạo ra 1 biến là KDL item --> biến đó sẽ lưu trữ 3 thông tin: id, name, salePrice
	 
	
	// Hàm khởi tạo mặc định (có sẵn cho mọi Class nếu chưa tồn tại hàm khác)
	public Item() {
	}
	// Hàm khởi tạo với các tham số truyền vào
	// Item item = new Item(22,'T', 222d)
	public Item(int pid, char pname, double psalePrice) {
		this.id = pid;
		this.name = pname;
		this.salePrice = psalePrice;
	}
	
	//Khi in 1 biến là KDL đối tượng
	// Thay vì để nó tự động gọi hàm toString mặc định của class Object
	// --> Định nghĩa lại hàm toString cho các Class để nó in ra dữ liệu phù hợp
	
	// i1 --> i1.toString() --> this là i1
	// i2 --> i2.toString() --> this là i2
	@Override
 	public String toString() {
		return this.id + ", " + this.name + ", " + this.salePrice +", ";
	}
 	
}
