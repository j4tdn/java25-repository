package inheritance.multiple;

public class Son implements Father, Mother {

	@Override
	public void running() {
		System.out.println("Son runnig ...");
		
	}
	@Override
	public void badminton() {
		System.out.println("Son badminton ...");
		
	}
	public void cooking() {
		System.out.println("Go out for food");
		
	}
	public static void main(String[] args) {
		Son s1 = new Son();
		s1.frontend();
		s1.backend();
	}
	
}
