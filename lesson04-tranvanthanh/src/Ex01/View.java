package Ex01;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Student st1 = new Student(1, "Trần Văn Thanh", 8, 9);
       
        Student st2 = new Student(2, "Lê Thị Thơm", 10, 10);

        Student st3 = inputStudent(); 
        
        st1.output();
        st2.output();
        st3.output();
        
        Student[] student = new Student[3];
        student[0] = st1;
		student[1] = st2;
		student[2] = st3;
		
		System.out.print("Tên học sinh có DTB >8.5 là: ");
        findavg(student);
        
        System.out.print("\n Tên học sinh có điểm lý thuyết lớn hơn điểm thực hành là: ");
        findTheoreticalpointthanPracticepoints(student);
    }
        private static Student inputStudent() {
      
        Student st = new Student();
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhập ID của sinh viên 3:");
        st.setStudentId(ip.nextInt());
        ip.nextLine(); 

        System.out.println("Nhập tên của sinh viên 3:");
        st.setName(ip.nextLine()); 

        System.out.println("Nhập điểm LT của sinh viên 3:");
        st.setTheoreticalpoint(ip.nextFloat());

        System.out.println("Nhập điểm TH của sinh viên 3:");
        st.setPracticepoints(ip.nextFloat());
        
        return st;
    }
        
        private static void findavg(Student[] students) {
    		for(int i = 0;i<students.length;++i) {
    			if(students[i].avg()) 
    				System.out.println(students[i]);  			
    		}
    	}
        
        private static void findTheoreticalpointthanPracticepoints(Student[] students) {
        	for(int i = 0;i<students.length;++i) {
    			if(students[i].getTheoreticalpointthanPracticepoints())
    				System.out.println(students[i]); 
        	}
        }
}