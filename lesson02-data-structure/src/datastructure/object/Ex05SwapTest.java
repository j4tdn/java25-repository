package datastructure.object;

import bean.CustomInt;

public class Ex05SwapTest {
	public static void main(String[] args) {
		CustomInt a1 = new CustomInt(5);
		CustomInt a2 = new CustomInt(7);
	}
	
	//a1 = a1 a2 = a2
	private static void swap(CustomInt b1, CustomInt b2) {
		CustomInt tmp = b1;
		b1 = b2;
		b2 = tmp;
	}
}
