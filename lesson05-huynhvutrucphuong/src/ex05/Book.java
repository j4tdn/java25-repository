package ex05;

public class Book {
	protected String maSach;
	protected double donGia;
	protected String nhaXuatBan;
	public Book() {
	}
	public Book(String maSach, double donGia, String nhaXuatBan) {
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
		return "Book [maSach=" + maSach + ", donGia=" + donGia + ", nhaXuatBan=" + nhaXuatBan + "]";
	}
	
	
	
	
}
