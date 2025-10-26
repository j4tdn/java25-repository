package lesson04;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Company {
	public static void main(String[] args) {
		Director gd = new Director("NGUYEN VAN A", LocalDate.of(1985, 5, 30), 5, 10);
		
		Manager m1 = new Manager("NGUYEN VAN B", LocalDate.of(1995, 3, 21), 4, 7, "KINH DOANH");
		Manager m2 = new Manager("NGUYEN VAN C", LocalDate.of(1996, 9, 14), 4, 7, "KE TOAN");
		
		Staff s1 = new Staff("NGUYEN VAN D", LocalDate.of(1998, 7, 14), 2, 2, "KINH DOANH", m1);
		Staff s2 = new Staff("NGUYEN VAN D", LocalDate.of(2000, 2, 17), 2, 2, "KE TOAN", m2);
		Staff s3 = new Staff("NGUYEN VAN D", LocalDate.of(1998, 10, 5), 2, 2, "KINH DOANH", m1);
		Staff s4 = new Staff("NGUYEN VAN D", LocalDate.of(2002, 4, 15), 2, 2, "KINH DOANH", m1);
		Staff s5 = new Staff("NGUYEN VAN D", LocalDate.of(2004, 9, 20), 2, 2, "KE TOAN", m2);
		Staff s6 = new Staff("NGUYEN VAN D", LocalDate.of(1999, 12, 13), 2, 2, "KE TOAN", m2);
		
		m1.Add(s1);
		m1.Add(s3);
		m1.Add(s4);
		m2.Add(s2);
		m2.Add(s5);
		m2.Add(s6);
		
		List<People> list = Arrays.asList(gd, m1, m2, s1, s2, s3, s4, s5, s6);
		System.out.println("===DANH SÁCH NHÂN SỰ TRONG CÔNG TY===\n");
		for (People ns : list) {
			ns.showInfo();
			
		}
		
		
		System.out.println("\n--------------------------------------------------\n");
		
		for (People ns : list) {
			if (ns instanceof Manager) {
				Manager m = (Manager)ns;
				System.out.println(m.getName() + " quan ly " + m.isStaff() + " NHAN VIEN");
			}
		}
		System.out.println("\n--------------------------------------------------\n");
		
		System.out.println("\n===== DANH SÁCH LƯƠNG CÁC NHÂN SỰ =====");
		for (People ns : list) {
			System.out.printf("%-15s => Lương: %.0f VND\n", ns.getName(), ns.calcSalary());
		}
		

	}

	

}
