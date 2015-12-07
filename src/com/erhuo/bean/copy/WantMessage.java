package com.erhuo.bean.copy;

import java.sql.Timestamp;

public class WantMessage {

	private int wantmessageid;
	private int wantid;
	private int userid;
	private String message;
	private Timestamp createtime;

	private Want want;
	private User user;

	public WantMessage() {
		super();
	}

	public int getWantmessageid() {
		return wantmessageid;
	}

	public void setWantmessageid(int wantmessageid) {
		this.wantmessageid = wantmessageid;
	}

	public int getWantid() {
		return wantid;
	}

	public void setWantid(int wantid) {
		this.wantid = wantid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Want getWant() {
		return want;
	}

	public void setWant(Want want) {
		this.want = want;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
