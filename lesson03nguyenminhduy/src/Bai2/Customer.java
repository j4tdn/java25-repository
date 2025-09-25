package Bai2;

public class Customer {
	private String name;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
	
	
}
