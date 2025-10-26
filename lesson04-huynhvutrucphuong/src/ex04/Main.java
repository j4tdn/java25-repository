package ex04;

import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		Director director = new Director("Huynh Vu Truc Phuong", "2004-28-06", 4.5, 1.2);

        Manager manager1 = new Manager("Tran Thi B", "1985-06-05", 3.5, 0.8, "IT Department");
        Manager manager2 = new Manager("Le Van C", "1988-09-09", 3.8, 0.9, "HR Department");

        List<Employee> employees = new ArrayList<>();

        employees.add(director);
        employees.add(manager1);
        employees.add(manager2);

        // 6 staff
        employees.add(new Staff("Nguyen D", "1995-02-11", 2.5, 0.0, "IT Department", "Tran Thi B"));
        employees.add(new Staff("Tran E", "1996-07-21", 2.7, 0.0, "IT Department", "Tran Thi B"));
        employees.add(new Staff("Huynh F", "1997-12-12", 2.6, 0.0, "IT Department", "Tran Thi B"));
        employees.add(new Staff("Le G", "1994-03-05", 2.8, 0.0, "HR Department", "Le Van C"));
        employees.add(new Staff("Ha H", "1998-08-19", 2.4, 0.0, "HR Department", "Le Van C"));
        employees.add(new Staff("Do I", "1999-11-29", 2.5, 0.0, "HR Department", "Le Van C"));

        // === a. Display all employees ===
        System.out.println("=== COMPANY STAFF LIST ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // === b. Count staff per manager ===
        System.out.println("\n=== STAFF COUNT BY MANAGER ===");
        int countManager1 = 0, countManager2 = 0;
        for (Employee e : employees) {
            if (e instanceof Staff) {
                Staff s = (Staff) e;
                if (s.toString().contains(manager1.fullName)) countManager1++;
                if (s.toString().contains(manager2.fullName)) countManager2++;
            }
        }
        System.out.println(manager1.fullName + " manages " + countManager1 + " staff(s).");
        System.out.println(manager2.fullName + " manages " + countManager2 + " staff(s).");

        // === c. Calculate and print salaries ===
        System.out.println("\n=== SALARY LIST ===");
        for (Employee e : employees) {
            System.out.printf("%-50s | Salary: %.0f VND%n", e.fullName, e.calculateSalary());
        }
    }

}