package ex04;

import java.util.ArrayList;

public class ManageWorker {
    public static void main(String[] args) {
        ArrayList<Worker> ds = new ArrayList<>();

        // 1 Giám đốc
        Director d = new Director("GD Quân", "01/01/2006", 15.0, 2.0);
        ds.add(d);

        // 2 Trưởng phòng
        DepartmentHead dh1 = new DepartmentHead("TP Quân1", "02/01/2006", 8.0, 1.0, "Phòng Kế Toán");
        DepartmentHead dh2 = new DepartmentHead("TP Quân2", "03/01/2006", 9.0, 1.0, "Phòng Nhân Sự");
        ds.add(dh1);
        ds.add(dh2);

        // 6 Nhân viên
        ds.add(new Employee("Nv Quân1", "04/01/2006", 5.8, 0.0, "Phòng Kế Toán", "TP Quân1"));
        ds.add(new Employee("Nv Quân2", "05/01/2006", 4.6, 0.0, "Phòng Kế Toán", "TP Quân1"));
        ds.add(new Employee("Nv Quân3", "06/01/2006", 7.2, 0.0, "Phòng Kế Toán", "TP Quân1"));
        ds.add(new Employee("Nv Quân4", "07/01/2006", 6.3, 0.0, "Phòng Nhân Sự", "TP Quân2"));
        ds.add(new Employee("Nv Quân5", "08/01/2006", 5.5, 0.0, "Phòng Nhân Sự", "TP Quân2"));
        ds.add(new Employee("Nv Quân6", "09/01/2006", 5.0, 0.0, "Phòng Nhân Sự", "TP Quân2"));

        System.out.println("\n=== DANH SÁCH NHÂN SỰ CÔNG TY A ===");
        for (Worker ns : ds) {
            System.out.println(ns);
            System.out.println("-----------------------------------");
        }

        // === 2. Thống kê nhân viên dưới quyền từng trưởng phòng ===
        System.out.println("\n=== THỐNG KÊ NHÂN VIÊN THEO TRƯỞNG PHÒNG ===");
        String[] truongPhongNames = {"TP Quân1", "TP Quân1"};
        for (String tenTP : truongPhongNames) {
            int count = 0;
            for (Worker ns : ds) {
                if (ns instanceof Employee) {
                	Employee nv = (Employee) ns;
                    if (nv.getTruongPhong().equals(tenTP)) {
                        count++;
                    }
                }
            }
            System.out.println("Trưởng phòng " + tenTP + " quản lý " + count + " nhân viên.");
        }
    }
}
