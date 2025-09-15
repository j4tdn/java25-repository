package lesson02_HuynhVuTrucPhuong_DataStructure;

public class Ex08 {
	public static void main(String[] args) {
        int N = 7; 
        System.out.println("N = " + N);
        System.out.println("Ketqua : " + songuyento(N));
    }
	public static boolean songuyento(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    

}
