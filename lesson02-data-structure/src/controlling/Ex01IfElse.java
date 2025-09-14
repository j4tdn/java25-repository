package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex01IfElse {
	
	private static Random rd = new Random();

	public static void main(String[] args) {
		
 		double avgPoint = generatePoint();
		if(avgPoint < 5) {
			System.out.println("Yeu");
		} else if(avgPoint < 6.5) {
			System.out.println("Trung Binh");
		} else if (avgPoint < 8) {
			System.out.println("Kha");
		} else {
			System.out.println("Gioi");
		}
		
	}
	
	private static double generatePoint() {
		double avgPoint = rd.nextFloat(11);
		if(avgPoint > 10f) {
			avgPoint = 10f;
		}
		BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint)
				.setScale(1, RoundingMode.HALF_UP);
		return avgPointBd.doubleValue();
	}
	
}
