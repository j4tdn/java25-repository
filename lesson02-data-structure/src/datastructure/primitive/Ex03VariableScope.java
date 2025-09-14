package datastructure.primitive;

public class Ex03VariableScope {
	
	/*
	 * Chuong trinh gom 2 phan
	 * 	- Cau truc du lieu
	 * 	- Giai thuat: Cac ham, phuong thuc
	 * 				: Khai bao cac bien ben trong de xu li
	 * Bien cuc bo
	 * 	- Cu phap: [final] data_type variable_name
	 * 	- Pham vi su dung: block scope
	 * 
	 * Bien toan cuc
	 * 	- Cu phap: [access modifier] [static] [final] data_type variable_name;
	 * 	- Pham vi su dung: phu thuoc vao access modifier
	 * 		private: dung trong class chua no
	 * 		public: dung, goi moi noi
	 */
	
	private static int g1 = 555;
	private static int gc = 222;
	
	public static void main(String[] args) {
		
		int gc = 33;
		System.out.println("gc main: " + (gc + Ex03VariableScope.gc));
		
		int m1 = 12;
		int m2 = 22;
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s\n", m1, m2, result);
		{
		int m3 = 24;
		}
		//System.out.println("m3: " + m3);
		
		System.out.println("g1 main value: " + g1);
		
		g1 = 777;
		
		// goi de thuc thi noi dung trong ham dummy
		dummy();
	}
	
	// khai bao ham ten dummy - k co tham so truyen vao, KDL tra ve la void
	private static void dummy() {
		System.out.println("Calling dummy method");
		int gc = 99;
		System.out.println("gc value: " + gc);
	}
}
