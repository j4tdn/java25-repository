package files.manipulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import utils.FileUtils;

public class Ex02FileReaderAllLines {
	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		System.out.println(" === Main Page starts === ");
		FileUtils.read(PATH).forEach(System.out::println);
		System.out.println(" === Main Page ends === ");
	}
}