package inheritance.abstractclass;

public class InheritanceAbstractClassDemo {
	public static void main(String[] args) {
		EmailService es0 = new StandardEmailServiceImpl() {
			@Override
			void login() {
				System.out.println("ES0 --> login ...");
			}
		};
		
		
		EmailService es1 = new StandardEmailServiceImpl();
		EmailService es2 = new BusinessEmailServiceImpl();
		
		es0.login();
		es1.login();
		es2.login();
	}
}
