package model;

import java.io.Serializable;

public class Hall implements Serializable{
	private Integer hall_id;
	private String hall_name;
	private String seat;
	
	public Integer getHall_id() {
		return hall_id;
	}
	public void setHall_id(Integer hall_id) {
		this.hall_id = hall_id;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Hall [hall_id=" + hall_id + ", hall_name=" + hall_name + ", seat=" + seat + "]";
	}	
}
