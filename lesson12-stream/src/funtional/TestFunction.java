package funtional;

import java.util.function.Function;

import view.Ex02LambdaUsingLocalVariables;

public class TestFunction implements Function<String, Integer> {
	
	private String taskName;
	
	// H1
	public TestFunction(String taskName) {
		this.taskName = taskName;
	}
	
	@Override
	public Integer apply(String word) {
		String author = "@dev213";

		// modify
		taskName = "Execution"; // H2
		author = "@dev345";
		Ex02LambdaUsingLocalVariables.excutionDate = Ex02LambdaUsingLocalVariables.excutionDate.plusDays(1);

		System.out.println("Task " + taskName + " is implemented by " + author + " at " + Ex02LambdaUsingLocalVariables.excutionDate);

		return word == null ? 0 : word.length();
	}
	
}