package ex03;
import java.util.Scanner;

public class PhanTuYenNgua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng M: ");
        int soHang = sc.nextInt();
        System.out.print("Nhập số cột N: ");
        int soCot = sc.nextInt();

        int[][] maTran = new int[soHang][soCot];
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                maTran[i][j] = sc.nextInt();
            }
        }

        boolean timThay = false;
        for (int i = 0; i < soHang; i++) {
            int giaTriNhoNhat = maTran[i][0];
            int chiSoCot = 0;
            for (int j = 1; j < soCot; j++) {
                if (maTran[i][j] < giaTriNhoNhat) {
                    giaTriNhoNhat = maTran[i][j];
                    chiSoCot = j;
                }
            }
            boolean laYenNgua = true;
            for (int k = 0; k < soHang; k++) {
                if (maTran[k][chiSoCot] > giaTriNhoNhat) {
                    laYenNgua = false;
                    break;
                }
            }
            if (laYenNgua) {
                System.out.println("Phần tử yên ngựa: A[" + i + "][" + chiSoCot + "] = " + giaTriNhoNhat);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Ma trận không có phần tử yên ngựa!");
        }

        sc.close();
    }
}
