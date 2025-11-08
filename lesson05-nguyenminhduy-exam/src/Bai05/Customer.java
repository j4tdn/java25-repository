package Bai05;

public class Customer {
	
	public int id, phonenumber;
	public String name, adress;
	
	public Customer() {
	}

	public Customer(int id, int phonenumber, String name, String adress) {
		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.name = name;
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", phonenumber=" + phonenumber + ", name=" + name + ", adress=" + adress + "]";
	}
	
	
}
