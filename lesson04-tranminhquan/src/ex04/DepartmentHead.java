package ex04;

public class DepartmentHead extends Worker {
    private String donVi;

    public DepartmentHead(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu, String donVi) {
        super(hoTen, ngaySinh, heSoLuong, heSoChucVu);
        this.donVi = donVi;
    }

    @Override
    public double tinhLuong() {
        return (heSoLuong + heSoChucVu) * 2000000;
    }

    @Override
    public String toString() {
        return "Trưởng phòng - " + super.toString() + 
               ", Đơn vị: " + donVi +
               ", Lương: " + tinhLuong();
    }

    public String getDonVi() {
        return donVi;
    }
}
