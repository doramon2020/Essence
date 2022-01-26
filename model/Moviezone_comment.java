package model;

import java.io.Serializable;

public class Moviezone_comment implements Serializable {
	private Integer moviezone_comment_id;
	private Integer user_id;
	private String moviezone_context;
	private java.sql.Timestamp moviezone_post_num;
	private Boolean spoiler_alert;
	private Boolean deleted;
	private Integer movie_id;
	
	public Integer getMoviezone_comment_id() {
		return moviezone_comment_id;
	}
	public void setMoviezone_comment_id(Integer moviezone_comment_id) {
		this.moviezone_comment_id = moviezone_comment_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getMoviezone_context() {
		return moviezone_context;
	}
	public void setMoviezone_context(String moviezone_context) {
		this.moviezone_context = moviezone_context;
	}
	public java.sql.Timestamp getMoviezone_post_num() {
		return moviezone_post_num;
	}
	public void setMoviezone_post_num(java.sql.Timestamp moviezone_post_num) {
		this.moviezone_post_num = moviezone_post_num;
	}
	public Boolean getSpoiler_alert() {
		return spoiler_alert;
	}
	public void setSpoiler_alert(Boolean spoiler_alert) {
		this.spoiler_alert = spoiler_alert;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	@Override
	public String toString() {
		return "Moviezone_comment [moviezone_comment_id=" + moviezone_comment_id + ", user_id=" + user_id
				+ ", moviezone_context=" + moviezone_context + ", moviezone_post_num=" + moviezone_post_num
				+ ", spoiler_alert=" + spoiler_alert + ", deleted=" + deleted + ", movie_id=" + movie_id + "]";
	}
}
