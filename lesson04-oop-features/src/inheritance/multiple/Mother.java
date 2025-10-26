package inheritance.multiple;

public interface Mother {
	void running();
	void badminton();
	default void backend() {
		System.out.println("Mother backend");
	}
	default void cooking() {
		System.out.println("Mother: cooking bad");
	}
}
