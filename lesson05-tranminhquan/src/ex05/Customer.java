package ex05;

public class Customer {

	private String maKH;
	private String hoTen;
	private String soDT;
	private String diaChi;
	
	public Customer(String maKH, String hoTen, String soDT, String diaChi) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "Customer [maKH=" + maKH + 
				", hoTen=" + hoTen + 
				", soDT=" + soDT + 
				", diaChi=" + diaChi + 
				"]";
	}
	
	
}
