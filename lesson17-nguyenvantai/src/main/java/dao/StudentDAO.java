package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import persistence.ClassSummary;
import persistence.Student;
import persistence.StudentAverage;

public class StudentDAO {

	// 1. Liệt kê học sinh theo class id
	public List<Student> findByClassId(int cid) throws SQLException {
		String sql = "SELECT id, name, gender, cid FROM Student WHERE cid = ?";
		List<Student> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, cid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"),
							rs.getInt("cid")));
				}
			}
		}
		return list;
	}

	// 2. Tên lớp, số học sinh, tên các học sinh có Math >= 8 và Literature >= 8
	public List<ClassSummary> findClassesWithGoodMathAndLiterature() throws SQLException {
		String sql = "SELECT c.name AS class_name, COUNT(*) AS total, "
				+ "GROUP_CONCAT(s.name SEPARATOR ', ') AS students " + "FROM Student s "
				+ "JOIN Class c ON s.cid = c.id "
				+ "JOIN Result m ON m.sid = s.id AND m.subject = 'Math' AND m.score >= 8 "
				+ "JOIN Result l ON l.sid = s.id AND l.subject = 'Literature' AND l.score >= 8 "
				+ "GROUP BY c.id, c.name";
		List<ClassSummary> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(new ClassSummary(rs.getString("class_name"), rs.getInt("total"), rs.getString("students")));
			}
		}
		return list;
	}

	// 3. Thống kê số học sinh mỗi lớp
	public List<ClassSummary> countStudentsPerClass() throws SQLException {
		String sql = "SELECT c.name AS class_name, COUNT(s.id) AS total "
				+ "FROM Class c LEFT JOIN Student s ON s.cid = c.id " + "GROUP BY c.id, c.name";
		List<ClassSummary> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(new ClassSummary(rs.getString("class_name"), rs.getInt("total"), null));
			}
		}
		return list;
	}

	// 4. Học sinh có điểm trung bình >= min
	public List<StudentAverage> findByAverageAtLeast(double min) throws SQLException {
		String sql = "SELECT s.id, s.name, c.name AS class_name, AVG(r.score) AS avg_score " + "FROM Student s "
				+ "JOIN Class c ON s.cid = c.id " + "JOIN Result r ON r.sid = s.id " + "GROUP BY s.id, s.name, c.name "
				+ "HAVING AVG(r.score) >= ?";
		List<StudentAverage> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, min);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new StudentAverage(rs.getInt("id"), rs.getString("name"), rs.getString("class_name"),
							rs.getDouble("avg_score")));
				}
			}
		}
		return list;
	}

	public List<StudentAverage> findTopAverageInEachClass() throws SQLException {
		String sql = "WITH avg_table AS (" + "  SELECT s.id, s.name, s.cid, AVG(r.score) AS avg_score "
				+ "  FROM Student s JOIN Result r ON r.sid = s.id " + "  GROUP BY s.id, s.name, s.cid) "
				+ "SELECT a.id, a.name, c.name AS class_name, a.avg_score "
				+ "FROM avg_table a JOIN Class c ON c.id = a.cid "
				+ "WHERE a.avg_score = (SELECT MAX(b.avg_score) FROM avg_table b WHERE b.cid = a.cid) "
				+ "ORDER BY c.name";
		List<StudentAverage> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(new StudentAverage(rs.getInt("id"), rs.getString("name"), rs.getString("class_name"),
						rs.getDouble("avg_score")));
			}
		}
		return list;
	}
}