package inheritance.multiple.afterjava8;

public interface Father {
	
	void running();
	
	default void fronend() {
		System.out.println("Father fronend");
	}
	
	default void cokking() {
		System.out.println("Mother: Cooking well");
	}
	
	

}
