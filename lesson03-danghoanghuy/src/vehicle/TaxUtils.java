package vehicle;

public class TaxUtils {
	
	public TaxUtils() {
	}
	
	public static double taxPaid(Owner owner) {
		double tax = 0;
		Vehicle v = owner.getVehicle();
		if(v.getCapacity() < 100) {
			tax = v.getPrice() * 0.01;
		}
		else if (v.getCapacity() >= 100 && v.getCapacity() <= 200) {
			tax = v.getPrice() * 0.03;
		}
		else if (v.getCapacity() > 200) {
			tax = v.getPrice() * 0.05;
		}
		return tax;
	}
}
