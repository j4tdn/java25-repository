package view;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

import bean.Apple;
import funtional.TestFunction;

public class Ex02LambdaUsingLocalVariables {
	
	public static LocalDate excutionDate = LocalDate.now();
	
	public static void main(String[] args) {
		// testLocalVars1();
		// testLocalVars2();
		
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,2,8,3);
		
		int max = Integer.MIN_VALUE;
		
//		numbers.forEach(number -> {
//			if (number > max) {
//				max = number;
//			}
//		});
		
		System.out.println("max = " + max);
	}
	
	public static void testLocalVars1() {
		// Lambda
		// - sử dụng local variable: ngầm định là final
		
		// Local variable
		// - khi sử dụng trong lambda: yêu cầu là final hoặc nếu ko khai báo file thì tự chuyển sang final
		String taskName = "Executor";
		Apple apple = new Apple();
		
		// lambda
		Function<String, Integer> function = (String word) -> {
			String author = "@dev213";
			
			// modify
			// taskName = "Execution";
			// apple = new Apple();
			apple.setId(12);
			author = "@dev345";
			excutionDate = excutionDate.plusDays(1);
			
			System.out.println("Task " + taskName + " is implemented by " + author + " at " + excutionDate);
			
			return word == null ? 0 : word.length();
		};
		
		System.out.println("\nKết quả: " + function.apply("welcome"));
	}
	
	// Vì sao 1 biến cục bộ (local variable) khi được sử dụng trong lambda --> ngầm định chuyển sang final
	
	// Local variable dùng trong lambda thực ra là: biến đó đang được truyền như là 1 tham số qua class khác
	// khi biến truyền qua hàm, biến đó có thể cập nhật giá trị tại heap chứ ko thể cập nhật giá trị địa chỉ của biến đó --> chứng tỏ là final
	
	// khi dùng trong lambda --> ngầm định là final để ko thể cập nhật địa chỉ của biến đó
	
	// Ex02LambdaUsingLocalVariables
	//    method#testLocalVars2
	//       taskName
	
	// AnonymousClass
	//    method#apply
	//       sử dụng biến taskName tự chuyển sang final
	
	public static void testLocalVars2() {
		String taskName = "Executor"; // H1
		
		// anonymous class
		Function<String, Integer> function = new TestFunction(taskName);

		taskName = "goodbye";

		System.out.println("\nKết quả: " + function.apply("welcome"));
	}
	
}