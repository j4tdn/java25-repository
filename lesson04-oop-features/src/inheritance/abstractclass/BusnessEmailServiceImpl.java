package inheritance.abstractclass;

public class BusnessEmailServiceImpl extends EmailService {

	@Override
	void login() {
		System.out.println("BusnessEmailServiceImpl --> login ...");
	}
	
	
	@Override
	void login25Steps() {
		System.out.println(" BusnessEmailServiceImpl --> login25Steps ...");
	}
	
}
