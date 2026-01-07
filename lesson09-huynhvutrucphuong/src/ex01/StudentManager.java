package ex01;

import com.sun.net.httpserver.Authenticator.Result;

public class StudentManager {
	//a.Danh sách sinh viên đạt loại A
	public static Student[] getStudents(Student[] students) {
		Student[] temp = new Student[students.length];
		int count = 0;
		for(int i=0; i<students.length;i++) {
			if(students[i].getGrade() == 'A') {
				boolean exists = false;
				for (int j = 0;j< count ;j++) {
					if(temp[j].getId() == students[i].getId()) {
						exists = true;
						break;
					}
				}
				if(!exists) {
					temp[count++] = students[i];
				}
			}
			
		}
		Student[] result = new Student[count];
		for(int i = 0;i<count;i++) {
			result[i] = temp[i];
		}
		return result;
	}
	//
}
