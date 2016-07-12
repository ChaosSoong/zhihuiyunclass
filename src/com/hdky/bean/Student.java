package com.hdky.bean;

import java.io.Serializable;

public class Student implements Serializable{
	private  String sid;
	private  String tpassword; 
	private  String tname; 
	private  String classes; 
	private  String tsex; 
	private  int    tage;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getClasses() {
		return classes;
	}
	public void setClassse(String classse) {
		this.classes = classes;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sid, String tname) {
		super();
		this.sid = sid;
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", tname=" + tname + ", classes="
				+ classes + ", tsex=" + tsex + ", tage=" + tage + "]";
	}
}
