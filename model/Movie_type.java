package model;

public class Movie_type {
	private Integer movie_type_id;
	private String movie_type;
	
	@Override
	public String toString() {
		return "Movie_type [movie_type_id=" + movie_type_id + ", movie_type=" + movie_type + "]";
	}
	public Integer getMovie_type_id() {
		return movie_type_id;
	}
	public void setMovie_type_id(Integer movie_type_id) {
		this.movie_type_id = movie_type_id;
	}
	public String getMovie_type() {
		return movie_type;
	}
	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}
}
