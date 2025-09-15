package bean;

//Trong class nếu tồn tại thuộc tính khai báo là final thì tất cả các hàm phải khởi tạo phải gán giá trị
//mặc định cho thuộc tính final đó
//Bắt buộc phải có khi khởi tạo đối tượng
public class CustomText {
	private final String text;// reflection truy cập từ bên ngoài
	// private String reversedText;

	public CustomText(String text) {
		this.text = text;

	}

	public String getText() {
		return this.text;
	}

	@Override
	public String toString() {

		return "Customtext[" + this.text + "]";
	}
}
