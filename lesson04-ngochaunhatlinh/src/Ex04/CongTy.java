package Ex04;

public abstract class CongTy {
	private String hoTen;
	private String ngaySinh;
	private double heSoLuong;

	public CongTy() {

	}

	public CongTy(String hoTen, String ngaySinh, double heSoLuong) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public abstract double tinhLuong();

	@Override
	public String toString() {

		return "Họ Tên: " + getHoTen() + ", Ngày Sinh: " + getNgaySinh() + ", Hệ Số lương: " + getHeSoLuong();
	}
}
