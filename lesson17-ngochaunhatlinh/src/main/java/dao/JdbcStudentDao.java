package dao;

import connection.DbConnection;
import dto.ClassMaxAvgStudentDto;
import dto.ClassStudentCountDto;
import dto.GoodStudentByClassDto;
import dto.StudentAvgDto;
import persistence.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentDao implements StudentDao {

    private static final String Q_GET_STUDENTS_BY_CLASS_ID =
            "SELECT id, name, gender, cid FROM Student WHERE cid = ?";

    private static final String Q_GET_GOOD_MATH_AND_LIT_BY_CLASS =
            "SELECT c.name AS class_name, " +
            "       COUNT(s.id) AS student_count, " +
            "       GROUP_CONCAT(s.name SEPARATOR ', ') AS student_names " +
            "FROM Class c " +
            "JOIN Student s ON c.id = s.cid " +
            "JOIN Result r_math ON s.id = r_math.sid AND r_math.subject = 'Math' AND r_math.score >= 8 " +
            "JOIN Result r_lit  ON s.id = r_lit.sid  AND r_lit.subject = 'Literature' AND r_lit.score >= 8 " +
            "GROUP BY c.id, c.name " +
            "ORDER BY c.id";

    private static final String Q_COUNT_STUDENTS_PER_CLASS =
            "SELECT c.id, c.name AS class_name, c.teacher, COUNT(s.id) AS student_count " +
            "FROM Class c " +
            "LEFT JOIN Student s ON c.id = s.cid " +
            "GROUP BY c.id, c.name, c.teacher " +
            "ORDER BY c.id";

    private static final String Q_GET_STUDENTS_AVG_SCORE_GTE =
            "SELECT s.id, s.name, c.name AS class_name, AVG(r.score) AS avg_score " +
            "FROM Student s " +
            "JOIN Class c ON s.cid = c.id " +
            "JOIN Result r ON s.id = r.sid " +
            "GROUP BY s.id, s.name, c.name " +
            "HAVING AVG(r.score) >= ? " +
            "ORDER BY avg_score DESC";

    private static final String Q_GET_MAX_AVG_STUDENT_PER_CLASS =
            "WITH StudentAvg AS ( " +
            "    SELECT s.id AS student_id, " +
            "           s.name AS student_name, " +
            "           c.id AS class_id, " +
            "           c.name AS class_name, " +
            "           AVG(r.score) AS avg_score, " +
            "           RANK() OVER (PARTITION BY c.id ORDER BY AVG(r.score) DESC) AS rnk " +
            "    FROM Student s " +
            "    JOIN Class c ON s.cid = c.id " +
            "    JOIN Result r ON s.id = r.sid " +
            "    GROUP BY s.id, s.name, c.id, c.name " +
            ") " +
            "SELECT class_id, class_name, student_id, student_name, avg_score " +
            "FROM StudentAvg " +
            "WHERE rnk = 1 " +
            "ORDER BY class_id";

    private final Connection conn;

    public JdbcStudentDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        List<Student> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_STUDENTS_BY_CLASS_ID)) {
            pst.setInt(1, classId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    results.add(new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getBoolean("gender"),
                            rs.getInt("cid")
                    ));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public List<GoodStudentByClassDto> getGoodMathAndLiteratureStudentsByClass() {
        List<GoodStudentByClassDto> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_GOOD_MATH_AND_LIT_BY_CLASS);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                results.add(new GoodStudentByClassDto(
                        rs.getString("class_name"),
                        rs.getInt("student_count"),
                        rs.getString("student_names")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public List<ClassStudentCountDto> countStudentsPerClass() {
        List<ClassStudentCountDto> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_COUNT_STUDENTS_PER_CLASS);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                results.add(new ClassStudentCountDto(
                        rs.getInt("id"),
                        rs.getString("class_name"),
                        rs.getString("teacher"),
                        rs.getInt("student_count")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public List<StudentAvgDto> getStudentsWithAvgScoreGte(double minAvgScore) {
        List<StudentAvgDto> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_STUDENTS_AVG_SCORE_GTE)) {
            pst.setDouble(1, minAvgScore);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    results.add(new StudentAvgDto(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("class_name"),
                            rs.getDouble("avg_score")
                    ));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public List<ClassMaxAvgStudentDto> getMaxAvgScoreStudentsPerClass() {
        List<ClassMaxAvgStudentDto> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_MAX_AVG_STUDENT_PER_CLASS);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                results.add(new ClassMaxAvgStudentDto(
                        rs.getInt("class_id"),
                        rs.getString("class_name"),
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getDouble("avg_score")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }
}
