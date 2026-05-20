package files.manipulation;

import utils.FileUtils;

public class Ex02FileReaderAllLines {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		FileUtils.read(PATH).forEach(System.out::println);

		System.out.println("=== Main Page ends ===");
	}
}