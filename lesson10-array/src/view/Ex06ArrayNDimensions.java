package view;

public class Ex06ArrayNDimensions {
	public static void main(String[] args) {
		int[] a1D = {1,2,3,4,5};
		
		int[][] a2D = { {1,2}, {3,4}, {5,6,7} };
		Element[] e2D = {new Element(1, 2, -1), new Element(3, 4, -1), new Element(5, 6, 7)};
		
		int[][][] a3D = { {{1,2}, {3,4}, {5,6,7}}, {{7,7}} };
		
		System.out.println("--Mảng 1 chiều--");
		for (int i = 0; i < a1D.length; i++) {
			System.out.println("  - " + a1D[i]);
		}
		
		System.out.println("\n");
		
		System.out.println("--Mảng 2 chiều--");
		for (int i = 0; i < a2D.length; i++) {
			for (int j = 0; j < a2D[i].length; j++) {
				System.out.print(a2D[i][j] + " ");
			}
			System.out.println();
		}	
		System.out.println("\n");
		
		System.out.println("--- Mảng 2 chiều(biến đổi) ---");
		for (int i = 0; i < e2D.length; i++) {
			System.out.println("  - " + e2D[i]);
		}
	}
	
	static class Element {
		int e1;
		int e2;
		int e3;
		
		public Element(int e1, int e2, int e3) {
			this.e1 = e1;
			this.e2 = e2;
			this.e3 = e3;
		}
		
		@Override
		public String toString() {
			return "element(" + e1 + "," + e2 + "," + e3 + ")";
		}
	}
}
