package datastructure.primitive;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		// Cu moi khi truyen vao 2 so nguyen 
		// Lay tong 2 so do --> * 2 --> ^2
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		int da12 = a12*2;
		int pa12 = da12*da12;
		System.out.println("pa12: " + pa12);
		
		int b1 = 5; 
		int b2 = 1;
		int b12 = b1 + b2;
		int db12 = b12*2;
		int pb12 = db12*db12;
		System.out.println("pb12: " + pb12);
		
		int c1 = 3;
		int c2 = 2;
		int c12 = doCalc(c1, c2);
		System.out.println("c12: " + c12);
		
		int d12 = doCalc(1, 5);
		System.out.println("d12: " + d12);
		
		int e1 = 5;
		int e2 = 7;
		
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		modifi(e1);
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		modifi(e2);
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
	}
	
	/*
	 *  Khi truyen gia tri cho tham so qua ham
	 *  
	 *   Tham so chi nhanh gia tri cua o nho {o STACK}, sao chep gia tri cua bien truyen vao qua tham so
	 *   Con tham so va bien ben ngoai hoat dong doc lap
	 *   
	 *   --> Khi truyen gia tri cho tham so, la KDL nguyen thuy --> sau khi goi ham xong neu k co return hay gan lai
	 *   --> 100% bien truyen vao k thay doi
	 */
	
	private static void modifi(int e1) {
		int e2 = 77;
		e1 = 28;
	}
	
	/*
	 *  Khi tao ham can biet:
	 *  	- Ham do co the dung o dau
	 *  	- [static] de lay clss goi
	 *  	- KDL tra ve: logic cua ham xu ;y xong thi se tra ve ket qua hay la k tra ve gi het
	 *  	- Ten ham
	 *  	- Tham so truyen vao(KDL ten bien): arguments
	 */
	
	// Khai bao ham doCalc, nhan vao 2 tham arg1, arg2
	//Cho nao goi ham doCalc, thi phai truyen gia tri cho 2 tham so
	private static int doCalc(int arg1, int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 * 2;
		int parg = darg * darg;
		return parg;
	}
}
