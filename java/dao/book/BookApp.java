package dao.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		boolean result = false;
		BookDao dao = new BookDaoImpl();
		List<BookVO> list = new ArrayList<BookVO>();

		// INSERT
		// BookVO vo = new BookVO(2, "삼국지", "민음사", "2002-03-01", 1);
        // result = dao.insert(vo);
		// System.out.print("입력 데이터 건수 : " + result);
	  
	    // UPDATE
		// BookVO vo2 = new BookVO(3, "토지", "마로니에북스", "2012-08-15", 2);
		// result = dao.update(vo2);
		// System.out.print("수정 데이터 건수 : " + result);

		// DELETE
		// Long book_id = new Long(4);
		// result = dao.delete(book_id);
		// System.out.print("삭제 데이터 건수 : " + result);

		// Search ALL
		list = dao.getList();
		for (BookVO vo3 : list) {
			System.out.println(vo3);
		}
		System.out.print("전체 데이터 건수 : " + list.size() + "\n");
		
		// INPUT KeyWord
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어 >>");
		String keyword = sc.nextLine();
		
		// PRINT
		List<BookVO> resultList = dao.findKeyword(keyword);
		for(BookVO vo : resultList) {
			System.out.println(vo.toStringWithAuthorName());
		}
	}
}
