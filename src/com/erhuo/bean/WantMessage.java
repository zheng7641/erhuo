package com.erhuo.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "wantmessage")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	@JoinColumn(name = "wantid", updatable = false, insertable = false)
	public Want getWant() {
		return want;
	}

	public void setWant(Want want) {
		this.want = want;
	}

	@ManyToOne
	@JoinColumn(name = "userid", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
