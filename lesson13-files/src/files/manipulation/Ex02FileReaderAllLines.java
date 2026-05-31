package files.manipulation;

import java.io.File;

import utils.FileUtils;

public class Ex02FileReaderAllLines {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {

		File file = new File(PATH);

		FileUtils.read(PATH).forEach(System.out::println);
	}

}
