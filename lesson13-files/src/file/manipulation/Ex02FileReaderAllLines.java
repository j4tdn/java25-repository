package file.manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

import utils.FileUtils;

public class Ex02FileReaderAllLines {
	private static final String PATH = "lesson13-files/storage/template.txt";
	public static void main(String[] args) {
		
		
		FileUtils.read(PATH).forEach(System.out::println);
		
		System.out.println("==== Main page ends ====");
	
	}
	
}
