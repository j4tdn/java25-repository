package inheritance.abstractclass;

public class BusinessEmailServiceImpl extends EmailService {
	@Override
	void login() {
		System.out.println("BuisenessServiceImpl --> login ...");
	}@Override
	void login2Steps() {
		System.out.println("BusinessE mailServiceImpl --> login2Steps...");
	}
}
