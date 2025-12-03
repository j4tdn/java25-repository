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
		generate("Danh sách nhân viên", storage);
		
		System.out.println("=== Thực hiện ghi file ===");
		
		File file = new File("storage-data.txt");
		writeFile(file, storage);
		
		System.out.println("=== Hoàn tất ghi file ===");
	}
	
	private static void writeFile(File file, Employee[] employees) {
		if(!file.exists()) {
			System.out.println(">>> Tập tin " + file.getName() + " chưa tồn tại!");
			return;
		}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			for(Employee employee : employees) {
				int age = employee.getAge();
				if(age < 18 || age > 60) {
					throw new InvalidAgeException();
				}
				String line = "NV" + employee.getId() + ", " + employee.getName() +
						", " + (employee.getAge() - 18) * 2;
				fw.write(line + "\n");
			}
		} catch (IOException | InvalidAgeException ex) {
			ex.fillInStackTrace();
		} finally {
			try {
				fw.close();
				Desktop.getDesktop().open(file);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void generate(String statement, Employee[] employees) {
		System.out.println(statement + "{");
		for(int i = 0; i < employees.length; i++) {
			System.out.println("	+ " + employees[i]);
		}
		System.out.println("}\n");
	}
	
	private static Employee[] mockData(int numberOfEmployees) {
		Employee[] employees = new Employee[numberOfEmployees];
		
		for(int i = 0; i < numberOfEmployees; i++) {
			Employee emp = new Employee(i + 1, "Nhân viên " + (i + 1), rd.nextInt(10,70));
			employees[i] = emp;
		}
		
		return employees;
	}
	
}
