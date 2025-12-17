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
		storage[67].setAge(12);

		generate("Danh sach nhan vien --> ", storage);

		System.out.println("...Thuc hien ghi file...");

		writeFile(new File("storage-data.txt"), storage);

		System.out.println("\n...Hoan Thanh...");

		// 'NV' + id, name, factor = (age -18) * 2
		// if(age[18, 60]) neu vuot khoi --> data khong hop le
	}

	private static void writeFile(File file, Employee[] employees) {

		if (!file.exists()) {
			System.out.println(">>> Tap Tin " + file.getName() + " chua ton tai !!!");
			return;

		}
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);

			for (Employee employee : employees) {
				String line;
				int age = employee.getAge();
				if (age < 18 || age > 60) {
					line = "Du lieu cua NV" + employee.getId() + " khong hop le ";
				} else {
					line = "NV " + employee.getId() + ", " + employee.getName() + ", " + (employee.getAge() - 18) * 2;
				}
	
				fw.write(line + "\n");
			}

			
		} catch (IOException | InvalidAgeException e) {
			e.printStackTrace();
		} finally {
			// save & close file
			try {
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
		for (Employee employee : employees) {
			System.out.println("       + " + employee);
		}
		System.out.println("}\n");
	}

	private static Employee[] mockData(int numberOfEmployees) {

		Employee[] employees = new Employee[numberOfEmployees];

		for (int i = 0; i < numberOfEmployees; i++) {
			Employee emp = new Employee(i + 1, "Nhan vien" + (i + 1), rd.nextInt(18, 60));
			employees[i] = emp;
		}

		return employees;

	}

}
