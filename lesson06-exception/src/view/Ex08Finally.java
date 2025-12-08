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
		Employee[] storage = mocdata(100);

		genarate("DANH SACH NHAN VIEN", storage);

		System.out.println("... THUC HIEN GHI FILE ...");

		writeFile(new File("storage-data.txt"), storage);

	}

	private static void writeFile(File file, Employee[] employees) {
		if (!file.exists()) {
			System.out.println(">>> File " + file.getName() + "CHUA TON TAI");
			return;
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);

			for (Employee employee : employees) {
				int age = employee.getAge();
				if (age < 18 || age > 60) {
					throw new InvalidAgeException();
				}
				String line = "NV" + employee.getId() + ", " + employee.getName() + ", " + (employee.getAge() - 18) * 2;
				fw.write(line + "\n");
			}

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

	private static void genarate(String statment, Employee[] employees) {
		System.out.println(statment + "{");
		for (Employee emloyee : employees) {
			System.out.println("   + " + emloyee);
		}
		System.out.println("}\n");
	}

	private static Employee[] mocdata(int numberOfEmployee) {
		Employee[] employees = new Employee[numberOfEmployee];

		for (int i = 0; i < numberOfEmployee; i++) {
			Employee emp = new Employee(i + 1, "NHAN VIEN", rd.nextInt(18, 60));
			employees[i] = emp;
		}
		return employees;

	}

}
