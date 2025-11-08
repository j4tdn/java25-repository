package d1;

public class Book {
private String masach;
private String dongia;
private String nhaxuatban;
private boolean tinhtrang;
private int loaisach;
public Book(String masach, String dongia, String nhaxuatban, boolean tinhtrang, int loaisach) {
	super();
	this.masach = masach;
	this.dongia = dongia;
	this.nhaxuatban = nhaxuatban;
	this.tinhtrang = tinhtrang;
	this.loaisach = loaisach;
}
public String getMasach() {
	return masach;
}
public void setMasach(String masach) {
	this.masach = masach;
}
public String getDongia() {
	return dongia;
}
public void setDongia(String dongia) {
	this.dongia = dongia;
}
public String getNhaxuatban() {
	return nhaxuatban;
}
public void setNhaxuatban(String nhaxuatban) {
	this.nhaxuatban = nhaxuatban;
}
public boolean isTinhtrang() {
	return tinhtrang;
}
public void setTinhtrang(boolean tinhtrang) {
	this.tinhtrang = tinhtrang;
}
public int getLoaisach() {
	return loaisach;
}
public void setLoaisach(int loaisach) {
	this.loaisach = loaisach;
}
@Override
public String toString() {
	return "Book [masach=" + masach + ", dongia=" + dongia + ", nhaxuatban=" + nhaxuatban + ", tinhtrang=" + tinhtrang
			+ ", loaisach=" + loaisach + "]";
}


}
