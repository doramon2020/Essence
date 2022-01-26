package model;

public class Favorite_movie {
	private Integer movie_id;
	private Integer user_id;
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Favorite_movie [movie_id=" + movie_id + ", user_id=" + user_id + "]";
	}
}
