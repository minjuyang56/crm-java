package dao.author;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorApp {
    public static void main(String[] args) {
		int count = 0;
		List<AuthorVO> list = new ArrayList<AuthorVO>();
		AuthorDao dao = new AuthorDaoImpl();

		// INSERT
		// AuthorVO vo = new AuthorVO(7,"유수빈","소설가");
        // count = dao.insert(vo);
		// System.out.print("입력 데이터 건수 : " + count);
	  
	    // UPDATE
		// AuthorVO vo = new AuthorVO(8,"유지원","의사");
		// count = dao.update(vo);
		// System.out.print("수정 데이터 건수 : " + count);

		// DELETE
		// Long author_id = new Long(8);
		// count = dao.delete(author_id);
		// System.out.print("삭제 데이터 건수 : " + count);

		// Search ALL
		list = dao.getList();
		for (AuthorVO vo3 : list) {
			System.out.println(vo3);
		}
		System.out.print("전체 데이터 건수 : " + list.size() + "\n");
		
		// INPUT KeyWord
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어 >>");
		String keyword = sc.nextLine();
		
		// PRINT
		List<AuthorVO> resultList = dao.findKeyword(keyword);
		for(AuthorVO vo : resultList) {
      		System.out.println(vo);
    	}
	}
}
