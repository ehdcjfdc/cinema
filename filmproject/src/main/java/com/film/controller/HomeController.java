package com.film.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.film.Service.filmService;
import com.film.domain.FilmDataDTO;
import com.film.domain.FilmForm;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins="http://localhost:8081")
public class HomeController {
	
	@Autowired
    private filmService service;
 
    /** 메인 영화 리스트 이동*/
    @RequestMapping( value = "/filmList")
    public String filmList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "/filmList";
    }
    /**영화 시간표 조회*/
    @ResponseBody
    @CrossOrigin(origins="http://localhost:8081")
    @RequestMapping( value = "/getfilmList")
    public List<FilmDataDTO> getfilmList(HttpServletRequest request, HttpServletResponse response, FilmForm filmForm) throws Exception{
    	List<FilmDataDTO> filmDtolist = service.getFilmList(filmForm);
    	return filmDtolist;
    }
    /**예약페이지 이동*/
    @RequestMapping( value = "/filmApp")
    public String filmDetailt(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	return "/filmApp";
    }
    /**예약페이지 작동*/
    @ResponseBody
    @RequestMapping( value = "/getfilmApp")
    public String[] getfilmApp(@RequestBody FilmForm filmForm) throws Exception{
    	return service.getAppList(filmForm);
    }
    @ResponseBody
    @RequestMapping( value = "/getTime")
    public List<String> getTime(@RequestBody FilmForm filmform) throws Exception{
    	return service.getTime(filmform);
    }
    @ResponseBody
    @RequestMapping( value = "/insertApp")
    public int insertApp(@RequestBody FilmForm filmform) throws Exception{
    	return service.insertApp(filmform);
    }
    @ResponseBody
    @RequestMapping( value = "/Checklist")
    public List<FilmDataDTO> Checklist(@RequestBody FilmForm filmform) throws Exception{
    	return service.Checklist(filmform);
    }
    @ResponseBody
    @RequestMapping( value = "/delApp")
    public int delApp(@RequestBody FilmForm filmform) throws Exception{
    	return service.delApp(filmform);
    }
    
	
}
