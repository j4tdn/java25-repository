package inheritance;

public class MouseUIDemo {

	
	public static void main(String[] args) {
		
		MouseEvent m1 = new MouseClickedEvent() {
			
			@Override
			public void mouseClicked() {
				System.out.println("m1--> click by mouse...");
			}
		};
		
		m1.mouseClicked();
		
	}
}
