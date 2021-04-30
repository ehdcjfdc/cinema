package com.film.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.DAO.filmDAO;
import com.film.domain.FilmDataDTO;
import com.film.domain.FilmForm;
@Service
public class filmService{
	 
    @Autowired
    private filmDAO filmdao;
 
    /** 영화 시간표 조회 */
    public List<FilmDataDTO> getFilmList(FilmForm filmForm) throws Exception {
 
        return filmdao.getFilmList(filmForm);
    }
    public String[] getAppList(FilmForm filmForm) throws Exception{
    	return filmdao.getAppList(filmForm);
    }
    public List<String> getTime(FilmForm filmForm) throws Exception{
    	return filmdao.getTime(filmForm);
    }
    public int insertApp(FilmForm filmForm) throws Exception{
    	return filmdao.insertApp(filmForm);
    }
    public List<FilmDataDTO> Checklist(FilmForm filmForm) throws Exception {
    	 
        return filmdao.Checklist(filmForm);
    }
    public int delApp(FilmForm filmForm) throws Exception{
    	return filmdao.delApp(filmForm);
    }
}
