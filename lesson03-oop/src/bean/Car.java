package bean;

/*
 * Comment 1 hàng
 * Comment N hàng ở bất kỳ vị trí nào
 */
/**
 * Class Car có các thuộc tính 
 * Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car --> Kiểu dữ liệu
 */

public class Car {
	// attribute = thuộc tính = biến toàn cục
	// sẽ được khởi tạo, gán giá trị khi một đối tượng được tạo ra
	// cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính(giá trị) của riêng nóé
	
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private int amount;
	 
	// theo hướng phát triển oop
	// mỗi class sẽ quản lý thuộc tính riêng của class đó --> tt trong class phải là private
	// trong thực tế dự án các class sẽ gọi qua về để lấy, cập nhật dữ liệu để xử lý yêu cầu của bài
	// thay vì truy cập trực tiếp các thuộc tính của class
	// class hỗ trợ getter/setter [public] để lấy/cập nhật giá trị cho từng thuộc tính private
	
	
	//từ nay về sau
	//khi tạo 1 class thì các thuộc tính phải cho là private và thêm getter, setter vào
	// thứ tự: thuộc tính, hàm khởi tạo, getter-setter, toString
	
	// nếu để tt là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như FOP

	
	
	// default(empty) 
	 // hàm khởi tạo mặc định, dùng để khởi tạo đối tượng
	public Car() {
		
	}
	// constructor
	public Car(Integer id, String model, String name, Double salesPrice) {
		
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
		this.amount=1;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + ", amount="
				+ amount + "]";
	}
	// c1.equals(c2)
	// Car: this(c1)
	// Object: o(c2)
	@Override
	public boolean equals(Object o) {
		// quy ước 2 Car bằng nhau khi giống id
		
		
		if(this==o) {
			return true;
		}
		// 2 biến trỏ đến 2 ô nhớ khác nhau tại HEAP
		// để gọi được hàm equals trong class Car thì chắc chắn là biến đối tượng Car mới gọi được --> this là Car
		// trước khi so sánh ID của mỗi Car --> phải kiểm tra o có phải là Car lúc runtime hay ko
		
		// Nếu o ko phải là Car thì return false
		// Nếu o là Car thì ép kiểu o từ Object sang Car lưu vào biến that (mục đích là để có Car gọi hàm getId() )
		if(!(o instanceof Car that)) {
			return false;
		}
		return getId()== that.getId();
	}
	//@Override
	//public boolean equals(Object b) {
		
	//	return getId()== b.getId();
	//}

	
	
	
}
