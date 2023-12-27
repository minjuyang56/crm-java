package dao.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

	private Connection getConnection() {
		Connection conn = null;
		
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
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
	public boolean insert(BookVO vo) {

		System.out.println("BookDaoImpl.insert(vo) --> " + vo);

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;

		try {
			
			conn = getConnection();

			String sql = " INSERT INTO book"
					+ " values(seq_book_id.nextval, ?, ?, TO_DATE(?, 'YYYY_MM_DD'), ?) ";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.get_book_title());
			pstmt.setString(2, vo.get_book_pubs());
            pstmt.setString(3, vo.get_book_pub_date());
			pstmt.setInt(4, vo.get_author_id());

			insertedCount = pstmt.executeUpdate();

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

		return 1 == insertedCount;
	}

	@Override
	public List<BookVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT b.BOOK_ID , \n" + 
						 "        b.TITLE , \n" + 
						 "        b.PUBS , \n" + 
						 "        TO_CHAR(b.PUB_DATE, 'YYYY/MM/DD' ) pubdate, \n" + 
						 "        b.AUTHOR_ID \n" + 
						 " FROM BOOK b";
			
			rs = stmt.executeQuery(sql);
			System.err.println(rs);

			while (rs.next()) {
				BookVO vo = new BookVO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5)
				);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return list;
	}

	@Override
	public boolean delete(Long book_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;

		try {
			conn = getConnection();
			String sql = " DELETE FROM BOOK WHERE BOOK_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, book_id);

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

		return 1 == deletedCount;
	}

	@Override
	public boolean update(BookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;

		try {
			conn = getConnection();
			String sql = " UPDATE BOOK SET \n" + 
						 " title = ?, \n" + 
						 " pubs = ?, \n" + 
						 " pub_date = to_date(?,'YYYY-MM-DD'), \n" + 
						 " AUTHOR_ID = ? \n" + 
						 " WHERE book_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.get_book_title());
			pstmt.setString(2, vo.get_book_pubs());
			pstmt.setString(3, vo.get_book_pub_date());
			pstmt.setInt(4, vo.get_author_id());
			pstmt.setInt(5, vo.get_book_id());
			
			updatedCount = pstmt.executeUpdate();
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

		return 1 == updatedCount;
	}
	
	public List<BookVO> findKeyword(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<>();
		
		try {
		  conn = getConnection();
		  String sql = " SELECT b.BOOK_ID , \n" + 
					   "        b.TITLE , \n" + 
					   "        b.PUBS , \n" + 
					   "        TO_CHAR(b.PUB_DATE, 'YYYY/MM/DD' ) pubdate, \n" + 
					   "        a.AUTHOR_NAME \n" + 
					   " FROM BOOK b, AUTHOR a \n" + 
					   " WHERE b.TITLE || b.PUBS || a.AUTHOR_NAME LIKE ? ";
		  pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, "%"+keyword+"%");

		  rs = pstmt.executeQuery();

		  while(rs.next()) {
			BookVO vo = new BookVO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5)
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