package bean;

/**
 * Class car có thuộc tính Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car --> kiểu dữ liệu
 */

public class Car {

	// attributes(s) = thuộc tính = biến toàn cục
	// sẽ được khởi tạo, gán giá trị khi một đối tượng được tạo ra
	// cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính(giá trị) của riêng nó

	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	
	// theo hướng phát triển oop
	// mỗi class sẽ quản lý thuộc tính riêng của class đó --> tt trong class phải là private
	// trong thực tế dự án các class sẽ gọi qua về để lấy, cập nhật dữ liệu để xử lý yêu cầu của bài
	// thay vì truy cập trực tiếp các thuộc tính của class
	// class hỗ trợ getter/setter[public] để lấy/cập nhật giá trị cho từng thuộc tính private
	
	
	// từ nay về sau khi taoj class thì các thuộc tính phải cho là private và thêm getter setter vào
	// thứ tự: thuộc tính, hàm khởi tạo, getter-setter, toString

	// nếu để thuộc tính là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như fop
	
	// default(empty) constructor
	// hàm khởi tạo mặc định, dùng để khởi tạo đối tượng
	
	public Car() {
	}

	public Car(Integer id, String model, String name, Double salesPrice) {
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
	}
	
	// class #
	// Car c2 = new Car(2, "honda", "hrv", 880d);
	
	
	


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

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// nếu 2 đối tượng cùng trỏ đến 1 ô nhớ tại HEAP
		// --> 2 biến đối tượng bằng nhau, khỏi so sánh
		
		if(this == obj) {
			return true;
			
		}
		
		// 2 biến trỏ đến 2 ô nhớ khác nhau tại HEAP
		// để gọi được hàm equals trong class Car thì chắc chắn là đối tượng Car mới gọi được --? this là Car
		// trước khi so sánh id của mỗi Car --> phải kiểm tra obj có phải là Car lúc runtime không
		
		// nếu  obj không phải là Car thì return false
		// nếu obj là Car thì ép kiểu obj từ Object sang Car lưu vào biến that ( mục đích là để có Car gọi hàm getID())
		
		if(!(obj instanceof Car that)) {
			return false;
		}
		
		return getId() == that.getId();
		
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
	



}
