package inheritance.multiple.afterjava8;

public class Son implements Father,Mother {

	@Override
	public void badminton() {
		// TODO Auto-generated method stub
		System.out.println("Son running ... ");
	}

	@Override
	public void running() {
		// TODO Auto-generated method stub
		System.out.println("Son badminton ... ");
	}
	@Override
	public void cooking() {
		// TODO Auto-generated method stub
		Mother.super.cooking();
		System.out.println("Go out for food");
	}

	public static void main(String[] args) {
		Son s1 = new Son();
		s1.frontend();
		s1.Backend();
	}
}
