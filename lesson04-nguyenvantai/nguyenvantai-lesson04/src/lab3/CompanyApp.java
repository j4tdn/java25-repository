package lab3;

import java.time.LocalDate;

public class CompanyApp {
	public static void main(String[] args) {
		Director d1 = new Director("Nguyễn Văn A", LocalDate.of(2005, 12, 3), 5d, 2d);
		Manager[] managers = { new Manager("Lê Văn C", LocalDate.of(2003, 5, 15), 4d, 1.5d, "Nhân sự"),
				new Manager("Trần Thị B", LocalDate.of(2004, 7, 18), 4.5d, 1.8d, "Kinh doanh") };

		Employee[] employees = { new Employee("Phạm Thị D", LocalDate.of(2002, 3, 20), 3d, "Kinh doanh", "Trần Thị B"),
				new Employee("Võ Văn E", LocalDate.of(2001, 8, 25), 3.5d, "Nhân sự", "Lê Văn C"),
				new Employee("Võ Văn F", LocalDate.of(2000, 9, 25), 3.5d, "Nhân sự", "Lê Văn C"),
				new Employee("Đặng Thị G", LocalDate.of(1999, 11, 30), 4d, "Kinh doanh", "Trần Thị B"),
				new Employee("Hoàng Văn H", LocalDate.of(1998, 1, 5), 4.2d, "Kinh doanh", "Trần Thị B"),
				new Employee("Phan Thị I", LocalDate.of(1997, 2, 14), 3.8d, "Kinh doanh", "Trần Thị B") };
		d1.displayInfo();
		for (Manager m : managers) {
			m.displayInfo();

		}
		for (Employee e : employees) {
			e.displayInfo();

		}
		System.out.println("==========Nhân viên quản lý bởi trưởng phòng==========");
		countEmployeesPerManager(managers, employees);
		System.out.println("==========Bảng Lương Nhân Viên==========");
		for (Employee e : employees) {
			e.displaySalary();

		}
		System.out.println("==========Bảng Lương Trưởng Phòng==========");
		for (Manager m : managers) {
			m.displaySalary();

		}
		System.out.println("==========Bảng Lương Giám Đốc==========");
		d1.displaySalary();

	}

	public static void countEmployeesPerManager(Manager[] managers, Employee[] employees) {

		for (Manager m : managers) {
			int count = 0;
			for (Employee e : employees) {
				if (e.getManagerName().equalsIgnoreCase(m.getUsername())) {
					count++;
				}
			}
			System.out.printf("Manager %-10s(%s Department) manages %d employees.\n", m.getUsername(),
					m.getDepartmentName(), count);
		}
	}

}
