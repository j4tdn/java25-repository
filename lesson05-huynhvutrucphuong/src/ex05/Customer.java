package ex05;

public class Customer {
	private String maKH;
	private String hoTen;
	private String sdt;
	private String diaChi;
	public Customer() {
	}
	public Customer(String maKH, String hoTen, String sdt, String diaChi) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "Customer [maKH=" + maKH + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}
	
	

}
