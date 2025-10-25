package inheritance.iinterface;

public interface Shape {

	void calcS();
	
	default void clear() {
		System.out.println("Shape#clear");
	}
}
