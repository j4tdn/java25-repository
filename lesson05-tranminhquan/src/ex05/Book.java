package ex05;

public abstract class Book {
	private String maSach;
	private double donGia;
	private String nhaXuatBan;
	
	public Book(String maSach, double donGia, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.donGia = donGia;
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	@Override
	public String toString() {
		return "Book [maSach=" + maSach + 
				", donGia=" + donGia + 
				", nhaXuatBan=" + nhaXuatBan + 
				"]";
	}

	public abstract double tinhTien();
	
	
}
