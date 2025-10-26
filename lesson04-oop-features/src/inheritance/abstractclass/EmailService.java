package inheritance.abstractclass;

public abstract class EmailService {
	
	// Abstract method: bắt buộc phải override trong class thực thi
	abstract void login();
	
	// normal class: ko bắt buộc phải override trong class thực thi
	void login2Step() {
	}

}
