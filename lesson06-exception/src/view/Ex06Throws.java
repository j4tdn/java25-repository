package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {

	// compile(checked) exception: la nhung exception bat buoc minh phai xu ly tai thoi ddiem compile
	
	// runtime(unchecked) exception: la nhung exception k bat buoc phai xu ly tai thoi diem compile
	
	// xay ra --> thi ca 2 loai tren ddeu co the xay ra lun runtime, du trong code co bat buoc hay k thi 100% minh phai xu ly exception do
	
	// Khi throw 1 compile exception, tai vi tri khai bao ham phai throws dde cho goi ham biet va bat buoc phai xu ly compile exception do
	
	// Viec throws runtime exception la vo nghia
	// Vi ben trong ham throw runtime exception no k bat buoc phai throws, cho goi ham cung k bat buoc xu ly
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap ten File: ");
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
