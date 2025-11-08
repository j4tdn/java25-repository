package bean;

public class Customer {

	private String customerId;
	private String fullname;
	private String phoneNumber;
	private String address;
	
	public Customer() {
		
	}

	public Customer(String customerId, String fullname, String phoneNumber, String address) {
		super();
		this.customerId = customerId;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullname=" + fullname + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
	
}
