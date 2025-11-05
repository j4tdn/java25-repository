package inheritance.multiple.afterjava8;

public interface Mother {
	
	void badminton();
	
	default void backend() {
		System.out.println("Mother backend");
	}
	
	default void cokking() {
		System.out.println("Mother: Cooking well");
	}
	

}
