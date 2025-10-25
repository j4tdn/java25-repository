package inheritance.multiple.afterjava8;

public interface Father {

	void running();
	
	default void frontennd() {
		System.out.println("Father frontend");
	}
	
	default void cooking() {
		System.out.println("Mother: cooking well ");
	}
}
