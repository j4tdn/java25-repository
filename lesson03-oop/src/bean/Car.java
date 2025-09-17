package bean;

/**
 * Class Car có các thuộc tính 
 * Từ class Car có thể tạo ra các object
 * 
 * Class Car --> Kiểu dữ liệu
 */
public class Car {
	
	// attribute(s) = thuộc tính = biến toàn cục
	// sẽ được khởi tạo, gán giá trị khi 1 object đc tạo ra
	// cứ mỗi object nó sẽ quản lý riêng các giá trị(thuộc tính) của riêng nó
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	public Integer amount;
	
	// theo hướng ptrien OOP
	// mỗi class sẽ quản lý thuộc tính của riêng nó --> tt trong class phải là private
	// trong thực tế các class sẽ gọi qua để lấy, update dữ liệu từ bên ngoại
	
	// nếu để public thì có thể truy cập trực tiếp bên ngoài giống như fop
	
	// từ nay về sau
	// khi tạo class thì tt phải là private và thêm getter, setter
	// thứ tự: tt -> constructor -> getter/setter -> toString
	
	// default(empty) constructor
	// hàm khởi tạo mặc định, dùng để khởi tạo đối tượng
	public Car() {
		
	}

	// constructor
	public Car(Integer id, String model, String name, Double salesPrice) {
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
		this.amount = 1;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
	
}
