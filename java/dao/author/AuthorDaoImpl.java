package dao.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
	
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public int insert(AuthorVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			conn = getConnection();

			String sql = " INSERT INTO author(author_id, author_name, author_desc) \n" + 
					     " values(seq_author_id.nextval, ?, ?) ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.get_author_name());
			pstmt.setString(2, vo.get_author_desc());
			
			count = pstmt.executeUpdate();

			System.out.println(count + " 건이 저장 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return count;
	}

	@Override
	public List<AuthorVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AuthorVO> list = new ArrayList<AuthorVO>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT a.AUTHOR_ID , \n" + 
						 "        a.AUTHOR_NAME , \n" + 
						 "        a.AUTHOR_DESC \n" + 
						 " FROM AUTHOR a";
			
			rs = stmt.executeQuery(sql);
			System.err.println(rs);

			while (rs.next()) {
				AuthorVO vo = new AuthorVO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
				);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return list;
	}

	@Override
	public int delete(Long authorId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;

		try {
			conn = getConnection();
			String sql = " DELETE FROM AUTHOR WHERE AUTHOR_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, authorId);

			deletedCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return deletedCount;
	}

	@Override
	public int update(AuthorVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			conn = getConnection();

			String sql = " UPDATE AUTHOR a\n" + 
						 " SET a.AUTHOR_DESC = ?, a.AUTHOR_NAME = ? \n" + 
						 " WHERE a.AUTHOR_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.get_author_desc() );
			pstmt.setString(2, vo.get_author_name() );
			pstmt.setInt(3, vo.get_author_id() );
			
			count = pstmt.executeUpdate();

			System.out.println(count + " 건이 수정 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	}

	public List<AuthorVO> findKeyword(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuthorVO> list = new ArrayList<>();
		
		try {
		  conn = getConnection();
		  String sql = " SELECT a.AUTHOR_ID , \n" + 
					   "        a.AUTHOR_NAME , \n" + 
					   "        a.AUTHOR_DESC  \n" + 
					   " FROM AUTHOR a \n" + 
					   " WHERE a.AUTHOR_NAME || a.AUTHOR_DESC LIKE ? ";
		  pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, "%"+keyword+"%");   
		
		  rs = pstmt.executeQuery();

		  while(rs.next()) {
			AuthorVO vo = new AuthorVO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3)
				);
			list.add(vo);
		  }
		} catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		} finally {
		  try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		  } catch (Exception e) {
			System.err.println("ERROR:" + e.getMessage());
		  }
		}
		return list;
	  }
}