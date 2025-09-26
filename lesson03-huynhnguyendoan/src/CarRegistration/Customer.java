package CarRegistration;

public class Customer {
 private String owner;
 private String cartype;
 private int cylinder;
 private double value;
 
 public Customer() {
	
}

 public Customer(String owner, String cartype, int cylinder, double value) {
	super();
	this.owner = owner;
	this.cartype = cartype;
	this.cylinder = cylinder;
	this.value = value;
 }

 public String getOwner() {
	return owner;
 }

 public void setOwner(String owner) {
	this.owner = owner;
 }

 public String getCartype() {
	return cartype;
 }

 public void setCartype(String cartype) {
	this.cartype = cartype;
 }

 public double getValue() {
	return value;
 }

 public void setValue(double value) {
	this.value = value;
 }

 public int getCylinder() {
	return cylinder;
 }

 public void setCylinder(int cylinder) {
	this.cylinder = cylinder;
 }

 @Override
 public String toString() {
	return "Vehicle [owner=" + owner + ", cartype=" + cartype + ", , cylinder=" + cylinder + "value=" + value +  "]";
 }
 
}
