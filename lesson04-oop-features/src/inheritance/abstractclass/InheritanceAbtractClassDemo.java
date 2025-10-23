package inheritance.abstractclass;

public class InheritanceAbtractClassDemo {

	public static void main(String[] args) {
		
		EmailService es0 = new EmailService() {
			@Override
			void login() {
				System.out.println("Es0 --> login ...");
			}
		};
		
		EmailService es1 = new StandarEmailServiceImpl();
		
		EmailService es2 = new BusinessEmailServiceImpl();
		
		es0.login();
		es1.login();
		es2.login();
		
	}
	
}
