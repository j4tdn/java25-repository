package inheritance.override;


// Khi KDL con(class) thừa kế từ KDl cha(class)
// --> không bắt buộc KDL con phải override tt, hàm từ cha
public class Child extends Parent {
	
	int number = 100;
	
	@Override 
	String log() {
		return "Logging --> child class";
	}

}
