package bean;

/**
   Class Car có các thuộc tính
   Từ class Cả có thể tạo ra các đối tượng
   
   Class Car --> KDL
  */

public class Car {
	// attibute = thuoc tinh = bien toan cuc
	// sẽ được khởi tạo, gán giá trị khi một đối tượng được tọa ra
	// cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính, giá trị của riêng nó
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private Integer amount;
	
	// theo hướng phát triển oop
	// mỗi class sẽ quản lý thuộc tính riêng của class đó --> thuộc tính trong class phải là private
	// trong thực tế dự án các class sẽ gọi qua vê để lấy, cập nhật dữ liệu để xử lý yêu cầu của bài
	// thay vì truy cập trực tiếp các thuộc tính của class
	// class hỗ trợ getter/setter để lấy/cập nhật giá trị cho từng thuộc tính private
	
	// từ nay về sau
	// khi tại class thì các thuộc tính phải cho private và thêm getter/setter
	// thứ tự: thuộc tính, hàm khởi tạo, getter/setter, toString
	

	// nếu để thuộc tính là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như FOP
	
	// default constructor
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

	// class
	// Car c2 = new Car(2, "honda", "hrv", 880d);
	// c2.amount = 6;
	// c2.salesPrice = 990d;
	
	
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
	public boolean equals(Object o) {
		// nếu 2 đối tượng cùng trỏ đến 1 ô nhớ tại heap
		// --> 2 biến đối tượng bằng nhau, khỏi so sánh
		if (this == o) {
			return true;
		}
		
		// 2 biến trỏ đến 2 ô nhớ khác nhau tại heap
		// để gọi được hàm equals trong class car thì chắc chắn là biến đối tượng car mới gọi được --> this là car
		// trước khi so sánh id của mỗi Cả --> phải kiểm tra o có phải là Car luc runtiem hay ko
		
		// nếu o ko phải là Car thì return false
		// nếu o là Car thì ép kiểu o từ object sang Car lưu vào biến that(mục đích là để có Car gọi hàm getIn())
		if (!(o instanceof Car that)) {
			return false;
		}
		
		// so sánh id của 2 biến đối tượng
		return getId() == that.getId();
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + ", amount="
				+ amount + "]";
	}


	
	
	
	
	

}
