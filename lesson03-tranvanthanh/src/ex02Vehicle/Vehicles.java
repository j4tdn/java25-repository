package ex02Vehicle;

public class Vehicles {

	private String carownername;
	private String typeofcar;
	private int capacity;
	private double price;
	
	public Vehicles() {
	}

	public Vehicles(String carownername, String typeofcar, int capacity, double price) {
		super();
		this.carownername = carownername;
		this.typeofcar = typeofcar;
		this.capacity = capacity;
		this.price = price;
	}

	public String getCarownername() {
		return carownername;
	}

	public void setCarownername(String carownername) {
		this.carownername = carownername;
	}

	public String getTypeofcar() {
		return typeofcar;
	}

	public void setTypeofcar(String typeofcar) {
		this.typeofcar = typeofcar;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
//	public String toString() {
//		return "Vehicles [carownername=" + carownername + ", typeofcar=" + typeofcar + ", capacity=" + capacity
//				+ ", price=" + price + "]";
//	}

	public String toString() {
		return "     "+ carownername +"     "+   typeofcar +"     "+   capacity	+ "     "+ price + "     "+ taxmoney();
	}
	
	public double taxmoney(){
		double tax = 0;
		if(capacity < 100)
		{
			tax = price*0.01;
		}
		else if(capacity <= 200)
		{
			tax = price * 0.03;
		}
		else
		{
			tax = price * 0.05;
		}
		return tax;
	}
	
}
