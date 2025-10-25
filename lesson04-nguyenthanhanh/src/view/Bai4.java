package view;

import bean.DepartmentHead;
import bean.Director;
import bean.Employee;
import bean.Staff;

public class Bai4 {

	public static void main(String[] args) {
		Employee[] employees = createMockData();
		System.out.println("=== Thông tin các nhân sự có trong công ty ===\n");
		displayEmployees(employees);
		System.out.println("\n=== Thống kê số lượng nhân viên được quản lý bởi từng trưởng phòng ===\n");
		displayEmployeeStats(employees);
	}
	
	private static Employee[] createMockData() {
		Director d = new Director("Nguyen Van A", "2002-07-18", 5.5, 4.5);
        
        DepartmentHead deptHead1 = new DepartmentHead("Tran Thi Bich", "1982-06-10", 1.8, 3.2, "Phòng Kinh Doanh");
        DepartmentHead deptHead2 = new DepartmentHead("Le Quoc Hung", "1980-09-25", 1.9, 3.0, "Phòng Kỹ Thuật");
        
        Staff staff1 = new Staff("Pham Thi Hoa", "1990-03-12", 2.2, "Phòng Kinh Doanh", deptHead1);
        Staff staff2 = new Staff("Nguyen Van B", "1992-11-22", 2.0, "Phòng Kinh Doanh", deptHead1);
        Staff staff3 = new Staff("Do Minh Chau", "1994-01-18", 1.8, "Phòng Kinh Doanh", deptHead1);

        Staff staff4 = new Staff("Tran Van Nam", "1993-05-30", 2.1, "Phòng Kỹ Thuật", deptHead2);
        Staff staff5 = new Staff("Vo Thi Lan", "1995-07-09", 1.9, "Phòng Kỹ Thuật", deptHead2);
        Staff staff6 = new Staff("Hoang Duc Tai", "1996-12-01", 1.7, "Phòng Kỹ Thuật", deptHead2);
        
        Employee[] employees = {
                d,
                deptHead1, deptHead2,
                staff1, staff2, staff3,
                staff4, staff5, staff6
            };
        return employees; 
	}
	
	private static void displayEmployees(Employee[] employees) {
		for(Employee employee: employees) {
			System.out.println(employee + "| Salary: "+ employee.getSalary());
		}
	}
	
	private static void displayEmployeeStats(Employee[] employees) {
		DepartmentHead[] departmentHeads = new DepartmentHead[2];
	    int[] count = new int[2];
	    
	    int index = 0;
	    for (Employee e : employees) {
	        if (e instanceof DepartmentHead) {
	        	departmentHeads[index++] = (DepartmentHead) e;
	        }
	    }
	    
	    for (Employee e : employees) {
	        if (e instanceof Staff) {
	            Staff s = (Staff) e;
	            DepartmentHead head = s.getDepartmentHead();
	            for (int i = 0; i < departmentHeads.length; i++) {
	                if (departmentHeads[i] == head) { 
	                    count[i]++;
	                    break;
	                }
	            }
	        }
	    }
	   
	    for (int i = 0; i < departmentHeads.length; i++) {
	        System.out.println("- " + departmentHeads[i].getFullName() 
	        		+ " (" + departmentHeads[i].getDepartment() + "): "
	                + count[i] + " employees");
	    }
	}
	
}
