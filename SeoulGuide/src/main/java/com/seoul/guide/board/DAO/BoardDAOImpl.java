package com.seoul.guide.board.DAO;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seoul.guide.board.DTO.Article;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<Article> selectBoardList() throws Exception {

		return sqlSession.selectList("mapper.board.selectBoardList");
	}

	@Override
	public Article selectBoard(Integer post_id) throws Exception {

		return sqlSession.selectOne("mapper.board.selectBoard", post_id);
	}


	@Override
	public Integer insertBoard(Article article) throws Exception {
		return sqlSession.insert("mapper.board.insertBoard", article);
	}
	
	@Override
	public void updateBoard(Map<String, Object> param) throws Exception {
		sqlSession.update("mapper.board.updateBoard", param);
	}


	@Override
	public void deleteBoard(Integer post_id) throws Exception {
		sqlSession.delete("mapper.board.deleteBoard", post_id);
	}

}