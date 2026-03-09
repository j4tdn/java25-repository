package Bai1;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayProcessing {
	public static void main(String[] args) {

        int n = 8;

        int[] a = taoMang(n);

        System.out.println("Mang:");
        System.out.println(Arrays.toString(a));

        System.out.println("Phan tu khong trung:");
        loaiBoTrung(a);

        soSanhTrungBinh(a);

    }
	static int[] taoMang(int n){
        Random rd = new Random();
        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = rd.nextInt(41) + 10; 
        }

        return a;
    }
	static void loaiBoTrung(int[] a){

        for(int i=0;i<a.length;i++){
            int dem = 0;

            for(int j=0;j<a.length;j++){
                if(a[i] == a[j]) dem++;
            }

            if(dem == 1){
                System.out.print(a[i] + " ");
            }
        }

        System.out.println();
    }
	static void soSanhTrungBinh(int[] a){

        int n = a.length;
        double tb1 = 0;
        double tb2 = 0;

        for(int i=0;i<n/2;i++)
            tb1 += a[i];

        for(int i=n/2;i<n;i++)
            tb2 += a[i];

        tb1 /= (n/2);
        tb2 /= (n - n/2);

        System.out.println("TB dau: " + tb1);
        System.out.println("TB cuoi: " + tb2);

        if(tb1 > tb2) System.out.println("Nua dau lon hon");
        else if(tb1 < tb2) System.out.println("Nua cuoi lon hon");
        else System.out.println("Hai nua bang nhau");
    }
	
}
