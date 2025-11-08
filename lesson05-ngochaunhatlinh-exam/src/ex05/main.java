package ex05;

public class main {
	public static void main(String[] args) {
		Sach[] danhSachSach = new Sach[10];
		int soLuong =0;
		
		danhSachSach[soLuong++] = new SachGK("SGK1 ", "NHi Dong", 120, true);
		danhSachSach[soLuong++] = new SachGK("SGK2 ", "NHi Dong", 150, false);
		
		danhSachSach[soLuong++] = new SachTK("STK1", "NHi Dong", 10, 80);
		danhSachSach[soLuong++] = new SachTK("STK2", "NHi Dong", 15, 100);
		
		
		System.out.println("Tat ca danh sach: ");
		for(int i =0; i<soLuong; i++) {
			System.out.println(danhSachSach);
		}
		
		
		System.out.println("\nSAch co don gia < 100: ");
		for(int i =0; i<soLuong; i++) {
			if(danhSachSach[i].getDonGia() < 100) {
				System.out.println(danhSachSach);
			}
		}
		
		System.out.println("\nSach gk gia 100-200: ");
		for(int i =0; i<soLuong; i++) {
			if(danhSachSach[i] instanceof SachGK) {
				double gia = danhSachSach[i].getDonGia();
				if(gia >= 100 && gia <= 200) {
					System.out.println(danhSachSach);
				}
			}
		}
 	}
}
