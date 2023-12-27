import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. JDBC 드라이버 (Oracle) 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 2. Connection 얻어오기
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "webdb", "1234");
            
            // 3. SQL문 준비 / 바인딩 / 실행
            //SQL문 작성
            String sql = "INSERT INTO author (author_id, author_name, author_decs) VALUES(11, ?, ?)";
            
            //바인딩
            pstmt= conn.prepareStatement(sql);

            pstmt.setString(1, "바나나");
            pstmt.setString(2, "영어 강사");
            
            //실행
            rs = pstmt.executeQuery();

            // 4.결과처리
            while (rs.next()) {
                System.out.print(rs.getInt(1) + ", ");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("error: 드라이버 로딩 실패 - " + e);
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            
            // 5. 자원정리
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("error:" + e);
            }
        }
    }
}

