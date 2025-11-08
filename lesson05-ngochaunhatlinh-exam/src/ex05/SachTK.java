package ex05;

public class SachTK extends Sach{
	private double thue;
	
	public SachTK() {
		// TODO Auto-generated constructor stub
	}

	public SachTK(String maSach, String nhaXB, double donGia, double thue) {
		super(maSach, nhaXB, donGia);
		this.thue = thue;
	}
	
	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double tinhThanhTien() {
		return donGia * (1 + thue /100);
	}
	
	@Override
	public String toString() {
		return "Sach giao khoa { " + "Ma Sach: " + maSach + "Don gia: " + donGia +
				", Nha xuat ban: " + nhaXB + ", Thue: " + thue + "} ";
	}
	
}
