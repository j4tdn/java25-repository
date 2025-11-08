package d1;

public class Order {
private Book sach;
private int soLuong;
public Order(Book sach, int soLuong) {
	super();
	this.sach = sach;
	this.soLuong = soLuong;
}
public Book getSach() {
	return sach;
}
public void setSach(Book sach) {
	this.sach = sach;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public int totalMoney() {
	return sach.getDongia() * soLuong;
	}
@Override
public String toString() {
	return "Order [sach=" + sach + ", soLuong=" + soLuong + "]";
}


}
