package bean;

public class Restaurant {

	private char name;
	private int openingHours;
	private int closingHours;
	
	public Restaurant() {
		
	}
	
	public Restaurant(char name, int openingHours, int closingHours) {
		this.name = name;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(int openingHours) {
		this.openingHours = openingHours;
	}

	public int getClosingHours() {
		return closingHours;
	}

	public void setClosingHours(int closingHours) {
		this.closingHours = closingHours;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", openingHours=" + openingHours + ", closingHours=" + closingHours + "]";
	}
	
}
