package inheritance.override;

// Khi 1 KDL con(class) thua ke tu KDL cha
// --> K bat buoc KDL con phai override tt, ham tu cha
public class Child extends Parent {

	int number = 100;
	
	@Override
	String log() {
		return "Logging --> Child class";
	}
	
}
