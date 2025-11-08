package bai5;

public class Customers {
	
	private String ID;
	private String Name;
	private String PhoneNumber;
	private String Address;
	
	public Customers() {
		
	}
	
	public Customers(String iD, String name, String phoneNumber, String address) {
		super();
		ID = iD;
		Name = name;
		PhoneNumber = phoneNumber;
		Address = address;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Customers [ID=" + ID + ", Name=" + Name + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + "]";
	}
	
	
	
}
