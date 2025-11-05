package inheritance;

public class MouseUIDemo {
	
	public static void main(String[] args) {
		MouseEvent m1 = new MouseClickedevent() {
			
			@Override
			public void mouseClicked() {
				System.out.println("m1 --> clickingg by mouse");
			}
		};
		m1.mouseClicked();
	}

}
