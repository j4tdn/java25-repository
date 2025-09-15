package bean;

//Tạo ra KDL đối tượng tên là Item
public class Item {
	
	// Các thuộc tính của KDL Item
	public int id;
	public String name;
	public double salesPrice;
	
	public float timesclose;
	public float timesopen;
	
	
	//KDL Item có 3 thuộc tính: id, name, salesPrice
	//Khi tạo ra 1 biến KDL Item --> biến đó sẽ lưu trữ 3 thông tin id, name , salePrices
	//Hàm khởi tạo mặc định( có sẵn cho mọi class nếu chưa tồn tại hàm khởi tạo khác
	// Item item = new Item();
	public Item() {
		
	}
	//Hàm khởi tạo với các tham số truyền vào
	//Item item = new item(22,'T', 222d)
	
	public Item(int pid, String pname, double psalesPrice) {
		this.id =pid;
		this.name=pname;
		this.salesPrice=psalesPrice;
		// khi in một biến là KDL đối tượng
		//Thay vì để tự động gọi hàm toString mặc định
		// của class object
		
		//--> Định nghĩa lại hàm tostring cho các class để in ra dữ liệu
		// Dữ liệu phù hợp
		
		//i1 --> i1.tostring --> this là i1
		//i2 --> i2.tostring --> this là i2
	}
	@Override
	public String toString() {
		return this.id + ", " + this.name + ", " + this.salesPrice;
	}

}

