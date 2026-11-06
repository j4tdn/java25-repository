package com.tiendat.dao;

import com.tiendat.common.Gender;
import com.tiendat.connection.DbConnection;
import com.tiendat.dto.StudentDto;
import com.tiendat.dto.StudentMaxAvgDto;
import com.tiendat.persistence.Student;
import com.tiendat.utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentDao implements StudentDao {
    final Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private final String Q_GET_STUDENT_BY_CLASS_ID = "" +
            "SELECT *\n" +
            "FROM student\n" +
            "WHERE cid = ?";

    private final String Q_GET_AVG_SCORE = "" +
            "SELECT s.id as id ,s.name as name, s.gender as gender, AVG(score) as avg_score\n" +
            "FROM student s\n" +
            "JOIN result r\n" +
            "ON s.id = r.sid\n" +
            "GROUP BY s.id, s.name, s.gender\n" +
            "HAVING avg_score >= 8.2;";

    private final String Q_GET_STUDENT_HAS_MAX_AVG = "" +
            "WITH STUDENT_AVG AS (\n" +
            "\tSELECT s.id as student_id ,s.name as student_name, s.cid as class_id, AVG(score) as avg_score\n" +
            "FROM student s\n" +
            "JOIN result r\n" +
            "ON s.id = r.sid\n" +
            "GROUP BY s.id, s.name, s.cid\n" +
            "HAVING avg_score >= 8.2\n" +
            "),\n" +
            "MAX_AVG_PER_CLASS AS (\n" +
            "\tSELECT class_id,\n" +
            "    MAX(avg_score) as max_avg\n" +
            "    FROM STUDENT_AVG \n" +
            "    GROUP BY class_id\n" +
            ")\n" +
            "\n" +
            "SELECT c.id as class_id,\n" +
            "\tc.name as class_name,\n" +
            "    sa.student_id as student_id,\n" +
            "    sa.student_name as student_name,\n" +
            "    sa.avg_score as avg_score\n" +
            "FROM STUDENT_AVG sa\n" +
            "JOIN MAX_AVG_PER_CLASS m\n" +
            "ON sa.class_id = m.class_id\n" +
            "JOIN class c ON sa.class_id = c.id;";

    public JdbcStudentDao() {
        conn = DbConnection.getConnection();
    }


    @Override
    public List<Student> findStudentByClassId(Long classId) {
        List<Student> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_STUDENT_BY_CLASS_ID);
            pst.setLong(1, classId);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        Gender.get(rs.getInt("gender")),
                        rs.getLong("cid")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }

    @Override
    public List<StudentDto> findStudentHasAvgScore() {
        List<StudentDto> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_AVG_SCORE);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(new StudentDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        Gender.get(rs.getInt("gender")),
                        rs.getDouble("avg_score")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }

    @Override
    public List<StudentMaxAvgDto> findStudentMaxAvgPerClass() {
        List<StudentMaxAvgDto> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_STUDENT_HAS_MAX_AVG);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(new StudentMaxAvgDto(
                        rs.getLong("class_id"),
                        rs.getString("class_name"),
                        rs.getLong("student_id"),
                        rs.getString("student_name"),
                        rs.getDouble("avg_score")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }
}
