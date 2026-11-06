package com.tiendat.dao;

import com.tiendat.common.Gender;
import com.tiendat.connection.DbConnection;
import com.tiendat.dto.ClassDto;
import com.tiendat.persistence.Student;
import com.tiendat.utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcClassDao implements ClassDao {
    final Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private final String Q_GET_GOOD_STUDENT = "" +
            "WITH CTE_GOOD_MATH AS (\n" +
            "\tSELECT sid\n" +
            "    FROM result \n" +
            "    WHERE subject = 'Math' and score >= 8\n" +
            "),\n" +
            "CTE_GOOD_LIT AS (\n" +
            "\tSELECT sid\n" +
            "\tFROM result \n" +
            "    WHERE subject = 'Literature' and score >= 8\n" +
            ")\n" +
            "\n" +
            "SELECT c.name as ClassName, COUNT(s.id) as quantity\n" +
            "FROM student s\n" +
            "JOIN class c\n" +
            "\tON s.cid = c.id\n" +
            "JOIN CTE_GOOD_MATH cgm\n" +
            "\tON cgm.sid = s.id\n" +
            "JOIN CTE_GOOD_LIT cgl\n" +
            "\tON cgl.sid = s.id\n" +
            "GROUP BY c.name, s.id;";

    private final String Q_COUNT_STUDENT_PER_CLASS = "" +
            "SELECT c.name as ClassName, count(s.id) as quantity\n" +
            "FROM student s\n" +
            "JOIN class c\n" +
            "ON s.cid = c.id\n" +
            "GROUP BY c.name;";

    public JdbcClassDao() {
        conn = DbConnection.getConnection();
    }


    @Override
    public List<ClassDto> getClassHasStudentGoodMathAndLiterature() {
        List<ClassDto> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_GOOD_STUDENT);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(new ClassDto(
                        rs.getString("ClassName"),
                        rs.getInt("quantity")
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
    public List<ClassDto> countStudentPerClass() {
        List<ClassDto> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_COUNT_STUDENT_PER_CLASS);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(new ClassDto(
                        rs.getString("ClassName"),
                        rs.getInt("quantity")
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
