import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bai4 {
	
	static Set<Long> snt(long n){
		Set<Long> set = new HashSet<>();
		for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
		}
		 if (n > 1) set.add(n);
	     return set;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        if (snt(n).equals(snt(m)))
            System.out.println("YES");
        else
            System.out.println("NO");
		
	}
	
}
