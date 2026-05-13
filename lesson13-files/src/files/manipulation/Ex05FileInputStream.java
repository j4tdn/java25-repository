package files.manipulation;

import java.util.List;

import bean.Apple;
import utils.FileUtils;

public class Ex05FileInputStream {
	
	private static final String PATH = "lesson13-files/storage/knowledge.txt";

	public static void main(String[] args) {
			@SuppressWarnings("unchecked")
			List<Apple> lines = (List<Apple>) FileUtils.readObject(PATH);
			
			lines.forEach(System.out::println);
	
	}

}
