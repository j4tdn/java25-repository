package lesson02_HuynhVuTrucPhuong_DataStructure;

public class Ex09 {
	public static void main(String[] args) {
		int count = 0;
		int num = 1;
		int nguyento200 =0;
		while (count < 200) {
            num++;
            if (songuyento(num)) {
                count++;
                nguyento200 = num;
            }
        }

        System.out.println("Số nguyên tố thứ 200 là: " + nguyento200);
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
