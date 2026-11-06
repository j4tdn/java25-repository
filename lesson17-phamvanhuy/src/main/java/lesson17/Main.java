package lesson17;

import java.sql.*;


public class Main {

    static String url = "jdbc:mysql://localhost:3306/lesson17_db";
    static String user = "root";
    static String pass = "Huyphamcs@05"; 

    
    public static void main(String[] args) {
		try (Connection conn  = DriverManager.getConnection(url,user,pass)) {
			System.out.println("ket noi thanh cong");
			
			//CAU1:
			String sql1 = """
					SELECT * FROM Student WHERE cid = ?""";
			try(PreparedStatement ps = conn.prepareStatement(sql1)){
				ps.setInt(1, 2);
				try(ResultSet rs = ps.executeQuery()){
					System.out.println("\n=== CAU1 ===");
					while (rs.next()) {
						System.out.println(
							rs.getInt("id") + " - " +
							rs.getString("name")
						);
					}
				}
			}
			
			//CAU2:
			 String sql2 = """
		                SELECT c.name AS lop,
		                       COUNT(s.id) AS soluong,
		                       GROUP_CONCAT(s.name) AS hocsinh
		                FROM Class c
		                JOIN Student s ON s.cid = c.id
		                JOIN Result m ON m.sid = s.id
		                    AND m.subject = 'Math'
		                    AND m.score >= 8
		                JOIN Result l ON l.sid = s.id
		                    AND l.subject = 'Literature'
		                    AND l.score >= 8
		                GROUP BY c.id, c.name
		                """;
			 try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql2)) {
				 System.out.println("\n=== CAU2 ===");
					while (rs.next()) {
						System.out.println(
							rs.getString("lop") + " - " +
							rs.getInt("soluong") + " - " +
							rs.getString("hocsinh")
							);
					}
			 }
			 
			 //CAU3:
			 String sql3 = """
			 		SELECT c.name AS lop, COUNT(s.id) AS soluong
			 		FROM Class c
			 		LEFT JOIN Student s ON s.cid = c.id
			 		GROUP BY c.id, c.name
			 		""";
			 try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql3)) {
				 System.out.println("\n=== CAU3 ===");
					while (rs.next()) {
						System.out.println(
							rs.getString("lop") + " - " +
							rs.getInt("soluong") 
							);
					}
			 }
			 
			 // CAU 4: 
	            String sql4 = """
	                SELECT s.name, ROUND(AVG(r.score), 2) AS dtb
	                FROM Student s
	                JOIN Result r ON r.sid = s.id
	                GROUP BY s.id, s.name
	                HAVING COUNT(*) = 3
	                AND AVG(r.score) >= 8.2
	                ORDER BY dtb DESC
	                """;

	            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql4)) {

	                System.out.println("\n=== CAU 4 ===");
	                while (rs.next()) {
	                    System.out.println(
	                        rs.getString("name") + " - " +
	                        rs.getDouble("dtb")
	                    );
	                }
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
	}
}