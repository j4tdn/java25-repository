package ex05;

public class SachGK extends Sach{
	private boolean laCu;
	
	public SachGK() {
		// TODO Auto-generated constructor stub
	}

	public SachGK(String maSach, String nhaXB, double donGia, boolean laCu) {
		super(maSach, nhaXB, donGia);
		this.laCu = laCu;
	}


	
	public boolean isLaCu() {
		return laCu;
	}

	public void setLaCu(boolean laCu) {
		this.laCu = laCu;
	}

	public double tinhThanhTien() {
		if(laCu) {
			return donGia * 0.7;
		}
		return donGia;
	}
	
	@Override
	public String toString() {
		return "Sach giao khoa { " + "Ma Sach: " + maSach + "Don gia: " + donGia +
				", Nha xuat ban: " + nhaXB + ", tinh trang: " + laCu + "} ";
	}
	
	
	
	
	
}
