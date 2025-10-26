package Ex04;

public class Main {
    public static void main(String[] args) {

        Director director = new Director("Ngo Chau Nhat Linh", "07/10/2005", 4.5, 2.0);

        Manager manager1 = new Manager("Nguyen Van Linh", "15/03/1980", 4.0, 1.8, "Sales Department");
        Manager manager2 = new Manager("Pham Van Linh", "22/07/1982", 4.0, 1.8, "IT Department");

        Employee emp1 = new Employee("Pham Van C", "10/10/1990", 2.5, "Sales Department", manager1);
        Employee emp2 = new Employee("Pham Van D", "12/12/1991", 2.8, "Sales Department", manager1);
        Employee emp3 = new Employee("Pham Van E", "05/05/1992", 3.0, "Sales Department", manager1);
        Employee emp4 = new Employee("Pham Van F", "08/08/1993", 2.6, "IT Department", manager2);
        Employee emp5 = new Employee("Pham Van G", "09/09/1994", 2.9, "IT Department", manager2);
        Employee emp6 = new Employee("Pham Van H", "11/11/1995", 3.1, "IT Department", manager2);

        Company[] company = { director, manager1, manager2, emp1, emp2, emp3, emp4, emp5, emp6 };

        for (Company c : company) {
            System.out.println(c);
        }

        System.out.println("\n=== Number of employees managed by each manager ===");
        for (Company c : company) {
            if (c instanceof Manager m) {
                int count = 0;
                for (Company x : company) {
                    if (x instanceof Employee e && e.getManager() == m) {
                        count++;
                    }
                }
                System.out.println("Manager " + m.getFullName() + " manages " + count + " employees.");
            }
        }

        System.out.println("\n=== Salary of each employee ===");
        for (Company c : company) {
            System.out.printf("%s Salary: %.0f\n", c.getFullName(), c.calculateSalary());
        }
    }
}
