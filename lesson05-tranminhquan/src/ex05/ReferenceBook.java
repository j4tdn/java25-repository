package ex05;

public class ReferenceBook extends Book {

	private double thue;

	public ReferenceBook(String maSach, double donGia, String nhaXuatBan, double thue) {
		super(maSach, donGia, nhaXuatBan);
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "ReferenceBook [thue = " + thue + "masach = " + getMaSach() + ", gia = " + getDonGia()
				+ ", NXB = " + getNhaXuatBan() + "]";
	}

	@Override
	public double tinhTien() {
		return getDonGia() * (1 + thue / 100);
	}

}
