package inheritance.multiple;

public class Son extends Father /*, Mother*/ implements GrandFather, GrandMother{
	
	@Override
	public void gaming() {
		System.out.println("Son --> gamming ...");
	}
	@Override
	public void building() {
		System.out.println("Son --> building ...");
	}
}
