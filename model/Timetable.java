package model;

import java.io.Serializable;

public class Timetable implements Serializable {
	private Integer timetable_id;
	private java.sql.Timestamp movie_stime;
	private java.sql.Timestamp movie_etime;
	private String seat;
	private Integer movie_id;
	private Integer hall_id;
	
	@Override
	public String toString() {
		return "TimetableBean [timetable_id=" + timetable_id + ", movie_stime=" + movie_stime + ", movie_etime="
				+ movie_etime + ", movie_id=" + movie_id + ", hall_id=" + hall_id + ", seat=" + seat + "]";
	}
	public Integer getTimetable_id() {
		return timetable_id;
	}
	public void setTimetable_id(Integer timetable_id) {
		this.timetable_id = timetable_id;
	}
	public java.sql.Timestamp getMovie_stime() {
		return movie_stime;
	}
	public void setMovie_stime(java.sql.Timestamp movie_stime) {
		this.movie_stime = movie_stime;
	}
	public java.sql.Timestamp getMovie_etime() {
		return movie_etime;
	}
	public void setMovie_etime(java.sql.Timestamp movie_etime) {
		this.movie_etime = movie_etime;
	}
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public Integer getHall_id() {
		return hall_id;
	}
	public void setHall_id(Integer hall_id) {
		this.hall_id = hall_id;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
}
