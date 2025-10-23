package inheritance.ooverride;

public class InheriranceOverrideDemo {

	public static void main(String[] args) {
		
		Parent p = new Child();
		
		System.out.println("p.number: " + p.number);
		System.out.println("p.log: " + p.log());
		
	}
	
}
