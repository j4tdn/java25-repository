package inheritance.override;

// Khi KDL con(class) thừa kế từ KDL cha(class)
// --> KHÔNG bắt buộc KDL con phải override tt, hàm từ cha
public class Child extends Parent {
	
	int number = 100;
	
	@Override
	String log() {
		return "Logging --> Child class";
	}
	
}
