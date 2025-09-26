package bai2;

public class Vehicle {
	private String chuxe;
	private String loaixe;
	private int dungtich;
	private long cost;
	
	public Vehicle() {
		
	}

	public Vehicle(String chuxe, String loaixe, int dungtich, long cost) {
		super();
		this.chuxe = chuxe;
		this.loaixe = loaixe;
		this.dungtich = dungtich;
		this.cost = cost;
	}

	public String getChuxe() {
		return chuxe;
	}

	public void setChuxe(String chuxe) {
		this.chuxe = chuxe;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	public int getDungtich() {
		return dungtich;
	}

	public void setDungtich(int dungtich) {
		this.dungtich = dungtich;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return   chuxe +"         "+  loaixe +"         "+  dungtich +"        "+ cost +"         "+ tienthue();
	}
	 
	public double tienthue(){
		double tax = 0;
		if (dungtich <100) {
			tax = cost *0.01;
			
		}
		else if (dungtich<=200) {
			tax = cost *0.03;
		}
		else { tax = cost *0.05 ;}
		return tax;
	}
}
