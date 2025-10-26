package inheritance;

public class MouseUiDemo {
	public static void main(String[] args) {
		MouseEvent m1 = new MouseClickedEvent() {
			
			@Override
			public void mouseClicked() {
				// TODO Auto-generated method stub
				System.out.println("");
			}
		};
		m1.mouseClicked();
	}
}
