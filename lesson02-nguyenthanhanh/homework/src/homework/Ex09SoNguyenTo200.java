package homework;

public class Ex09SoNguyenTo200 {

	public static void main(String[] args) {
		
		int orderedNumber = 200;
		int runningNumber = 2;
		int count = 0;
		while(true) {
			if(Ex08SoNguyenTo.isPrime(runningNumber)) {
				count++;
				if(count == orderedNumber) {
					break;
				}
			}
			runningNumber++;
		}
		
		System.out.println("Số nguyên tố thứ " + count + " --> " + runningNumber);
		
	}
	
}
