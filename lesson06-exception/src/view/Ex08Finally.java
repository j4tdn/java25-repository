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

		genarate("DS Nhan vien --> ", storage);

		System.out.println("Thuc hien ghi file");

		writeFile(new File("storage-data"), storage);

		System.out.println("\n\nHoan thanh ghi file");
	}

	private static void writeFile(File file, Employee[] employees) {
		if (!file.exists()) {
			System.out.println(">>> Tap tin " + file.getName() + " chua ton tai");
			return;
		}
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);

			for (Employee emp : employees) {
				int age = emp.getId();
				if (age < 18 || age > 60) {
					throw new InvalidAgeException();
				}
				String line = "NV" + emp.getId() + ", " + emp.getName() + ", " + (emp.getAge() - 18) * 2;
				fw.write(line + "\n");
			}

		} catch (IOException | InvalidAgeException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();

				Desktop.getDesktop().open(file);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void genarate(String statement, Employee[] employees) {
		System.out.println(statement + "{");
		for (Employee emp : employees) {
			System.out.println("+" + emp);
		}
		System.out.println("}\n");
	}

	private static Employee[] mockData(int numberOfEmployees) {
		Employee[] employees = new Employee[numberOfEmployees];

		for (int i = 0; i < numberOfEmployees; i++) {
			Employee emp = new Employee(i + 1, "Nhan Vien" + (i + 1), rd.nextInt(18, 60));
			employees[i] = emp;
		}
		return employees;
	}
}
