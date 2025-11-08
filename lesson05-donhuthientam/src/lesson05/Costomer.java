package lesson05;

public class Costomer {
	
	private int number;
	private String name;
	private String phoneNumber;
	private String Address;
	
	public Costomer() {
		// TODO Auto-generated constructor stub
	}

	public Costomer(int number, String name, String phoneNumber, String address) {
		super();
		this.number = number;
		this.name = name;
		this.phoneNumber = phoneNumber;
		Address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Costomer [number=" + number + ", name=" + name + ", phoneNumber=" + phoneNumber + ", Address=" + Address
				+ "]";
	}
	
	

}
