package dao.author;

import java.util.List;

public interface AuthorDao {
	public int insert(AuthorVO vo);
	public List<AuthorVO> getList();
	public int delete(Long authorId);
	public int update(AuthorVO vo);
	public List<AuthorVO> findKeyword(String keyword);
}