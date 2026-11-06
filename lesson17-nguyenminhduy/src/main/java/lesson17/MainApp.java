package lesson17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
    private static final String URL = "jdbc:mysql://localhost:3306/lesson17_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void listStudentsByClassId(int classId) {
        String sql = "SELECT id, name, CAST(gender AS UNSIGNED) AS gender, cid FROM Student WHERE cid = ?";
        System.out.println("\n1. Danh sách học sinh thuộc lớp có ID = " + classId + ":");
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, classId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("ID: %d | Tên: %s | Giới tính: %d | Mã lớp: %d%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("gender"),
                            rs.getInt("cid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listGoodMathAndLitStudents() {
        String sql = "SELECT c.name AS class_name, " +
                     "COUNT(s.id) AS student_count, " +
                     "GROUP_CONCAT(s.name SEPARATOR ', ') AS student_names " +
                     "FROM Class c " +
                     "JOIN Student s ON c.id = s.cid " +
                     "JOIN ( " +
                     "    SELECT sid FROM Result " +
                     "    WHERE (subject = 'Math' AND score >= 8) " +
                     "       OR (subject = 'Literature' AND score >= 8) " +
                     "    GROUP BY sid HAVING COUNT(DISTINCT subject) = 2 " +
                     ") g ON s.id = g.sid " +
                     "GROUP BY c.id, c.name";
        System.out.println("\n2. Học sinh giỏi cả Toán (>=8) và Văn (>=8) theo từng lớp:");
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Lớp: %s | Số lượng: %d | Tên học sinh: %s%n",
                        rs.getString("class_name"),
                        rs.getInt("student_count"),
                        rs.getString("student_names"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void countStudentsPerClass() {
        String sql = "SELECT c.id, c.name AS class_name, COUNT(s.id) AS total_students " +
                     "FROM Class c " +
                     "LEFT JOIN Student s ON c.id = s.cid " +
                     "GROUP BY c.id, c.name";
        System.out.println("\n3. Thống kê sĩ số học sinh mỗi lớp:");
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Mã lớp: %d | Tên lớp: %s | Số học sinh: %d%n",
                        rs.getInt("id"),
                        rs.getString("class_name"),
                        rs.getInt("total_students"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findStudentsWithAvgAtLeast8_2() {
        String sql = "SELECT s.id, s.name, AVG(r.score) AS avg_score " +
                     "FROM Student s " +
                     "JOIN Result r ON s.id = r.sid " +
                     "GROUP BY s.id, s.name " +
                     "HAVING AVG(r.score) >= 8.2";
        System.out.println("\n4. Danh sách học sinh có điểm trung bình >= 8.2:");
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %s | Điểm TB: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("avg_score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        listStudentsByClassId(2);
        listGoodMathAndLitStudents();
        countStudentsPerClass();
        findStudentsWithAvgAtLeast8_2();
    }
}