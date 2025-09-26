package bean;
/**
 * Class Car có các thuộc tính
 * Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car --> kiểu dữ liệu
 */
public class Car {
	// attribute(s) = thuộc tính = biến toàn cục
	// sẽ được khởi tạo, gán giá trị khi một đối tượng được tạo ra
	// cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính( giá trị) của riêng nó
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private Integer amount; 
	
	//theo hướng phát triển oop
	/*
	 mỗi class sẽ quản lý thuộc tính riêng của class đó --> tt trong class phải là private
	 trong thực tế dự án các class sẽ gọi qua về để lấy, cập nhật dữ liệu để xử lý yêu cầu của bài
	 thay vì truy cập trực tiếp các thuộc tính của class
	 class hỗ trợ getter/setter[public] để lấy/ cập nhật giá trị cho từng thuộc tính private
	 
	 từ nay về sau
	 khi tạo 1 class thì các tt phải cho là private và thêm getter/setter
	 
	 Thứ tự : thuộc tính, hàm khởi tạo, getter/setter, toString
	 
	 nếu để tt là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như fop
	 */
	
	//default( empty) constructor
	// hàm khởi tạo mặc đinh, dùng để khởi tạo đối tượng
	
	public Car() {
		
	}
	
	//class #
	//Car c2 = new Car(2, "honda", "hrv", 880d);
	//c2.amount =6;
	//c2.salesPrice = 990d;
	
	//sout(c2.salesPrice) -- sout(c2.getSalesPrice())
	
	
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	// c1.equals(c2)
	// Car: this(c1)
	// Object: o(c2)
	
	@Override
	public boolean equals(Object o) {
		//quy ước 2 Car băng nhau khi guống id
		
		//Nếu 2 đối tượng cùng trỏ đến 1 ô nhớ tại HEAP
		// --> 2 biến đối tượng bằng nhau, khỏi so sánh
		if(this == o ) {
			return true;
		}
		
		// 2 biến trỏ đến 2 ô nhớ khác nhau tại HEAP
		//để gọi được hàm equals trong class Car thì chắc chắn là biến đối tượng Car mới gọi được --> this là Car
		//trước khi so sánh id của mỗi Car --> phải kiểm tra o có phải là Car lúc runtime k 
		
		//nếu o ko phỉa là Car thì return false
		//Nếu o là Car thì ép kiểu o từ Object sang Car lưu vào biến that( mục đihcs là để có Car gọi hàm getID
		if(!(o instanceof Car that)) {
			return false;
		}
		//so sánh id của 2 biến đối tượng
		return getId() == that.getId();
		
	}
	
	public Car(Integer id, String model, String name, Double salesPrice) {
		// Constructor
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
		this.amount = 1;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model +  ", name=" + name +  ", salesPrice="+ salesPrice + "]";
	}
}
