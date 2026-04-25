package functional;

import java.time.LocalDate;
import java.util.function.Function;
import view.Ex02LamdaUsingLocalVariables;

public class TestFunction implements Function<String, Integer> {

	public static LocalDate excutionDate = LocalDate.now();
    private String taskName;

    public TestFunction(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public Integer apply(String word) {
        String author = "@dev213";

        // modify
        taskName = "Execution";
        author = "@dev345";
        Ex02LamdaUsingLocalVariables.excutionDate = Ex02LamdaUsingLocalVariables.excutionDate.plusDays(1);

        System.out.println("Task " + taskName + " is implemented by " + author + " at " + excutionDate);

        return word == null ? 0 : word.length();
    }
}