package inheritance.abstractclass;

public class InheritanceAbstractClassDemo {
	
	public static void main(String[] args) {
		
		EmailService es0 = new EmailService() {
			
			@Override
			void login() {
				// TODO Auto-generated method stub
				
			}
		};
		EmailService es1 = new StandardEmailServiceImpl();
		EmailService es2 = new BusinessEmailServiceImpl();
		
		es0.login();
		es1.login();
		es2.login();
	}

}
