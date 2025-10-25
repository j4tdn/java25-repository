package inheritance.multiple.afterjava8;

public interface Mother {
	
	void running();
	
	void badminton();
	
	default void backend() {
		System.out.println("Mother backend");
	}
	
	default void cooking() {
		System.out.println("Mother: cooking well");
	}
	
	
}
