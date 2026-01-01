package ex04;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex04 {
	static BigInteger rutGon(BigInteger n) {
        BigInteger i = BigInteger.valueOf(2);
        BigInteger result = BigInteger.ONE;

        while (i.multiply(i).compareTo(n) <= 0) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                result = result.multiply(i);
                while (n.mod(i).equals(BigInteger.ZERO))
                    n = n.divide(i);
            }
            i = i.add(BigInteger.ONE);
        }
        if (n.compareTo(BigInteger.ONE) > 0)
            result = result.multiply(n);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        System.out.println(rutGon(N).equals(rutGon(M)) ? "YES" : "NO");
    }
}
