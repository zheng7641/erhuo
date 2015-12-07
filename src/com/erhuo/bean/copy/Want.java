package com.erhuo.bean.copy;

import java.sql.Timestamp;

public class Want {
	private int wantid;
	private int userid;
	private String title;
	private String wantIntroduction;
	private Timestamp createtime;
	private User user;

	public Want() {
		super();
	}

	public Want(int userid, String title, String wantIntroduction) {
		super();
		this.userid = userid;
		this.title = title;
		this.wantIntroduction = wantIntroduction;
	}

	public Want(int wantid, int userid, String title, String wantIntroduction) {
		super();
		this.wantid = wantid;
		this.userid = userid;
		this.title = title;
		this.wantIntroduction = wantIntroduction;
	}

	public String toString() {
		return "Want [wantid=" + wantid + ", userid=" + userid + ", title=" + title + ", wantIntroduction="
				+ wantIntroduction + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWantIntroduction() {
		return wantIntroduction;
	}

	public void setWantIntroduction(String wantIntroduction) {
		this.wantIntroduction = wantIntroduction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

}
