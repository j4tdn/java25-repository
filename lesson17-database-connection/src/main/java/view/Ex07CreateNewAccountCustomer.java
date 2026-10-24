package view;

import persistence.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;
import static utils.PrintUtils.generate;

public class Ex07CreateNewAccountCustomer {

	private static final CustomerService customerService = new CustomerServiceImpl();

	/*
	10. Tạo tài khoản cho khách hàng mới

	Yêu cầu mật khẩu được mã hóa theo 1 thuật toán mã hóa.

	VD: MD5, SHA256
	 */
	public static Customer createNewAccount(String name, String email, String rawPassword) {
		Customer customer = new Customer(null, name, email, null);
		return customerService.createAccount(customer, rawPassword);
	}

	public static void main(String[] args) {
		Customer customer = createNewAccount(
			"Hehe",
			"hehe@gmail.com",
			"123456"
		);

		generate("10. Tạo tài khoản cho khách hàng mới", customer);
	}
}
