package ex05;

public class TextBook extends Book {
	private String tinhTrang;

	public TextBook(String maSach, double donGia, String nhaXuatBan, String tinhTrang) {
		super(maSach, donGia, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "TextBook [tinhtrang = " + tinhTrang + ", masach = " + getMaSach() + ", gia =" + getDonGia()
				+ ", NXB = " + getNhaXuatBan() + "]";
	}

	@Override
	public double tinhTien() {
		if (tinhTrang.equalsIgnoreCase("cũ"))
			return getDonGia() * 0.7;
		return getDonGia();
	}

}
