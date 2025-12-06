package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	
	// compiled - checked Exception bat buoc phai xu ly throws hoac throw Exception cha cua no (có thể gặp với những hàm có sẵn của Java)
	// runtime - unchecked Exception
	
	// xảy ra --> thì cả 2 loại trên đều có thể xảy ra lúc runtime, dù trong code có bắt buộc hay không thì 100% mình phải xử lý Exception đó
	
	// khi throw 1 compile Exception, tại vị trí khai báo hàm phải throws để chỗ gọi hàm biết và bắt buộc phải xử lý compile Exception đó
	
	// Việc throws runtime Exception là vô nghĩa
	// Vì bên trong hàm throw runtime exception nó không bắt buộc phải throws, chỗ gọi hàm cũng không bắt buộc phải xử lý


	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap ten file: ");
		String fileName = ip.nextLine();


		ip.close();
	}

	private static void createFile(String fileName) throws IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
}
