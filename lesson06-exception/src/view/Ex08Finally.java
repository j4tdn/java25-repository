package view;

import bean.Employee;

public class Ex08Finally {
	public static void main(String[] args) {
		
	}
	
	private static Employee[] mockData(int numberOfEmloyee) {
		Employee[] employees = new Employee(numberOfEmloyee);
		for(int i = 0;i < numberOfEmloyee;i++) {
			Employee emp = new Employee(i++, "Nhaan vieen",(i+1), rd.nextInt(18,20));
			employees[i] = emp;
			
		}
		return employees;
	}
}
