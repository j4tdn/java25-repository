package polymorphism.object;

public class Square extends Shape {
	@Override
	void calcS() {
		System.out.println("Square#CalcS.... formula");
	}
	void setBackground() {
		System.out.println("Square#setBackground....");
	}
}
