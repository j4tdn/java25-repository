package inheritance.abstractclass;

public class InheritanceAbstractClassDemo {
	public static void main(String[] args) {
		
		
		EmailService se0 = new EmailService() {
			
			@Override
			void login() {
				System.out.println("ES0 --> login ...");
			}
		};
		EmailService se1 = new StandardEmailServiceImpl();
		
		EmailService se2 = new BusinessEmailServiceImpl();
		
		se0.login();
		se1.login();
		se2.login();
	
		
	}
}
