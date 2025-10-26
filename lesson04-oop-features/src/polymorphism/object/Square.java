package polymorphism.object;

public class Square extends Shape{ 
	@Override
	void calcS() {
		System.out.println("Square#calcS ....formula");
	}
	
	void setBackgroud() {
		System.out.println("Square#SetBackgroud ....");
	}
	

}
