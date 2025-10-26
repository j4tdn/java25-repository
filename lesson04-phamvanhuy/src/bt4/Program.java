package bt4;

public class Program {
	public static void main(String[] args) {
		Director director = new Director("Phạm Văn Huy", "12/09/2005", 5.0, 2.0);

		Manager[] managers = { new Manager("Nguyễn Minh Duy", "17/10/2005", 4.0, 1.5, "Phòng Kinh Doanh"),
				new Manager("Ngô Châu Nhật Linh", "06/10/2005", 3.8, 1.2, "Phòng Kỹ Thuật"), };

		Employee[] employees = { new Employee("A", "10/10/2005", 2.5, "Phòng Kinh Doanh", managers[0]),
				new Employee("B", "11/10/2005", 2.2, "Phòng Kinh Doanh", managers[0]),
				new Employee("C", "12/10/2005", 2.3, "Phòng Kinh Doanh", managers[0]),
				new Employee("D", "13/10/2005", 2.0, "Phòng Kỹ Thuật", managers[1]),
				new Employee("E", "14/10/2005", 2.4, "Phòng Kỹ Thuật", managers[1]),
				new Employee("F", "15/10/2005", 2.1, "Phòng Kỹ Thuật", managers[1]) };
		System.out.println("=== DANH SÁCH NHÂN SỰ ===");
		director.showInfo();
		for (Manager m : managers) {
			m.showInfo();
		}
		for (Employee e : employees) {
			e.showInfo();
		}

		System.out.println("\n=== Thống kê nhân viên theo trưởng phòng ===");
		for (Manager m : managers) {
			int count = 0;
			for (Employee e : employees) {
				if (e.getManager() == m)
					count++;
			}
			System.out.println(m.getFullName() + " quản lí " + count + " nhân viên");
		}

		System.out.println("\n=== BẢNG LƯƠNG ===");
		System.out.println(director);
		for (Manager m : managers) {
			System.out.println(m);
		}
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
}
