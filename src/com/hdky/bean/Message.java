package com.hdky.bean;

public class Message {
	private String title;
	private String time;
	private String text;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String title, String time, String text) {
		super();
		this.title = title;
		this.time = time;
		this.text = text;
	}
	@Override
	public String toString() {
		return "Message [title=" + title + ", time=" + time + ", text=" + text
				+ "]";
	}
	
	

}
