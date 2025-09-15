package bean;
/*
 * Class: chứa hàm main--> chạy thực thi code
 * Class: kiểu dữ liệu đối tượng
 * Kiểu dữ liệu Item: có 3  thuojc tính id name và salesPrice
 * -->Khi một biến có kiểu dữ liệu Item thì giá trị của biến đó phải gồm id, name và salesPrice
 * --> BIẾN KIỂU  Item nó sẽ trỏ đến ô nhớ luôn có 3 thông tin này
 * --> Giá trị của KDL đối tượng lưu ở vùng nhớ HEAP
 * 
 * 
 */
public class Item {
    //thuộc tính: 
	public int id;
	public char name;
	public double salesPrice;
    // Trong class
	// Mặc định nó sẽ có 1 hàm khởi tạo rỗng( không có tham số)
	//Contructor có tên hàm trùng với tên class
	//Gọi contructor trả về KDL chính là class
	//Gọi thông qua từ khóa new
	//Item item1=new Item()
	//Khi tạo 1 hàm khởi tạo mới, thì hàm mặc định mất đi
	public Item() {
		/*bên ngoài
		Item item3=new Item();
	    item3.id=3;
	    item3.name='C';
	    item3.salesPrice=33d;
	    Item item3=new Item(3,'C',33d);
	    
		 */}
    public Item(int id, char name, double salesPrice) {
    	this.id = id;
    	this.name = name;
    	this.salesPrice = salesPrice;
    	
    	
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
	
	
	
}