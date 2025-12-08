package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	// compile(checked) exception: là những exception bắt buộc mình phải xử lý tại thời điểm compile
	// runtime(unchecked) exception: là những exception ko bắt buộc phải xử lý tại thời điểm compile
	
	// xảy ra --> thì cả 2 loại trên đều có thể xảy ra lúc runtime, dù trong code có bắt buộc hay ko thì 100% mình phải xử lý exception đó
	
	// khi throw 1 compile exception, tại ví trí khai báo hàm phải throws để chỗ gọi hàm biết và bắt buộc phải xử lý compile exception đó
	
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("NHAP TEN FILE: ");
		String filename = ip.nextLine();
		
		try {
			createFile(filename);
			System.out.println("TAO THANH CONG");
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
