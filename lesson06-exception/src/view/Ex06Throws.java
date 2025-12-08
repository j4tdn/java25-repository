package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	// compile(checked) exception: là những exception bắt buôc mình phải xử lý tai thời điểm compile


	// runtime(unchecked) exception: là những exception không bắt buôc phải xử lý tai thời điểm compile


	// xảy ra -> thì cả 2 loai trên đều có thể xảy ra lúc runtime, dù trong code có bắt buôc hay ko thì 100%
	// mình nhán xứ tú exception đó

	// Khi throw 1 compile exception, tai vi trí khai báo hàm phải thows để chỗ gọi hàm biết và bắt buộc phải xử lý compile exception đó


	// viêc throws runtime exception là vô nghĩa
	// Vì bên trong hàm throw runtime exception nó ko bắt buôc phải throws, chỗ goi hàm cũng ko bắt buôc xử lý
	
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhâp tên file: ");
		
		String filename = ip.nextLine();
		
		try {
			createFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ip.close();
	}
	private static void createFile(String filename) throws IOException {
		File file = new File(filename);
		if (file.exists()) {
			file.createNewFile();
		}
	}
}
