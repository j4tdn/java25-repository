package lesson17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("== 1. List all students by class id ==");
            for (int classId = 1; classId <= 3; classId++) {
                listStudentsByClassId(conn, classId);
            }

            System.out.println("\n== 2. Classes with students having Math >= 8 and Literature >= 8 ==");
            goodAtMathAndLiterature(conn);

            System.out.println("\n== 3. Number of students per class ==");
            countStudentsPerClass(conn);

            System.out.println("\n== 4. Students with average score >= 8.2 ==");
            studentsWithAverageAtLeast(conn, 8.2);

            System.out.println("\n== 5. Students with the highest average in their class ==");
            topAverageStudentPerClass(conn);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 1. List all students by class id
    static void listStudentsByClassId(Connection conn, int classId) throws SQLException {
        String sql = "SELECT id, name, gender FROM Student WHERE cid = ? ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, classId);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Class id " + classId + ":");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf("  %-3d %-8s %s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getBoolean("gender") ? "Male" : "Female");
                }
                if (!found) {
                    System.out.println("  (no students)");
                }
            }
        }
    }

    // 2. Class name, number of students and their names (Math >= 8 AND Literature >= 8)
    static void goodAtMathAndLiterature(Connection conn) throws SQLException {
        String sql =
                "SELECT c.name AS class_name, "
              + "       COUNT(*) AS total, "
              + "       GROUP_CONCAT(s.name ORDER BY s.id SEPARATOR ', ') AS student_names "
              + "FROM Class c "
              + "JOIN Student s ON s.cid = c.id "
              + "JOIN Result m ON m.sid = s.id AND m.subject = 'Math' AND m.score >= 8 "
              + "JOIN Result l ON l.sid = s.id AND l.subject = 'Literature' AND l.score >= 8 "
              + "GROUP BY c.id, c.name "
              + "ORDER BY c.name";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.printf("%-6s %-6s %s%n", "Class", "Count", "Students");
            while (rs.next()) {
                System.out.printf("%-6s %-6d %s%n",
                        rs.getString("class_name"),
                        rs.getInt("total"),
                        rs.getString("student_names"));
            }
        }
    }

    // 3. Count / statistic number of students per class
    static void countStudentsPerClass(Connection conn) throws SQLException {
        String sql =
                "SELECT c.name AS class_name, c.teacher, COUNT(s.id) AS total "
              + "FROM Class c "
              + "LEFT JOIN Student s ON s.cid = c.id "
              + "GROUP BY c.id, c.name, c.teacher "
              + "ORDER BY c.name";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.printf("%-6s %-8s %s%n", "Class", "Teacher", "Students");
            while (rs.next()) {
                System.out.printf("%-6s %-8s %d%n",
                        rs.getString("class_name"),
                        rs.getString("teacher"),
                        rs.getInt("total"));
            }
        }
    }

    // 4. Students whose average score >= threshold
    static void studentsWithAverageAtLeast(Connection conn, double threshold) throws SQLException {
        String sql =
                "SELECT s.id, s.name, c.name AS class_name, AVG(r.score) AS avg_score "
              + "FROM Student s "
              + "JOIN Class c ON c.id = s.cid "
              + "JOIN Result r ON r.sid = s.id "
              + "GROUP BY s.id, s.name, c.name "
              + "HAVING AVG(r.score) >= ? "
              + "ORDER BY avg_score DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, threshold);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.printf("%-3s %-8s %-6s %s%n", "Id", "Name", "Class", "Average");
                while (rs.next()) {
                    System.out.printf("%-3d %-8s %-6s %.2f%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("class_name"),
                            rs.getDouble("avg_score"));
                }
            }
        }
    }

    // 5. Students who have the max average score in their class (ties all shown)
    static void topAverageStudentPerClass(Connection conn) throws SQLException {
        String sql =
                "WITH avgs AS ( "
              + "    SELECT s.id, s.name, s.cid, AVG(r.score) AS avg_score "
              + "    FROM Student s "
              + "    JOIN Result r ON r.sid = s.id "
              + "    GROUP BY s.id, s.name, s.cid "
              + ") "
              + "SELECT c.name AS class_name, a.id, a.name, a.avg_score "
              + "FROM avgs a "
              + "JOIN Class c ON c.id = a.cid "
              + "WHERE a.avg_score = (SELECT MAX(a2.avg_score) FROM avgs a2 WHERE a2.cid = a.cid) "
              + "ORDER BY c.name, a.id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.printf("%-6s %-3s %-8s %s%n", "Class", "Id", "Name", "Average");
            while (rs.next()) {
                System.out.printf("%-6s %-3d %-8s %.2f%n",
                        rs.getString("class_name"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("avg_score"));
            }
        }
    }
}
