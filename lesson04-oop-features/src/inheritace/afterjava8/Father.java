package inheritace.afterjava8;

public interface Father {

	// mot thuoc tinh trong interface, mac dinh se co public static final
	
	void running();
	
	default void frontend() {
		System.out.println("Father frontend");
	}
	
	default void cooking() {
		System.out.println("Father cooking");
	}
	
}
