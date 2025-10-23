package inheritance.ooverride;

// Khi KDL con(class) thừa kế từ KDL cha(class)
// --> Không bắt buộc KDL con phải override tt
public class Child extends Parent {

	int number = 100;
	
	@Override
	String log() {
		return "Logging --> Child class";
	}
	
}
