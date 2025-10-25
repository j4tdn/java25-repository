package inheritance.override;

public class Child extends Parent{
	
	int number = 100;
	
	@Override
	String log() {
		return "Longging --> Parent class";
	}

}
