package view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import bean.Employee;

public class Ex08Finally {

	private static Random rd = new Random();
	public static void main(String[] args) {
		
		Employee[] storage = mockData(100);
		storage[67].setAge(12);
		
		generate("Danh sách nhân viên -->", storage);
		
		
		
		System.out.println("Thực hiện ghi file");
		writeFile(new File("storage-data.txt"), storage);
		System.out.println("\n Hoàn thành");
		
	}
	
	private static void writeFile(File file, Employee[] employees) {
		if(!file.exists()) {
			System.out.println(">>> File " + file.getName() + "chưa tồn tại");
			return;
		}
		 
		FileWriter fw = null;
		try {
			 fw = new FileWriter(file);
			 
			 for(Employee employee: employees) {
				 String line = "NV" + employee.getId() + ", " + employee.getNane() + "," + (employee.getAge() - 18) * 2;
				 fw.write(line + "\n");
			 }
			 fw.close();
			 
			 Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void generate(String statement, Employee[] employees) {
		System.out.println(statement +"{");
		for(Employee employee: employees) {
			System.out.println("  + " + employee);
		}
		System.out.println("}\n");
	}
	
	private static Employee[] mockData(int numberOfEmployee) {
		Employee[] employees = new Employee[numberOfEmployee];
		
		for(int i = 0; i < numberOfEmployee; i++) {
			Employee emp = new Employee(i+1, "Nhân Viên" + (i+1), rd.nextInt(18, 60));
			employees[i] = emp;
		}
		
		return employees;
	}
}
