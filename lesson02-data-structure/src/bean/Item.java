package bean;


// Tạo ra KDL đối tượng tên là Item
public class Item {
	
	//các thuộc tính của KDL Item
	public int id;
	public char name;
	public double salesPrice;
	
	//KDL Item có 3 thuộc tính: id, name, salesPrice
	//Khi tạo ra 1 biến là KDL Item --> biến đổi số lưu trữ 3 thông tin: id, name, salesPrice
	
	
	
	//Hàm khởi tạo mặc định
	public Item() {
	}
	
	//Hàm khởi tạo với các tham số truyền vào
	public Item(int pid, char pname, double pSalesPrice) {
		this.id = pid;
		this.name = pname;
		this.salesPrice = pSalesPrice;
		
	}
	
	//Khi in một biển là KDL đối tượng
	//Thay vì để tự động gọi là hàm toString mặc định của class
	// --> định nghĩa lại hàm toString cho các class in ra dữ liệu phù hợp
	
	
	
	@Override
	public String toString() {
		return this.id + ", " + this.name + ", " + this.salesPrice;
	}
	
}
