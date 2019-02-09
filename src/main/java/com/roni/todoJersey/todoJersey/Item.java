package com.roni.todoJersey.todoJersey;

public class Item {
	
	int id;
	String note;
	String date;
	boolean status;
	
	public Item(int id,String date,String note, boolean status) {
		this.id = id;
		this.note = note;
		this.date = date;
		this.status = status;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", note=" + note + ", date=" + date + ", status=" + status + "]";
	}
	
}
