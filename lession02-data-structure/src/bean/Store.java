package bean;

public class Store {
	public char name;
	public double checkin;
	public double checkout;

	public Store() {

	}

	public Store(char name, double checkin, double checkout) {
		this.name = name;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return name + " , " + checkin + " , " + checkout;
	}
}
