package view;

import java.time.LocalDate;
import java.util.function.Function;

public class Ex02LamdaUsingLocalVariables {
	
	public static LocalDate excutionDate = LocalDate.now();

	public static void main(String[] args) {
		
		testLocalVars();
		
	}
	
	public static void testLocalVars() {
		
		 String taskName = "Excutor";
		
		Function<String, Integer> function = (String word) -> {
			String author = "@dev213";
			excutionDate = excutionDate.plusDays(1);
			
			System.out.println("Task " + taskName + " isimplementde by " + author + " at  " + excutionDate);
			
			return word == null ? 0 : word.length();
		};
		
		System.out.println("/nKết quả: " + function.apply("Xin chào"));
		
	}
	
	// sử dụng biến taskName tự chuyển sang final
	public static void testLocalVars2() {
	    String taskName = "Executor";

	    // anonymous class
	    Function<String, Integer> function = new Function<String, Integer>() {
	        @Override
	        public Integer apply(String word) {
	            String author = "@dev213";

	            // modify
//	            taskName = "Execution"; // Dòng này sẽ báo lỗi biên dịch
	            author = "@dev345";
	            excutionDate = excutionDate.plusDays(1);

	            System.out.println("Task " + taskName + " is implemented by " + author + " at " + excutionDate);

	            return word == null ? 0 : word.length();
	        }
	    };
	}
		
		
	
}
