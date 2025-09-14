package bean;

public class Store {
	public char name;
	public int open;
	public int close;

public Store(char name,int open,  int close) {
		
		this.name = name;
		this.open = open;
		this.close = close;
	}
@Override
	public String toString() {
	return this.name + ", " + this.open + ", " + this.close +", ";
	}
}