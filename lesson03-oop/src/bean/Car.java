package bean;

//  Comment 1 hàng
/*  Comment N hàng ở bất kỳ vị trí nào*/
/** Comment trước class/method để giá trị mô tả class/method đó */

/**
 * Class Car có các thuộc tính
 * Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car --> Kiểu Dữ Liệu
 */
public class Car {
	
	// attribute(s) = thuộc tính = biến toàn cục
	// sẽ được khởi tạo, gán giá trị khi một đối tượng được tạo ra
	// cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính(giá trị) của riêng nó
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private Integer amount;
	
	// theo hướng phát triển oop
	// mỗi class sẽ quản lý thuộc tính riêng của class đó --> tt trong class phải là private
	// trong thực tế dự án các class sẽ gọi qua về để lấy, cập nhật dữ liệu để xử lý yêu cầu của bài
	// thay vì truy cập trực tiếp các thuộc tính của class
	// class hỗ trợ getter/setter[public] để lấy/cập nhật giá trị cho từng thuộc tính private
	
	// từ nay về sau
	// khi tạo 1 class thì các tt phải cho là private và thêm getter, setter
	// thứ tự: thuộc tính, hàm khởi tạo, getter-setter, toString
	
	// nếu để tt là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như fop
	
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
	
	// class #
	// Car c2 = new Car(2, "honda", "hrv", 880d);
	// c2.amount = 6;
	// c2.salesPrice = 990d; -- c2.setSalesPrice(990)
	
	// sout(c2.salesPrice) -- sout(c2.getSalesPrice())
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
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + ", amount="
				+ amount + "]";
	}
}
