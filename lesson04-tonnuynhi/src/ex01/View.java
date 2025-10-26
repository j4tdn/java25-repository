package ex01;

import java.util.Scanner;

public class View {
    
    private static Student inputStudent(Scanner ip) {
        Student st = new Student();
        System.out.println("\n--- NHẬP THÔNG TIN SINH VIÊN THỨ 3 ---");
        System.out.print("Nhập ID của SV 3: ");
        st.setStudentId(ip.nextInt());
        ip.nextLine(); 

        System.out.print("Nhập tên của SV 3: ");
        st.setName(ip.nextLine()); 

        System.out.print("Nhập điểm LT của SV 3: ");
        st.setTheoreticalpoint(ip.nextFloat());

        System.out.print("Nhập điểm TH của SV 3: ");
        st.setPracticepoints(ip.nextFloat());
        
        return st;
    }
        
    private static void findavg(Student[] students) {
        boolean found = false;
        for(Student st : students) {
            if(st.avg()) { 
                System.out.println(st);  
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sinh viên nào có DTB > 8.5.");
        }
    }
    
    private static void findTheoreticalpointthanPracticepoints(Student[] students) {
        boolean found = false;
        for(Student st : students) {
            if(st.getTheoreticalpointthanPracticepoints()) {
                System.out.println(st); 
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sinh viên nào có điểm LT > điểm TH.");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner ip = new Scanner(System.in);
        
        Student st1 = new Student(1, "Jenny", 7f, 9f);
        Student st2 = new Student(2, "Black Pink", 8f, 5f);

        Student st3 = inputStudent(ip); 
        
        System.out.println("\n--- THÔNG TIN SINH VIÊN BAN ĐẦU ---");
        st1.output();
        st2.output();
        st3.output();
        
        Student[] student = new Student[3];
        student[0] = st1;
		student[1] = st2;
		student[2] = st3;
		
		System.out.println("\n--- KẾT QUẢ TÌM KIẾM THEO ĐIỀU KIỆN ---");
		System.out.println("Tên SV có DTB > 8.5 là:"); 
        findavg(student);
        
        System.out.println("\nTên SV có điểm LT > điểm TH là:");
        findTheoreticalpointthanPracticepoints(student);
        
        ip.close();
    }
}