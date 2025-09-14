package bean;

public class Store {
	
	public char name;
	public int checkin;
	public int checkout;
	
	public Store() {	
	}

	public Store(char name, int checkin, int checkout) {
		this.name = name;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return name + "," + checkin + "," + checkout;
	
	}
	
	

	

}
