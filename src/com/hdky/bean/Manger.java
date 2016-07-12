package com.hdky.bean;

import java.io.Serializable;

public class Manger implements Serializable {
	private String mid;
	 private String mpassword;
	 private String mname;
	 private String msex;
	 private String mage;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMsex() {
		return msex;
	}
	public void setMsex(String msex) {
		this.msex = msex;
	}
	public String getMage() {
		return mage;
	}
	public void setMage(String mage) {
		this.mage = mage;
	}
	public Manger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manger(String mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
}
