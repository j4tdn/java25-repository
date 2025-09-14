package bean;

public class Item {
	
	// các thuộc tính của item
	public int id;
	public char name;
	public double salesPrice;
	
	// KDL item có 3 thuộc tính: id, name, salePrice
	// khi tạo ra 1 biến là KDL item --> biến đó sẽ lưu trữ 3 thông tin: id, name, salesPrice

	// hàm khởi tạo mặc định(có sẵn cho mọi class nếu chưa tồn tại hàm khác)
	public Item() { 
	}
	// hàm khởi tạo với các tham số truyền vào
	// Item item = new Item(22, 'T', 222d)
	public Item(int pid, char pname, double psalesPrice) {
		this.id = pid;
		this.name = pname;
		this.salesPrice = psalesPrice;
	}
	
	
		// khi in một biến là KDL đối tượng
		// thay vì để nó tự động gọi hàm tótring mạc dịnh của class object
		// --> định nghĩa lại hàm tótring cho các class để nó in ra dữ liệu phù hợp
		
		@Override
		public String toString() {
			return this.id + "," + this.name + "," + this.salesPrice;
		}
	
}
