package homework4;

import java.util.ArrayList;
import java.util.List;

public class Company {
    public static void main(String[] args) {

        List<Person> staffList = new ArrayList<>();

        Director director = new Director("Nguyen Van A", "01/01/2020", 4.5, 2.0);
        Manager m1 = new Manager("Nguyen Van B", "01/02/2020", 3.8, 1.5, "Phong Kinh Doanh");
        Manager m2 = new Manager("Nguyen Van C", "01/03/2020", 3.5, 1.2, "Phòng Ky Thuat");

        staffList.add(director);
        staffList.add(m1);
        staffList.add(m2);

        staffList.add(new Employee("Nguyen Thi D", "01/04/2020", 2.2, 0, "Kinh Doanh", m1));
        staffList.add(new Employee("Nguyen Thi E", "01/05/2020", 2.0, 0, "Kinh Doanh", m1));
        staffList.add(new Employee("Nguyen Thi F", "01/06/2020", 2.1, 0, "Kinh Doanh", m1));
        staffList.add(new Employee("Nguyen Thi G", "01/07/2020", 2.4, 0, "Ky Thuat", m2));
        staffList.add(new Employee("Nguyen Thi H", "01/08/2020", 2.3, 0, "Ky Thuat", m2));
        staffList.add(new Employee("Nguyen Thi I", "01/09/2020", 2.25, 0, "Ky Thuat", m2));

        
        System.out.println("===== DANH SACH NHAN SU =====");
        staffList.forEach(System.out::println);
    }
}
