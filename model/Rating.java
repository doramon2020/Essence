package model;

import java.io.Serializable;

public class Rating implements Serializable {
	private Integer movie_rating;
    private Integer user_id;
    private Integer movie_id;
    private Integer user_rating;
	public Integer getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(Integer movie_rating) {
		this.movie_rating = movie_rating;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public Integer getUser_rating() {
		return user_rating;
	}
	public void setUser_rating(Integer user_rating) {
		this.user_rating = user_rating;
	}
	@Override
	public String toString() {
		return "Rating [movie_rating=" + movie_rating + ", user_id=" + user_id + ", movie_id=" + movie_id
				+ ", user_rating=" + user_rating + "]";
	}
}
