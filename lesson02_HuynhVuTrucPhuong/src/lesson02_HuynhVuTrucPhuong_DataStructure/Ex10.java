package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex10 {
	public static void main(String[] args) {
		Random rd = new Random();
		Set<Integer> set = new HashSet<>();
		while (set.size() < 5) {
            int num = rd.nextInt(11) + 20; 
            set.add(num);
        }

        System.out.println("5 so ngau nhien tu 20-30:");
        for (int n : set) {
            System.out.println(n + " ");
        }
	}
}
