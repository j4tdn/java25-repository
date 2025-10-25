package inheritance.multiple.afterjava8;



public class Son implements Father, Mother  {
	@Override
	public void running() {
		System.out.println("Son running ...");
		
	}
	@Override
	public void badminton() {
		System.out.println("Son badminton ...");
		
	}
	
	@Override
	public void cooking() {
		
		// Father.super.cooking();
		// Mother.super.cooking();
		System.out.println("Go out for food");
		
	}
	public static void main(String[] args) {
		Son s1 = new Son();
		s1.frontend();
		s1.backend();
	}
}
