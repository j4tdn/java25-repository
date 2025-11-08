package ex05;

public class TextBook extends Book {
	private String tinhTrang;

	public TextBook() {
	
	}

	public TextBook(String maSach, double donGia, String nhaXuatBan,String tinhTrang) {
		super(maSach,donGia,nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double tinhTien() {
		if(tinhTrang.equalsIgnoreCase("Old")) return donGia*0.7;
		return donGia;
	}
	@Override
	public String toString() {
		return "TextBook [maSach=\" + maSach + \", donGia=\" + donGia + \", nhaXuatBan=\" + nhaXuatBan"+"tinhTrang=" + tinhTrang + "]";
	}
	
	
}
