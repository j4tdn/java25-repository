package bean;

// cmt 1 hang
/*cmt n hang o bat ki vi tri nao */
/** cmt trouoc class/method de gia tri mo ta class/method do*/

/**
 * Class car co cac thuoc tinh Tu class car co the tao ra cac doi tuong
 * 
 * Class car --> kieu du lieu
 */

public class Car {

	// attribute(s) = bien toan cuc
	// se duoc khoi tao, gan gia tri khi mot doi tuong duoc tao ra
	// cu moi doi tuong no se quan ly rieng cac thuoc tinh(gia tri) cua rieng no
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private Integer amount;

	// theo huong phat trien OOP
	// moi class quan ly thuoc tinh rieng cua class do
	// thuoc tinh trong class phai la private
	// neu de thuoc tinh la public thi van co the truy cap truc tiep tu ben ngoai-->
	// se giong voi FOP
	// trong thuc te du an, acc class se goi qua ve de lay du lieu de xu ly yeu cau
	// cua bai toan
	// thay vi truy cap truc tiep cac thuoc tinh cua class
	// class ho tro getter/setter de lay/cap nhat gia tri cho tung thuoc tinh
	// private
	// get: lay gia tri
	// set: setting lai gia tri

	// từ nay về sau
	// khi tạo 1 class thì các tt phaỉ cho private và thêm getter/setter
	// thứ tự: thuộc tính, hàm khởi tạo, getter-setter, toString

	// default (empty) constructor
	// ham khoi tao mac dinh, dung de khpi tao doi tuong
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
	// c1.equals(c2)
	// Car: this (c1)
	// Object: o(c2)

	@Override
	public boolean equals(Object o) {
		// quy ước: 2 Car bằng nhau khi nó cùng id
		
		// Nếu 2 biến đối tượng cùng trỏ đến 1 ô nhớ tại Heap
		// --> 2 biến đối tượng bằng nhau, khỏi so sánh
		if (this == o) {
			return true;
		}
		
		// Nếu 2 biến đối tượng trỏ đến 2 ô nhớ khác nhau tại Heap
		// Để gọi được hàm equals trong class Car thì chắc chắn là biến đối tượng Car mới gọi được . this is Car
		// trước khi so sánh id của mỗi Car > phải kiếm tra o có phải là Car lúc runtime hay không
		
		//nếu o không phải là Car thì return false
		// nếu o là Car thì ép kiểu o từ Object sang Car lưu vào biến that ( mục đích là để có Car gọi hàm get Id())
		if (!(o instanceof Car that)) {
			return false;
		}
		
		// so sánh id của 2 biến đối tượng
		return getId()== that.getId();

	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + ", amount="
				+ amount + "]";
	}

}
