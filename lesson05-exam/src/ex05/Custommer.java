package ex05;

public class Custommer {

	
	private String cusid;
	private String fullname;
	private String numberphone;
	private String address;
	
	public Custommer() {
	}

	public Custommer(String cusid, String fullname, String numberphone, String address) {
		super();
		this.cusid = cusid;
		this.fullname = fullname;
		this.numberphone = numberphone;
		this.address = address;
	}

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNumberphone() {
		return numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Custommer [cusid=" + cusid + ", fullname=" + fullname + ", numberphone=" + numberphone + ", address="
				+ address + "]";
	}
	
	
	
	
	
}
