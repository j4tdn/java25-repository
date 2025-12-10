package inheritance;

public class MouseUIDemo {
	public static void main(String[] args) {
		MouseEvent m1 = new MouseClickEvent() {
			
			@Override
			public void mouseClicked() {
				System.out.println("m1 --> clicking by mouse ...");
			}
			
		};
		
		m1.mouseClicked();
		
	}

}
