package inheritance.multiple.afterjava8;

public interface Mother {
	void badminton();
	default void Backend() {
		System.out.println(" Mother backend");
	}
	default void cooking() {
		System.out.println("Mother : cooking bad ");
	}
}
