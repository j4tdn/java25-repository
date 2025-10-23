package inheritance.abstractclass;

public abstract class EmailService {

	// abstract method: bắt buộc phải override
	abstract void login();
	
	// normal method: ko bắt buộc phải override
	void login2Steps() {
		
	}
	
}
