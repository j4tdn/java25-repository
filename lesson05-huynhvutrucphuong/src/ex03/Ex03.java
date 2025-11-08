package ex03;

public class Ex03 {
	public static void main(String[] args) {
		int A1[]= {2,3};
		int A2[]= {2,3,4};
		System.out.println(getLeastCommonMultiple(A1));
		System.out.println(getLeastCommonMultiple(A2));
		
		
	}
	public static int getLeastCommonMultiple(int a[]) {
		int BCNN = a[0];
		for (int i=1;i<a.length;i++) {
			BCNN = BCNN(BCNN,a[i]);
			
		}
		return BCNN;
		
	}
	public static int UCLN(int a,int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp; 
		}
		return a; 
	}
	public static int BCNN(int a, int b) {
		return a*b /UCLN(a, b);
	}
}
