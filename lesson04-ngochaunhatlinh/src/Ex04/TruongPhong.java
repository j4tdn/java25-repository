package Ex04;

public class TruongPhong extends CongTy {
	private double heSoChucVu;
	private String tenDonVi;
	
	public TruongPhong() {
		// TODO Auto-generated constructor stub
	}

	public TruongPhong(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu, String tenDonVi) {
		super(hoTen, ngaySinh, heSoLuong);
		this.heSoChucVu = heSoChucVu;
		this.tenDonVi = tenDonVi;
	}

	public double getHeSoChuVu() {
		return heSoChucVu;
	}

	public void setHeSoChuVu(double heSoChuVu) {
		this.heSoChucVu = heSoChuVu;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
	
	@Override
	public double tinhLuong() {
        return (getHeSoLuong() + heSoChucVu) * 2_200_000;
    }
	
	@Override
	public String toString() {
		return "[Trưởng phòng] " + super.toString() + ", Hệ số chức vụ: " + heSoChucVu + ", Đơn vị: " + tenDonVi 
                + ", Lương: " + tinhLuong();
	}
}
