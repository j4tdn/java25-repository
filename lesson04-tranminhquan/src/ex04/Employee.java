package ex04;

public class Employee extends Worker {
    private String donVi;
    private String truongPhong;

    public Employee(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu, String donVi, String truongPhong) {
        super(hoTen, ngaySinh, heSoLuong, heSoChucVu);
        this.donVi = donVi;
        this.truongPhong = truongPhong;
    }

    @Override
    public double tinhLuong() {
        return (heSoLuong + heSoChucVu) * 1000000;
    }

    @Override
    public String toString() {
        return "Nhân viên - " + super.toString() +
               ", Đơn vị: " + donVi +
               ", Trưởng phòng: " + truongPhong +
               ", Lương: " + tinhLuong();
    }

    public String getTruongPhong() {
        return truongPhong;
    }
}
