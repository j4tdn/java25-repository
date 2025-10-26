package exercises;

import java.time.LocalDate;

import bean.AllEmployee;
import bean.DepartmentHead;
import bean.Director;
import bean.Employee;
import utils.EmployeeManagement;

public class Ex04EmployeeManagement {
	public static void main(String[] args) {
		
		AllEmployee[] listEmployee = mockData();
		
		EmployeeManagement.showInfor(listEmployee);
		EmployeeManagement.countEmployeesByHead(listEmployee);
	}
	
	private static AllEmployee[] mockData() {
		
		Director dir = new Director("Huy", LocalDate.of(2005, 9, 2), 3d, 3d);
		
		DepartmentHead dHead1 = new DepartmentHead("Heo", LocalDate.of(2005, 9, 20), 2.5d, 2.5d, "Haha");
		DepartmentHead dHead2 = new DepartmentHead("Ga", LocalDate.of(2005, 2, 10), 2.0d, 2.0d, "Hehe");
		
		Employee e1 = new Employee("Ruoi", LocalDate.of(2005, 9, 20), 1d, "Haha", dHead1);
		Employee e2 = new Employee("Muoi", LocalDate.of(2005, 9, 20), 1d, "Haha", dHead1);
		Employee e3 = new Employee("Trau", LocalDate.of(2005, 9, 20), 1d, "Haha", dHead1);
		Employee e4 = new Employee("Chim", LocalDate.of(2005, 9, 20), 1d, "Hehe", dHead2);
		Employee e5 = new Employee("Da dieu", LocalDate.of(2005, 9, 20), 1d, "Hehe", dHead2);
		Employee e6 = new Employee("Vit", LocalDate.of(2005, 9, 20), 1d, "Hehe", dHead2);
		
		AllEmployee[] allEmployee = new AllEmployee[9];
		allEmployee[0] = dir;
		allEmployee[1] = dHead1;
		allEmployee[2] = dHead2;
		allEmployee[3] = e1;
		allEmployee[4] = e2;
		allEmployee[5] = e3;
		allEmployee[6] = e4;
		allEmployee[7] = e5;
		allEmployee[8] = e6;
		
		return allEmployee;
		
	}
}
