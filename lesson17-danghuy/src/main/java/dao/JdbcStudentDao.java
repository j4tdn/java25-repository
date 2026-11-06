package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import persistence.Student;

public class JdbcStudentDao implements StudentDAO{

	private static final String Q_FIND_BY_CLASS_ID = ""
			+ "SELECT *\n"
			+ "FROM Student\n"
			+ "WHERE cid = ?";
	
	private static final String Q_FIND_GOOD_STUDENT = ""
			+ "SELECT c.name AS class_name,\n"
			+ "		  COUNT(s.id) AS total,\n"
			+ "		  s.name AS student_name\n"
			+ "FROM Student s\n"
			+ "JOIN Class c ON s.id = c.id\n"
			+ "JOIN Result m ON s.id = m.sid\n"
			+ "		AND m.subject = 'Math'\n"
			+ "JOIN Result l ON s.id = l.sid\n"
			+ "		AND l.subject = 'Literature'\n"
			+ "WHERE m.score >= 8\n"
			+ "		AND l.score >= 8\n"
			+ "GROUP BY c.id, c.name\n"
			+ "ORDER BY c.id";
	
	private static Connection conn;
	
	public JdbcStudentDao() {
	
		conn = DbConnection.getConnection();
	}
	
	@Override
	public List<Student> findByClassId(int classId) {
		
		List<Student> students = new ArrayList<>();
		
		try(PreparedStatement statement = conn.prepareStatement(Q_FIND_BY_CLASS_ID)) {
			
			statement.setInt(1, classId);
			
			
		try(ResultSet resultSet = statement.executeQuery()){
			while(resultSet.next()) {
				students.add(map(resultSet));
			}
		}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	@Override
	public void findGoodStudent() {
	List<Student> students = new ArrayList<>();
		
		try(PreparedStatement statement = conn.prepareStatement(Q_FIND_GOOD_STUDENT)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			boolean found = false;
			
			while(resultSet.next()) {
				found = true;
				
				System.out.println(
						"Class: " + resultSet.getString("class_name") + "\n"
						+ "Score: " + resultSet.getInt("total") + "\n"
						+ "Students: " + resultSet.getString("students") + "\n"
						);
			}
			
			if(!found) {
				System.out.println("No matching student");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private Student map(ResultSet resultSet) throws SQLException {
		
		return new Student(
				resultSet.getInt("id"),
				resultSet.getString("name"),
				resultSet.getBoolean("gender"),
				resultSet.getInt("cid")
				);
	}
	
}
