package service;

import java.util.List;

import dao.JdbcStudentDao;
import dao.StudentDAO;
import persistence.Student;

public class StudentServiceImpl implements StudentService{

	private static StudentDAO studentDao;
	
	public StudentServiceImpl() {
		studentDao = new JdbcStudentDao();
	}
	
	@Override
	public List<Student> findByClassId(int classId) {
		
		if(classId <= 0) {
			System.out.println("Class > 0");
		}
		
		return studentDao.findByClassId(classId);
	}
	
	@Override
	public void findGoodStudent() {
		
		studentDao.findGoodStudent();
	}
	
}
