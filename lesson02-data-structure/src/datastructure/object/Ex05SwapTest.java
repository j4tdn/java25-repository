package datastructure.object;

import bean.CustomInt;

public class Ex05SwapTest {
	public static void main(String[] args) {
		CustomInt a1 = new CustomInt(5);
		CustomInt a2 = new CustomInt(7);
		System.out.println(a1);
		System.out.println(a2);
		swap(a1, a2);
		System.out.println("====================After++++++++++");
		System.out.println(a1);
		System.out.println(a2);
	}

	private static void swap(CustomInt a1, CustomInt a2) {
		int temp = a1.value;
		a1.value = a2.value;
		a2.value = temp;
	}
}
