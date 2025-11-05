package function.lamda;

@FunctionalInterface
public interface Shape {
	
	// Interface co duy nhat 1 ham truu tuong --> Function Interface
	
	// De khoi tao 1 doi tuong tu @FI
	// - Tao implements class, trong impl class override lai ham truu tuong --> interface new sub class
	// - New truc tiep interface tai vi tri khai bao --> anonymous class
	// - Su dung anonymous function --> lambda expression(@FI)
	
	
	// Co annotation @FunctionalInterface: bat loi tai compile neu interface co nhiu hon 1 ham truu tuongn
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> clear...");
	}
	
	private void setStyle() {
		System.out.println("Shape --> setStyle...");
	}
	
}
