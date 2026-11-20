package view;

import java.util.Optional;

import persistence.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

public class Ex04CustomerView {
	
	private static CustomerService customerService;
	
	static {
		customerService = new CustomerServiceImpl();
	}
	
	public static void main(String[] args) {
		System.out.println("10. Tạo tài khoản cho khách hàng mới, yêu cầu mã hóa mật khẩu");
		/*customerService.save(
			Customer.newInstance()
				.withName("Khách hàng 11")
				.withEmail("c11@gmail.com")
				.withPhone("11023456789")
				.withAddress("Địa chỉ 11")
				.withPassword("AdTw@!728")
				.withSocialMedia("sm102")
				.withToken("c10def")
		);*/
		
		System.out.println("11. Thực hiện chức năng đăng nhập");
		Customer customer = customerService.login("c11@gmail.com", "AdTw@!728");
		Optional.ofNullable(customer)
			.ifPresentOrElse(
				c -> System.out.println("Đăng nhập thành công " + c.getId()), 
			   () -> System.out.println("Đăng nhập thất bại"));
	}
	
}
