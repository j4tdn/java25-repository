package view;

import bean.car;

public class Ex06EqualMethod {
	public static void main(String[] args) {
		/*
		 * Lí thuyết 
		 * -Biến kdl nguyên thuỷ
		 * -stack: giá trị thực tế
		 * Biến kdl đối tượng'
		 * -stack địa chỉô nhớ tại heap mà nó trỏ đến 
		 * -heap: giá trị thựic tế của dối tường 
		 * Để so sánh 2 giá trị của 2 biến có bằng nhauh không thì thường sử dụng toán tử ==
		 * Khi sử dụng toán tử == 
		 * Dùno toán tử  == 2 biến nguyên  thuỷ thì ss giá trị bình thường 
		 * Dùng toán tử == 2 biến đối tườn --> so sánh địa chỉ (so xem 2 biến này cói đang trỏ cùng 1 địa chỉ không )
		 * --> Muốn ss giá trị của 2 biewens đối tươngjiii
		 * --> Đối tườn có thể có nhiều thuộc tính khid ss cần như nào để để 2 đói tườn bănhdf nhau 
		 * 
		 * Với các class có sẵn của java nhưnntegr string double Long Bigdecimal đã thừa kế và override lại hàm equal từ class object rồi để so sánh theo giá trị 
		 */
		car c1 = new car(1,"honda","cry",1204d, null);
		car c2 = new car(2,"honda","cry",1224d, null);
		car c3 = new car(3,"honda","cry",3874d, null);
		System.out.println("c1 == c2"+(c1==c2));
		System.out.println("c1 == c2 "+ (c1.equals(c2)));
		String s1 = "hello";
		String s2 = "hello";
		System.out.println("s1 == s2"+(s1==s2));
	}
}
