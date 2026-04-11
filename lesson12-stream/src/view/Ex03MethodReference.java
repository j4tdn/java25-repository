package view;

import java.math.BigDecimal;
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

public class Ex03MethodReference {

	public static void main(String[] args) {
		List<Apple> inventory = DataModel.mockAppleList();

		// Dạng 1 rút gọn tham số, hàm
		// (T ...ts) -> X.y.method(...ts) -> X.y::method
		System.out.println("=== Dạng 1: rút gọn tham số, hàm ===");
		inventory.forEach((apple) -> System.out.println(apple));

		// lambda
		Consumer<Apple> c1 = (Apple apple) -> System.out.println(apple);

		// Method reference
		// System.out::println là một đối tượng, thể hiện của functional interface
		Consumer<Apple> c2 = System.out::println;

		// Dạng 2: Tham chiếu từ 1 phương thức class
		System.out.println("\n=== Dạng 2: Tham chiếu từ 1 phương thức class ===");

		Set<Integer> ids = mapping(inventory, apple -> apple.getId());
		Set<String> countries = mapping(inventory, Apple::getOriginalCountry);

		Function<Apple, String> countryGetter = Apple::getOriginalCountry;

		ids.forEach(System.out::println);
		countries.forEach(System.out::println);

		System.out.println();
		// Dạng 2: Áp dụng .... sorting

		List<Apple> clonedData = new ArrayList<>(inventory);

		Comparator<Apple> comparator = ((a1, a2) -> {
			return a1.getOriginalCountry().compareTo(a2.getOriginalCountry());
		});

		// comparing: hàm viết lại cho lambda của comparator truyền vào 2 ptu trước sau
		// rồi get thông tin gì đó so sánh
		// Apple::getOriginalCountry: method reference của Apple apple ->
		// apple.getOriginalCountry
		// nullFirst hay nullLast chỉ hỗ trợ khi từng phần tử của danh sách bị null
		// nếu như thuộc tính của đối tượng bị null thì nullsFirst|Last ko hỗ trợ
		Comparator<Apple> newComparator = Comparator.comparing((Apple apple) -> apple.getOriginalCountry());

		clonedData.sort(comparator);

		/*
		 * Để tạo đối tượng cho - interface: . tạo 1 lớp thực thi, override 1 hoặc nhiều
		 * hàm trừu tượng --> new lớp thực thi . new interface ra, override ... --> sử
		 * dụng anonymous class
		 * 
		 * - functional interface 
		 *   . giống như trên: implementation class 
		 *   . 				 : anonymous class 
		 *   . sử dụng anonymous function[lambda] để override lại hàm trừu tượng
		 *   --> method reference 
		 *   - có 2 dạng: non static method reference [1 số dạng đặc biệt ghi nhớ] 
		 *                    static method reference [có công thức]
		 *                    --> Tạo ra 1 hàm static ở bất kỳ class nào mình muốn
		 *                    --> thay anonymous function = function cụ thể
		 *                        khi thấy lambda dài và có thể reuse một số chỗ --> method reference
		 *   --> constructor reference
		 *       - khi lambda (parameters ...) -> {body} có body return gọi đến 1 hàm khởi tạo thay thế nó
		 *         bằng constructor reference với dạng Classname::new
		 */

		PrintUtils.generate("1. In ra các quả táo từ Việt Nam", filter(inventory, Ex03MethodReference::appleTest));
	}
	
	private static boolean appleTest(Apple apple) {
			return apple.getOriginalCountry().equals("VN")
					&& List.of(Color.GREEN, Color.BLUE).contains(apple.getColor())
					&& apple.getWeight().compareTo(new BigDecimal("200")) > 0;
	}

	private static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
		List<T> target = new ArrayList<>();
		for (T element : inventory) {
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
