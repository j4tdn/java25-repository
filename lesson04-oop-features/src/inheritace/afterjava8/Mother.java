package inheritace.afterjava8;

public interface Mother {
	void badminton();
	
	default void backend() {
		System.out.println("Mother backend");
	}
	
	default void cooking() {
		System.out.println("Mother cooking");
	}
}
