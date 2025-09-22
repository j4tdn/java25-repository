package bean;

/**
 * Class Car co cac thuoc tinh
 * Tu class Car co the tao ra cac doi tuong
 * 
 * Class Car --> KDL
 */

public class Car {
	
	// Attributes = thuoc tinh = bien toan cuc
	// se dc khoi tao, gan gia tri khi mot doi tuong dc tao ra
	// cu moi doi tuong se dc quan ly rieng cac thuoc tinh(gia tri) cua rieng no
	private Integer id;
	private String model;
	private String name;
	private Double salePrices;
	private Integer amount;
	
	// theo huong phat trien cua oop
	// moi class se quan ly thuoc tinh rieng cua class do --> tt trong class phai la private
	// trong thuc te du an cac class se goi qua ve de lay, cap nhat du lieu de xu ly yeu cau bai toan
	// thay vi truy cap truc tiep cac thuoc tinh cua class
	// class ho tro getter/setter[public] de lay/cap nhat gia tri cho tung thuoc tinh private
	
	// tu nay ve sau khi tao 1 class thi cac tt phai cho  private va cho setter/getter
	// thu tu: thuoc tinh, ham khoi tao, getter-setter, toString
	
	// neu de tt la public thi van co the truy cap truc tiep tu ben ngoai nhu fop
	
	// default(empty) constructor
	// ham khoi tao mac dinh, dung de khoi tao doi tuong
	public Car() {
	}

	//constructor
	public Car(Integer id, String model, String name, Double salePrices) {
		this.id = id;
		this.model = model;
		this.name = name;
		this.salePrices = salePrices;
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

	public Double getSalePrices() {
		return salePrices;
	}

	public void setSalePrices(Double salePrices) {
		this.salePrices = salePrices;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object o) {
		// quy uoc 2 Car bang nhau khi giong id
		
		// Neu 2 bien doi tuong cung tro den 1 o nho tai HEAP
		// --> 2 bien doi tuong bang nhau, khoi so sanh
		if(this == o) {
			return true;
		}
		
		// 2 bien tro den 2 o nho khac nhau tai HEAP
		// de goi dc ham equals trong class Car thi chac chan la bien doi Car moi goi dc --> this la Car
		// truoc khi so sanh id cua Car --> phia kiem tra o co phai la Car luc Runtime k
		
		// neu o k phai la Car thi return false
		// neu o la Car thi ep kieu o tu Object sang Car luu vao bien that(muc dich de Car goi ham getID)
		if(!(o instanceof Car that)) {
			return false;
		}
		return getId() == that.getId();	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salePrices=" + salePrices + ", amount="
				+ amount + "]";
	}

}
