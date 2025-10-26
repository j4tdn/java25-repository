package ex04;

public class Director extends Worker {
    public Director(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu) {
        super(hoTen, ngaySinh, heSoLuong, heSoChucVu);
    }

    @Override
    public double tinhLuong() {
        return (heSoLuong + heSoChucVu) * 3000000;
    }

    @Override
    public String toString() {
        return "Giám đốc - " + super.toString() + 
               ", Lương: " + tinhLuong();
    }
}
