package view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import bean.Employee;
import exception.InvalidAgeException;

public class Ex08Finally {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		Employee[] storage = mockData(100);
		storage[67].setAge(12); // NV68
		
		generate("Danh sách nhân viên --> ", storage);
		
		// 'NV' + id, name, factor = (age - 18) * 2
		// if(age[18, 60]) --> nếu vượt khỏi --> data không hợp lệ
		
		System.out.println("... Thực hiện ghi file ... ");
		
		
		writeFile(new File("storage-data.txt"), storage);
		
		System.out.println("\n\n... Hoàn thành ... ");
 	}
	
	private static void writeFile(File file, Employee[] employees) {
		if (!file.exists()) {
			System.out.println(">>> Tập tin "+ file.getName() + " chưa tồn tại !!!");
			return;
		}
		
		FileWriter fw = null;
		
		try {
			 // connect file
			 fw = new FileWriter(file);
			 
			 for (Employee employee: employees) {
				 int age = employee.getAge();
				 String line;
				 if (age < 18 || age > 60) {
					 line = ">> Dữ liệu của NV" + employee.getId() + " không hợp lệ"; 
				 } else {
					 line = "NV" + employee.getId() + ", " + employee.getName() + ", " + (employee.getAge() - 18) * 2;
				 }
				 fw.write(line + "\n");
			 }
			 
			 // TH1: Nếu dòng thứ k bị lỗi --> Ghi dữ liệu từ 1-(k-1), sau đó ko ghi
			 // TH2: Nếu dòng nào lỗi, ko ghi
			 //          dòng nào ok ghi vào
			 
			 
		} catch (IOException | InvalidAgeException e) {
			e.printStackTrace();
		} finally {
			try {
				// save & close file
				fw.close();
				
				// open file
				Desktop.getDesktop().open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void generate(String statement, Employee[] employees) {
		System.out.println(statement + "{");
		for (Employee employee: employees) {
			System.out.println("    + " + employee);
		}
		System.out.println("}\n");
	}
	
	private static Employee[] mockData(int numberOfEmployees) {
		Employee[] employees = new Employee[numberOfEmployees];
		
		for (int i = 0; i < numberOfEmployees; i++) {
			Employee emp = new Employee(i+1, "Nhân viên " + (i+1), rd.nextInt(18, 60));
			employees[i] = emp;
		}
		
		return employees;
	}
	
}
