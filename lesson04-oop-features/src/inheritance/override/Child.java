package inheritance.override;


//khi KDL con thừa kế từ KDL cha (class)
//--> Không bắt buộc KDL con phải overrride tt, hàm từ cha
public class Child extends Parent{
	int number = 100;
	
	@Override
	String log() {
		return "Logging --> Child class";
	}
}
