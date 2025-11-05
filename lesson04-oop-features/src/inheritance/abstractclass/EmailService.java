package inheritance.abstractclass;

public abstract class EmailService {

	//Abstract methos: bắt buộc phải override trong class thực thi
	abstract void login();
	
	// Normal method: không bắt buộc phải override trong class thực thi
	void login2Strep() {
		
	}
	
}
