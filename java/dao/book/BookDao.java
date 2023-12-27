/*

Data Access Object (DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트)

DAO를 사용하는 이유는 다음과 같습니다:

분리된 책임: DAO를 사용하면 데이터베이스 접근 로직을 별도로 관리할 수 있으며, 이로써 비즈니스 로직과의 의존성을 줄일 수 있습니다.
유연성: DAO를 통해 데이터베이스 변경이 발생해도 해당 변경 사항을 DAO 내부에 캡슐화할 수 있어 기존 코드에 영향을 최소화할 수 있습니다.
보안과 안정성: DAO를 통해 데이터베이스 접근을 추상화하고, 입력 유효성 검사 및 보안을 강화할 수 있습니다.
따라서 DAO를 사용하면 데이터베이스와의 상호작용을 효율적으로 관리하고, 유지보수성을 높이며, 시스템의 유연성을 향상시킬 수 있습니다.

*/
package dao.book;
import java.util.List;

public interface BookDao {
    public boolean insert(BookVO vo);
	public List<BookVO> getList(); 
	public boolean delete(Long bookId); 
	public boolean update(BookVO vo);
	public List<BookVO> findKeyword(String keyword);
}

