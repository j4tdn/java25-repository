package view;

import java.time.LocalDate;
import java.util.function.Function;

public class Ex02LambdaUsingLocalVariable {
	
	public static LocalDate executionDate = LocalDate.now();
	
	public static void main(String[] args) {
		
	}

	public static void testLocalVars() {
		// Lambda
		// - sử dụng các biến bên trong bản thân nó (không giới hạn)
		// - sử dụng local variable: ngầm định là final
		
		// bien cuc bo
		// - Khi sử dụng trong lambda: yêu cầu là final hoặc nếu không khai báo final thì tự động chuyển sang final
		String taskName = "Executor";
		
		Function<String, Integer> function = (word) -> {
			String author = "@dev213";
			
//			taskName = "Execution";
			author = "@dev345";
			System.out.println("Task "+taskName+"Implemented by " + author+" at " + executionDate);
			
			return word == null ? 0 : word.length();
		};
		
		System.out.println("Gọi function: " + function.apply("Welcome"));
	}
	
	public static void testLocalVars2() {
		// Lambda
		// - sử dụng các biến bên trong bản thân nó (không giới hạn)
		// - sử dụng local variable: ngầm định là final

		
		// bien cuc bo
		// - Khi sử dụng trong lambda: yêu cầu là final hoặc nếu không khai báo final thì tự động chuyển sang final
		// - dùng trong lambda thực ra là: biến đó đang được truyền như 1 tham số qua class khác
		// - Khi biến đó truyền qua hàm, nếu biến đó sử dụng toán tử = --> gán qua 1 ô nhớ mới hoàn không thể cập nhật giá trị của địa chỉ hiện tại
		//   cập nhật giá trị tại HEAP chứ không thể cập nhật địa chỉ ở biến đó được
		String taskName = "Executor";
		
		// anonymous class
//		Function<String, Integer> function = new Function<String, Integer>() {
//			taskName = "Execution";
//			
//			@Override
//			public Integer apply(String t) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
		
//		System.out.println("Gọi function: " + function.apply("Welcome"));
	}
}
