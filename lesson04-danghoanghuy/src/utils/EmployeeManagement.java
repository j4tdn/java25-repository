package utils;

import bean.AllEmployee;
import bean.DepartmentHead;
import bean.Director;
import bean.Employee;

public class EmployeeManagement {
	public EmployeeManagement() {
	}
	
	public static void showInfor(AllEmployee[] aEs) {
		
		DepartmentHead dH = new DepartmentHead();
		Employee e = new Employee();
		
		for(AllEmployee aE: aEs) {
			if (aE instanceof Director) {
               System.out.println("\n" + aE + ", " + "Caclculate Salary =" + aE.calcSalary() + "\n");
               }
			else if (aE instanceof DepartmentHead) {
	            System.out.println("\n"+ aE + ", " + "Caclculate Salary =" + aE.calcSalary() + "\n");
	            
	            }
			else if(aE instanceof Employee){
				 System.out.println("\n" + aE + ", " + "Caclculate Salary =" + aE.calcSalary() + "\n");
			}
		}
	}
	public static void countEmployeesByHead(AllEmployee[] aEs) {

        for (AllEmployee aE : aEs) {
            if (aE instanceof DepartmentHead) {
            	DepartmentHead h = (DepartmentHead) aE;
                int count = 0;
                
                for (AllEmployee counter : aEs) {
                    if (counter instanceof Employee) {
                    	Employee e = (Employee) counter;
                    	
                        DepartmentHead manager = e.getDepartmentHead();
                        if (manager == h) {
                            count++;
                        }
                    }
                } 
                
                System.out.printf("\nDepartment Head name: %s management %s employees in room %s\n\n", h.getName(), count, h.getRoom());
            }
        }
	}
}
