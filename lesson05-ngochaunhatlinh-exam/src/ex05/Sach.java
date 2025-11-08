package ex05;

public abstract class Sach {
	public String maSach;
	public String nhaXB;
	public double donGia;
	
	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSach, String nhaXB, double donGia) {
		
		this.maSach = maSach;
		this.nhaXB = nhaXB;
		this.donGia = donGia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	
	
	
	
}
