package inheritance.multiple;

public interface Father {
	void running();
	default void frontend() {
		System.out.println("Father fronted");
	}
	default void cooking() {
		System.out.println("Mother: cooking well");
	}
}
