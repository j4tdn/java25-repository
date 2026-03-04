package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	
	// compile(checked) exception: là những exception bắt buộc mình phải xử lý tại thời điểm compile
	
	// runtime(unchecked) exception: là những exception không bắt buộc phải xử lý tại thời điểm compile
	
	// xảy ra --> thì cả 2 loại trên đều có thể xảy ra lúc runtime, dù trong code có bắt buộc hay ko thì 100% mình phải xử lý exception đó
	
	// Khi throw 1 compile exception, tại vị trí khai báo hàm phải throws để chỗ gọi hàm biết và bắt buộc phải xử lý compile exception đó
	
	// Việc throws runtime exception là vô nghĩa
	// Vì bên trong hàm throw runtime exception nó ko bắt buộc phải throws, chỗ gọi hàm cũng ko bắt buộc xử lý
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập tên file: ");
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
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
}