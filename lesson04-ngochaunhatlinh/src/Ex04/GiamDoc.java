package Ex04;

class GiamDoc extends CongTy {
    private double heSoChucVu;
    
    public GiamDoc() {
		
	}

    public GiamDoc(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu) {
        super(hoTen, ngaySinh, heSoLuong);
        this.heSoChucVu = heSoChucVu;
    }
    
    
    
    public double getHeSoChucVu() {
		return heSoChucVu;
	}

	public void setHeSoChucVu(double heSoChucVu) {
		this.heSoChucVu = heSoChucVu;
	}

	@Override
	public double tinhLuong() {
        return (getHeSoLuong() + heSoChucVu) * 3_000_000;
    }

    @Override
    public String toString() {
        return "[Giám đốc] " + super.toString() + ", Hệ số chức vụ: " + heSoChucVu + ", Lương: " + tinhLuong();
    }
}
