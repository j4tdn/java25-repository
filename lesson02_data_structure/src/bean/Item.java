package bean;

public class Item {

	public int id;
	public char name;
	public double salesPrices;
	public int salesPrice;
	
	public Item() {
		
	}
	public Item(int id, char name, double salesPrices) {
	    this.id = id;
	    this.name = name;
	    this.salesPrices = salesPrices;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id +","+name+","+salesPrices;
	}
	
}