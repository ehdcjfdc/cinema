package com.film.domain;

import java.util.List;

public class FilmForm {
	private String appNum;
	private String phon;
	private String theaterNum;
	private String t;
	private String m;
	private String seats;
	private List<String> seats_temp;
	
	public String getAppNum() {
		return appNum;
	}
	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}
	public List<String> getSeats_temp() {
		return seats_temp;
	}
	public void setSeats_temp(List<String> seats_temp) {
		this.seats_temp = seats_temp;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	public String getTheaterNum() {
		return theaterNum;
	}
	public void setTheaterNum(String theaterNum) {
		this.theaterNum = theaterNum;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	
}
