package bean;


/**
 * Class Car có các thuộc tính
 * Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car--> Kiểu Dữ liệu
 */
public class Car {
	
	//Thuộc tính attribute(s) = thuộc tính = biến toàn cục
	//sẽ được khởi tạo, gán giá trị khi một đối tượng được tạo ra
	//cứ mỗi đối tượng nó sẽ quản lý riêng các thuộc tính (giá trị ) của riêng nó
	
	public Integer id;
	public String model;
	public String name;
	public Double salesPrice;
	
	// default(empty) constructor
	// hàm khởi tạo mặc định, dùng để khởi tạo đối tượng
	public Car() {
		
	}

	public Car(Integer id, String model, String name, Double salesPrice) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
	
    
}
