package inheritance.multiple;

public class Son extends Father/*, Mother */ implements GrandFather, GrandMother{
	/*
	 Java k ho tro da thua ke vi
	  - class extends class khac k bat buoc phai override method
	  - vi k batt buoc override dan den neu class extends 2/N class cha
	 	va 2/N class cha co chung 1 ham cung phan khai bao(k bat buoc overridde)
	 	doi tuong con k biet se su dung ham tu class nao
	 */
	
	@Override
	public void building() {
		System.out.println("Son --> gaming...");
	}
	
	@Override
	public void gaming() {
		System.out.println("Son --> building...");
	}
}
