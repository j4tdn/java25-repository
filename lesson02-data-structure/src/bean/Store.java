package bean;

public class Store {
	public char name;
	public int timeOpen;
	public int timeClose;

	public Store() {

	}

	public Store(char name, int timeOpen, int timeClose) {
		this.name = name;
		this.timeOpen = timeOpen;
		this.timeClose = timeClose;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.timeOpen + ", " + this.timeClose;
	}

}
