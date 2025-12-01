package inheritance.multiple.afterjava8;

public interface Father {
	
	// một thuộc tính trong interface, mặc định sẽ có public static final
	boolean GENDER = true;
	
	void running();
	
	// default, static, private
	
	default void frontend() {
		System.out.println("Father frontend");
	}
	
	default void cooking() {
		System.out.println("Father: cooking well");
	}
	
}
