package ex04;

public class Worker {
    protected String hoTen;
    protected String ngaySinh;
    protected double heSoLuong;
    protected double heSoChucVu;

    public Worker(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.heSoLuong = heSoLuong;
        this.heSoChucVu = heSoChucVu;
    }

    public double tinhLuong() {
        return 0;
    }

    public String toString() {
        return "Họ tên: " + hoTen + ", Ngày sinh: " + ngaySinh +
               ", Hệ số lương: " + heSoLuong + ", Hệ số chức vụ: " + heSoChucVu;
    }
}
