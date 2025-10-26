package polymorphism.object;

public class Square extends Shape {
	@Override
	void calcS() {
		// TODO Auto-generated method stub
		System.out.println("Square#calcS .....formula");
		super.calcS();
	}
	void setBackground() {
		System.out.println("Square#setBackground .....");
	}

}
