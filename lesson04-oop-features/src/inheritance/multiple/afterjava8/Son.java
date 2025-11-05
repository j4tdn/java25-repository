package inheritance.multiple.afterjava8;

public class Son implements Father, Mother {
	
	@Override
	public void running() {
		System.out.println("Son Running ...");
		
	}
	
	@Override
	public void badminton() {
		System.out.println("Son badminton ...");
		
	}
	
	@Override
	public void cokking() {
//		Father.super.cokking();
//		Mother.super.cokking();
		
		System.out.println("Go out for food");
	}

	public static void main(String[] args) {
		
		Son s1 = new Son();
		s1.fronend();
		s1.backend();
		s1.cokking();
	}

}
