package inheritance.multiple.afterjava8;

public interface Father {

	// Một thuộc tính trong interface , mặc định sẽ có public static final
	
	void running();
	
	default void frontend() {
		System.out.println("Father frontend");
	}
	

	default void cooking() {
		System.out.println("Father: cooking bad");
	}
}
