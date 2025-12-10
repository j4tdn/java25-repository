package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	
	// compile(checked) exception: la nhung exception bat buoc phai phai xu ly tai thoi diem compile
	
	// runtime(unchecked) exception: la nhung exception khong bat buoc phai xy ly tai thoi duem compile
	
	// xay ra --> thi ca 2 loai tren deu co the xay ra luc runtime
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap ten file: ");
		String filename = ip.nextLine();
		
		try {
			createFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ip.close();
	}
	
	private static void createFile(String filename) throws 	IOException{
		
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
			
		}
	}

}
