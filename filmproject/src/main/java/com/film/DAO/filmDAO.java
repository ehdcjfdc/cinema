package com.film.DAO;


import com.film.domain.FilmForm;
import com.film.domain.FilmDataDTO;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class filmDAO{
	@Resource(name = "sqlSession")
    private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.mapper.film";
	 
    /** 메인페이지-영화목록 */
    public List<FilmDataDTO> getFilmList(FilmForm filmForm) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getFilmList", filmForm);
    }
    /**영화 예약좌석 조회*/
    public String[] getAppList(FilmForm filmForm) throws Exception{
    	List<String> s = sqlSession.selectList(NAMESPACE + ".getAppList", filmForm);
    	String temp =String.join(",", s);
    	String[] res = temp.split(",");
    	return res;
    }
    public List<String> getTime(FilmForm filmForm) throws Exception{
    	return sqlSession.selectList(NAMESPACE+".getTime",filmForm);
    }
    public int insertApp(FilmForm filmForm) throws Exception{
    	filmForm.setSeats(String.join(",",filmForm.getSeats_temp()));
    	System.out.println(filmForm.getSeats());
    	return sqlSession.insert(NAMESPACE+".insertApp",filmForm);
    }
    public List<FilmDataDTO> Checklist(FilmForm filmForm) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getApp", filmForm);
    }
    public int delApp(FilmForm filmForm) throws Exception{
    	return sqlSession.insert(NAMESPACE+".delApp",filmForm);
    }
}
