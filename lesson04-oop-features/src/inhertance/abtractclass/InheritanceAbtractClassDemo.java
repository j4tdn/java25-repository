package inhertance.abtractclass;

public class InheritanceAbtractClassDemo {

	EmailService es0 = new EmailService() {
		@Override
		void login() {
			// TODO Auto-generated method stub
			System.out.println("Es0 --> login ...");
		}
		
	};
	EmailService es1 = new StandardEmailServiceImpl();
	
	EmailService es2 = new BusinessEmailServiceImpl();
	{
	es0.login();
	es1.login();
	es2.login();
}
}
