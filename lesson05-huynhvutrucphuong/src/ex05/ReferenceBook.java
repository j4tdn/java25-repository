package ex05;

public class ReferenceBook extends Book {
	private double thue;

	public ReferenceBook() {
		super();
	}

	public ReferenceBook(String maSach, double donGia, String nhaXuatBan,double thue) {
		super(maSach,donGia,nhaXuatBan);
		this.thue = thue;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
	public double tinhTien() {
		return donGia *(1 + thue);
	}
	@Override
	public String toString() {
		return "ReferenceBook [maSach=\" + maSach + \", donGia=\" + donGia + \", nhaXuatBan=\" + nhaXuatBan"+"thue=" + thue + "]";
	}
	
	
}
