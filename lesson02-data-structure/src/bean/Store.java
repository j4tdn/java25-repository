package bean;

public class Store {
	
	public char name;
	public int checkIntime;
	public int checkoutTime;
	
	
	public Store() {
		
	}
	
	public Store(char name, int checkIntime, int checkoutTime) {
		this.name = name;
		this.checkIntime = checkIntime;
		this.checkoutTime = checkoutTime;
	}
	
	@Override
	public String toString() {
		return name + ", " + checkIntime + ", " + checkoutTime;
	}
}
