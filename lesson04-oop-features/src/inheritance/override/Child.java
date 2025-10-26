package inheritance.override;

// khi KDL con(class) thừa kếtuwf KDL cha(class)
// --> Không bắt buộc KDL con phải override tt, hàm từ cha
public class Child extends Parent{
	
	int number = 100;
	@Override
	String log() {
		return "Logging --> child class";
	}
	

}
