package datastructure.object.variable;

public class Ex01ObjectTypeAvailable {

	public static void main(String[] args) {
		/*
		 * Vi tat ca cac KDL doi tuong trong JAVA chi co duy nhat 1 thuoc tinh
		 * Khi khai bao chi can ghi gia tri cua thuoc tinh do --> JAVA se tu tao doi tuong va truyen vao cho minh
		 * */
		Integer a = new Integer(11);
		Integer b = 12;
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(a));
	}

}
