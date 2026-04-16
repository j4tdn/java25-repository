package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Apple;
import common.Color;
import model.DataModel;
import utils.PrintUtils;

import static java.util.Comparator.*;
import static common.Color.*;

import java.math.BigDecimal;

public class Ex03MethodReference {
	
	public static void main(String[] args) {
		
		List<Apple> inventory = DataModel.mockAppleList();
		
		// Bài toán 1: In danh sách các phần tử trong kho
		
		System.out.println("=== Dạng 1: Dùng cho rút gọn tham số, hàm ===");
		// (T ... ts) -> X.y.method(...ts) --> X.y::method
		
		// Lambda
		Consumer<Apple> c1 = (Apple apple) -> System.out.println(apple);
		
		// Method reference
		// System.out::println là 1 đối tượng, thể hiện của functional interface
		Consumer<Apple> c2 = System.out::println;
		
		inventory.forEach(c1);
		inventory.forEach(c2);
		
		// Bài toán 2: Từ kho hàng, lấy tất cả các id || name || expiredDate ....
		
		System.out.println("\n=== Dạng 2: Tham chiếu từ 1 phướng thức của class ===");
		// (T t) -> t.method() ==> T::method
		
		Function<Apple, String> countryGetter = Apple::getOriginalCountry;
		
		Set<Integer> ids = mapping(inventory, apple -> apple.getId());
		Set<String> countries = mapping(inventory, countryGetter);
		
		ids.forEach(System.out::println);
		countries.forEach(System.out::println);
		
		System.out.println("---------------------------------");
		
		// Dạng 2: Áp dụng .... sorting
		
		// Sắp xếp nguồn gốc xuất xứ tăng dần
		
		List<Apple> clonedData = new ArrayList<>(inventory);
		clonedData.add(2, null);
		clonedData.add(5, null);
		
		Comparator<Apple> comparator = (a1, a2) -> {
			return a1.getOriginalCountry().compareTo(a2.getOriginalCountry());
		};
		
		// comparing: hàm viết lại cho lambda của comparator truyền vào 2 ptu trước sau rồi get thông tin gì đó để so sánh
		// Apple::getOriginalCountry: method reference của Apple apple -> apple.getOriginalCountry
		// nullsFirst hay nullsLast chỉ hỗ trợ khi từng phần tử của danh sách bị null
		// nếu như thuộc tính của đối tượng bị null thì nullsFirst|Last ko hỗ trợ
		Comparator<Apple> newComparator = nullsFirst(
				comparing(Apple::getOriginalCountry).
				thenComparing(Apple::getWeight));
		
		clonedData.sort(newComparator);
		clonedData.forEach(System.out::println);
		
		/*
		 Để tạo đối tượng cho
		 - interface[1 hoặc nhiều hàm trừu tượng]: 
		   . tạo 1 lớp thực thi, override 1 hoặc nhiều hàm trừu tượng --> new lớp thực thi
		   . new interface ra, override ... --> sử dụng anonymous class
		   
		 - functional interface
		  . giống như trên: implementation class
		  .               : anonymouse class
		  . sử dụng anonymous function[lambda] để override lại hàm trừu tượng
		    --> method reference
		        - có 2 dạng: non static method reference [1 số dạng đặc biệt ghi nhớ]
		                         static method reference [có công thức]
		                         --> tạo ra 1 hàm static ở bất kỳ class nào mình muốn
		                         --> thay anonymous function = function cụ thể
		                             khi thấy lambda dài và có thể reuse 1 số chỗ --> method reference
		 */
		
		PrintUtils.generate("1. In ra các quả táo từ Việt Nam, màu xanh và cân nặng hơn trung bình", 
				filter(inventory, Ex03MethodReference::appleTest));
	}
	
	private static boolean appleTest(Apple apple) {
		return apple.getOriginalCountry().equals("VN")
				&& List.of(GREEN, BLUE).contains(apple.getColor())
				&& apple.getWeight().compareTo(new BigDecimal("200")) > 0;
	}
	
	
	private static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
		List<T> target = new ArrayList<>();
		for (T element: elements) {
			if (predicate.test(element)) {
				target.add(element);
			}
		}
		return target;
	}
	
	private static <T, R> Set<R> mapping(List<T> elements, Function<T, R> propertyGetter) {
		Set<R> target = new HashSet<>();
		elements.forEach(element -> {
			target.add(propertyGetter.apply(element));
		});
		return target;
	}
	
}
