package sorting.quick;

import bean.Item;
import model.DataModel;

import static util.PrintUtils.*;

import java.util.Arrays;

public class Ex02SortItem {

	public static void main(String[] args) {
	
		Item[] items = DataModel.mockData();
		
		generate("0. Du lieu ban dau", items);
		
		/*
		Cach 1: Arrays.sort(Object[] objects)
		 - object co the nhan bat ky KL mang doi tuong nao
		 - yeu cau KDL cua doi tuowgn truyen vao
		 	- phai la Comparable hoac implements Comparable interface
		 	- de override lai ham e1.compareTo(e2) de biet dc cach thuc
		 	- tang/giam ddan theo thuoc tinh gi do
		 	- voi e1, e2 lll phan tu truowc, sau trong mang obleects
			
		Muon dung  Arrays.sort(Object[] objects) thi
			- KDL cua class cho mang phai implement Comparable<T>
			- override lai CompareTo(T o) [stragegy] de xac dinh cach thuc sort
			
		Han che
			- Chi co 1 cho la T#compareTo de xac dinh cach thuc Sort nen neu bai toan
			can nhieu cach sort khac nhau thi k xu ly dc
 		
 		Cach 2: Arrays.sort(T[] elements, Comparator<? super T> comparator)
 		- elements mang voi tung phan tu la T
 		- comparator: strategy voi int compare(T o1, T o2) de xac ddinh cach thuc sort
 		
 		Comparable<T> ==> int compareTo(T o)
 		
 		Comperator<T> ==> int compare(T o1, T o2)
 		 */
		
		System.out.println("============ comparatable ============");
		
		Arrays.sort(items);
		generate("1. Sx tang dan theo gia ban", items);
		
		Arrays.sort(items);
		generate("2. Sx giam dan theo ten mat hang", items);
		
		System.out.println("============ comparator ============");
		
		Arrays.sort(items, (item1, item2) -> item1.getSalesPrice().compareTo(item2.getSalesPrice()));
	}
	
}
