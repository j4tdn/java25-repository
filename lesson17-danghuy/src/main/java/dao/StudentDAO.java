package dao;

import java.util.List;

import persistence.Student;

public interface StudentDAO {

	List<Student> findByClassId(int classId);
	
	void findGoodStudent();
	
}
