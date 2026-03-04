package sorting.bubble;
import static utils.PrintUtils.*;

public class Ex01BubbleSortlntRight {

	public static void main(String[] args) {
		
		int[] numbers = {4,2,2,5,0,9,1};
		generate("0. Danh sách các phần tử", numbers);
		sortAsc(numbers);
		generate("1. Sắp xếp tăng dần", numbers);
		sortDesc(numbers);
		generate("2. Sắp xếp giảm dần", numbers);
	}
	private static void sortAsc(int[] elements) {
		// Số vòng: sau mỗi vòng tìm được phần tử lớn nhất nằm bên phải(nổi bọt)
		for(int i=0; i< elements.length;i++) {
			for(int j=0; j < elements.length -i -1; j++) {
				if(elements[j] > elements[j+1]) {
					swap(elements,i,j);
				}
			}
		}
	}
	private static void sortDesc(int[] elements) {
		// Số vòng: sau mỗi vòng tìm được phần tử lớn nhất nằm bên phải(nổi bọt)
		for(int i=0; i< elements.length;i++) {
			for(int j=0; j < elements.length -i -1; j++) {
				if(elements[j] < elements[j+1]) {
					swap(elements,i,j);
				}
			}
		}
	}
	private static void swap(int[] elements, int i, int j) {
		int temp = elements[j];
		elements[j] = elements[j+1];
		elements[j+1] = temp;
	}
	
}
