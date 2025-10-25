package inheritance.abstractclass;

public class BusinessEmailServiceImpl extends EmailService {
	@Override
	void login() {
		System.out.println("BussinessEmailServiceImpl --> login...");
		
	}
	@Override
	void login2Steps() {
		System.out.println("BussinessEmailServiceImpl --> login2Steps...");
	}
}
