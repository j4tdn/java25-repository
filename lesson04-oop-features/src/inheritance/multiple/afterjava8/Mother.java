package inheritance.multiple.afterjava8;

public interface Mother {

	void badminton();
	
	void running();
	
	default void backend() {
		System.out.println("Mother frontend");
	}
	
	default void cooking() {
		System.out.println("Mother: cooking well");
	}
}
