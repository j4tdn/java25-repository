package Ex01;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Student st1 = new Student(1, "Trần Văn Thanh", 8, 9);
        Scanner ip = new Scanner(System.in);
        Student st2 = new Student(2, "Lê Thị Thơm", 10, 10);

        Student st3 = new Student();

        System.out.println("Nhập ID của sinh viên 3:");
        st3.setStudentId(ip.nextInt());
        ip.nextLine(); 

        System.out.println("Nhập tên của sinh viên 3:");
        st3.setName(ip.nextLine()); 

        System.out.println("Nhập điểm LT của sinh viên 3:");
        st3.setTheoreticalpoint(ip.nextFloat());

        System.out.println("Nhập điểm TH của sinh viên 3:");
        st3.setPracticepoints(ip.nextFloat());

        st1.output();
        st2.output();
        st3.output();
    }
}