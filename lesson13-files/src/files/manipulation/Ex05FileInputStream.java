package files.manipulation;

import java.util.List;

import bean.Apple;
import utils.FileUtils;

public class Ex05FileInputStream {

	private static final String PATH = "lesson13-files/storage/knowledge.txt";

	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		/*
		@SuppressWarnings("unchecked")
		List<String> lines = (List<String>)FileUtils.readObject(PATH);
		lines.forEach(System.out::println);
		*/
		
		@SuppressWarnings("unchecked")
		List<Apple> inventory = (List<Apple>)FileUtils.readObject(PATH);
		inventory.forEach(System.out::println);
		
		System.out.println("=== Main Page ends ===");
	}

}
