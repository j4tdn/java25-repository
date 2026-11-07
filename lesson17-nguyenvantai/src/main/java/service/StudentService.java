package service;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import persistence.ClassSummary;
import persistence.Student;
import persistence.StudentAverage;

public class StudentService {
	private final StudentDAO dao = new StudentDAO();

	public List<Student> getStudentsByClassId(int cid) throws SQLException {
		return dao.findByClassId(cid);
	}

	public List<ClassSummary> getClassesWithGoodMathAndLiterature() throws SQLException {
		return dao.findClassesWithGoodMathAndLiterature();
	}

	public List<ClassSummary> getStudentCountPerClass() throws SQLException {
		return dao.countStudentsPerClass();
	}

	public List<StudentAverage> getStudentsWithAverageAtLeast(double min) throws SQLException {
		return dao.findByAverageAtLeast(min);
	}

	public List<StudentAverage> getTopStudentOfEachClass() throws SQLException {
		return dao.findTopAverageInEachClass();
	}
}