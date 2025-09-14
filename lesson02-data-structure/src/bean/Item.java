package bean;

public class Item {

	public int id;
	public char name;
	public double salesPrice;
	
	public Item() {
		
	}
	
	public Item(int pid, char pname, double pSalesPrice) {
		this.id = pid;
		this.name = pname;
		this.salesPrice = pSalesPrice;
	}

	@Override
	public String toString() {
		return this.id + ", " + this.name +", "+this.salesPrice;
	}
	
}
