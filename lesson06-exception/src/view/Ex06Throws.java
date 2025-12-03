package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	
	// compile (checked) exception: là những exception bắt buộc phải handle ở compile time
	// runtime (checked) exception: là những exception ko bắt buộc phải handle ở compile time
	// xảy ra --> cả 2 100% đều xảy ra ở runtime
	
	// việc throws RuntimeException là vô nghĩa
	// vì bên trong hàm throw runtime exception nó ko bắt buộc throw,
	//		, chỗ gọi hàm cũng k bắt buộc phải xử lý

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập tên file: ");
		String filename = ip.nextLine();
		
		try {
			createFile(filename);
		} catch (IOException ex) {
			ex.printStackTrace();
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
