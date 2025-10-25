package function.lambda;

public class Ex01ArrayFider {

	public static void main(String[] args) {
	
		//	Viết chương trình đếm số lượng các phần tử là
	//	Số chẳn
	//	SỐ lẻ
	//	Số chia hết cho 3
	//	Số chia hết cho 5
		
		
		int[] number = {1, 5, 2, 8, 10, 20, 7, 18};

	
	}

	
	private static void countEventElements(int[] elements) {
		int count=0;
		for(int element : elements) {
			 if(element % 2 ==0) {
				 count++;
			 }
		}
	}
}
