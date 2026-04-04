package view;

import java.util.function.Function;

public class Ex02LambdaUsingLocalVariable {

	public static void main(String[] args) {
		testLocalVars();
	}
	
	// Why when use a local variable a lambda, it must be effectively final
	// Local dùng trong lambda thực ra là biến đó đang được truyền
	// 		như là 1 tham số qua 1 method trong class khác
	//		Nếu biến đó sử dụng toán tử = thì nó sẽ được gán qua ô nhớ mới,
	//		ko thể update giá trị hiện tại
	public static void testLocalVars() {	
		// Local Variable
		// - if a variable is to be used in lambda, it must be final
		String taskName = "Executor";
		
		// Lambda
		Function<String, Integer> function = (String word) -> {
			String author = "@dev123";
			
			author = "@dev3445";
			
			System.out.println("Task" + " was implemented by " + author);
			
			return word == null ? 0 : word.length();
		};
		
		System.out.println("Call function: " + function.apply("hello"));		
	}
	
}
