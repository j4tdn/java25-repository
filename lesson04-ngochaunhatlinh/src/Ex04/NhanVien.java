package Ex04;

public class NhanVien extends CongTy {
	private String tenDonVi;
	private TruongPhong truongPhong;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	@Override
	public double tinhLuong() {
		 return getHeSoLuong() * 1250000;
	}

}
