package inheritance.abstractclass;

public class BusinessEmailServiceImpl extends EmailService {
	
	@Override
	void login() {
		System.out.println("BusinessEmailServiceImpl --> login ...");
	}
	
	@Override
	void login2Strep() {
		System.out.println("BusinessEmailServiceImpl --> login2steps ...");
	}

}
