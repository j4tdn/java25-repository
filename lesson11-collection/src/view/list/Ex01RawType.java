package view.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Ex01RawType {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Khai bao cau truc du lieu trong Collection(s)
		
		// Tu JDK 1.0 -> 1.4
		// Khi 1 type can tham so hoa cho Generic Type, nei minh k truyen KDL doi tuong cho Generic Type -> hien warning la raw type
		// Mac inh se la Object --> nhan bat ky KDL nao vao
		
		// Raw Type
		// Loi ich: them phan tu voi gia tri o bat ky KDL nao
		// Han che: thieu su rang buoc pham vi du lieu
		
		// Generic Type
		// Loi ich: rang buoc KDDL ro rang, hoo tro bat loi tai compile neu truyen du lieu k dung
		
		// Luu danh sach cac so nguyen
		// Luu danh sach cac ki tu
		
		// 1.4 List list = new ArrayList();
		// 1.5 List<T> list = new ArrayList<T>();
		// 1.7 List<T> list = new ArrayList<>(); 
		
		List<Integer> listA = new ArrayList<>();
	
		@SuppressWarnings("rawtypes")
		List listB = new LinkedList();
		
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		// compile error
//		listA.add(new Date());
//		listA.add("Five");
		
		listB.add('A');
		listB.add('B');
		listB.add('C');
		listB.add('D');
		listB.add('E');
		
		System.out.println("ListA size: " + listA.size());
		System.out.println("ListB size: " + listB.size());
		
		System.out.println("========= ListA elements x double =========");
		for(Object number: listA) {
			int value = Integer.parseInt(String.valueOf(number)); // casting Object -> int
			System.out.println(value * 2);
		}
	}
	
}
