package inheritance.multiple.afterjava8;

public interface Father {
	
	void running();
	
	default void frontend() {
		System.out.println("Father frontend");
	}
	
	default void cooking() {
		System.out.println("Father: cooking well");
	}
	
}
