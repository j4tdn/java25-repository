package inheritace.abstractclass;

public class InheritaceAbstractClassDemo {
	public static void main(String[] args) {
		
		EmailService es0 = new EmailService() {
			
			@Override
			void login() {
				System.out.println("ES0 --> login...");
				
			}
		};
		
		EmailService es1 = new StandardEmailServiceImpl();
		EmailService es2 = new BussinessEmailServiceImpl();
		
		es0.login();
		es1.login();
		es2.login();
	}
}
