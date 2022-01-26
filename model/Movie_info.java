package model;

import java.io.Serializable;

public class Movie_info implements Serializable {
    private Integer movie_id;
    private String movie_name;
    private Integer movie_type_id;
    private byte[] movie_poster;
    private String movie_introduction;
    private java.sql.Date movie_date;
    private String director;
    private String actor;
    private String movie_trailer;
    private Integer playing_time;
    private String movie_offical_web_site;
    private Boolean movie_releasing_status;
    private java.sql.Timestamp movie_lasted_update_time;
    private Integer priority;
    private Integer employee_id;
	@Override
	public String toString() {
		return "Movie_info [movie_id=" + movie_id + ", movie_name=" + movie_name + ", movie_type_id=" + movie_type_id
				+ ", movie_introduction=" + movie_introduction + ", movie_date=" + movie_date + ", director=" + director
				+ ", actor=" + actor + ", movie_trailer=" + movie_trailer + ", playing_time=" + playing_time
				+ ", movie_offical_web_site=" + movie_offical_web_site + ", movie_releasing_status="
				+ movie_releasing_status + ", movie_lasted_update_time=" + movie_lasted_update_time + ", priority="
				+ priority + ", employee_id=" + employee_id + "]";
	}
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public Integer getMovie_type_id() {
		return movie_type_id;
	}
	public void setMovie_type_id(Integer movie_type_id) {
		this.movie_type_id = movie_type_id;
	}
	public byte[] getMovie_poster() {
		return movie_poster;
	}
	public void setMovie_poster(byte[] movie_poster) {
		this.movie_poster = movie_poster;
	}
	public String getMovie_introduction() {
		return movie_introduction;
	}
	public void setMovie_introduction(String movie_introduction) {
		this.movie_introduction = movie_introduction;
	}
	public java.sql.Date getMovie_date() {
		return movie_date;
	}
	public void setMovie_date(java.sql.Date movie_date) {
		this.movie_date = movie_date;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getMovie_trailer() {
		return movie_trailer;
	}
	public void setMovie_trailer(String movie_trailer) {
		this.movie_trailer = movie_trailer;
	}
	public Integer getPlaying_time() {
		return playing_time;
	}
	public void setPlaying_time(Integer playing_time) {
		this.playing_time = playing_time;
	}
	public String getMovie_offical_web_site() {
		return movie_offical_web_site;
	}
	public void setMovie_offical_web_site(String movie_offical_web_site) {
		this.movie_offical_web_site = movie_offical_web_site;
	}
	public Boolean getMovie_releasing_status() {
		return movie_releasing_status;
	}
	public void setMovie_releasing_status(Boolean movie_releasing_status) {
		this.movie_releasing_status = movie_releasing_status;
	}
	public java.sql.Timestamp getMovie_lasted_update_time() {
		return movie_lasted_update_time;
	}
	public void setMovie_lasted_update_time(java.sql.Timestamp movie_lasted_update_time) {
		this.movie_lasted_update_time = movie_lasted_update_time;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
    
}
