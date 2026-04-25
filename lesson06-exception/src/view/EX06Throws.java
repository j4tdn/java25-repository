package view;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class EX06Throws {

	//Compile exception: là những exception bắt buộc mình pahir sử lý tại thời điểm compile
	
	// runtime exception: những exception không bắt buộc phải xử lý tại thời điểm compile
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập tên file: ");
		String filename = ip.nextLine();
		
		try {
			createFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ip.close();
	}
	
	
	private static void createFile(String filename) throws IOException {
		File file = new File(filename);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
}
