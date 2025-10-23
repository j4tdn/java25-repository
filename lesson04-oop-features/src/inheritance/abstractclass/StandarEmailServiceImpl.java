package inheritance.abstractclass;

public class StandarEmailServiceImpl extends EmailService {

	@Override
	void login() {
		System.out.println("StandarEmailServiceImpl --> login ...");
	}

}
