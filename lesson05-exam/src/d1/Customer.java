package d1;

public class Customer {
private String ma;
private String ten;
private String sdt;
private String diachi;
public Customer(String ma, String ten, String sdt, String diachi) {
	super();
	this.ma = ma;
	this.ten = ten;
	this.sdt = sdt;
	this.diachi = diachi;
}
public String getMa() {
	return ma;
}
public void setMa(String ma) {
	this.ma = ma;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
@Override
public String toString() {
	return "Customer [ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", diachi=" + diachi + "]";
}


}
