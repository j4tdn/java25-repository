package bean;

/**
 * Class Car có các thuộc tính
 * Từ class Car có thể tạo ra các đối tượng
 * 
 * Class Car --KDL
 */

public class Car {
	
		// attribute (s) = thuộc tính  = biến toàn cục 
		// sẽ được khởi tạo hay là gán giá trị khi 1 đối tượng được tạo ra
		// cứ mỗi đối tượng sẽ quản lí riêng các thuộc tính giá trị của riêng nó 
	
		private Integer id;
		private String model;
		private String name;
		private Double salesPrice;
		private Integer amount;
		
		// theo hướng phát triển oop
		// mỗi class sẽ quản lý thuộ tính riêng của class đó --> thuộc tính trong class phải là private
		// trong thực tế dụ án các class sẽ được gọi qua về để lấy, cập nhật dữ liệu để xử lí yêu cầu của bài 
		// thay vì truy cập trực tiếp các thuộc tính của class		
		// class hỗ trợ getter/setter[public] để lấy/cập nhật giá trị cho từng thuộc tính private 	
		
		// từ nay về sau
		//khi tạo 1 class thì các thuộc tính phải cho là private và thêm getter/setter
		//thứ tự: thuộc tính , hàm khởi tạo , getter/setter , tostring
		// nếu để tt là public thì vẫn có thể truy cập trực tiếp từ bên ngoài giống như fop
		
		
		// default (empty) constructor
		// hàm khởi tạo mặc địn , dùng để khởi tạo đối tượng 
		public Car() {
			}

		// constructor
		public Car(Integer id, String model, String name, Double salesPrice) {
			this.id = id;
			this.model = model;
			this.name = name;
			this.salesPrice = salesPrice;
			this.amount = 1 ;
		}
		
		// class #
		// Car c2 = new Car(2,"honda","hrv",880d);
		// c2.amount = 6;
		// c2.salesPrice = 990d; --c2.setSalesPrice(990);
		
		//sout(c2.salesPrice) -- soutc2.getSalesPrice());
		
//		public Double getSalesPrie() {
//			return this.salesPrice;
//		}
//		
//		public void setSalesPrice(Double salesPrice) {
//			this.salesPrice = salesPrice;
//		}
		
		
		
	

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
