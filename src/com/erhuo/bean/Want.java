package com.erhuo.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "want")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Want {
	private int wantid;
	private int userid;
	private String title;
	private String wantIntroduction;
	private Timestamp createtime;
	private Set<WantMessage> wantMessage = new HashSet<WantMessage>();
	private User user;

	public Want() {
		super();
	}

	public Want(int userid, String title, String wantIntroduction,Timestamp createtime) {
		super();
		this.userid = userid;
		this.title = title;
		this.wantIntroduction = wantIntroduction;
		this.createtime=createtime;
	}

	public Want(int wantid, int userid, String title, String wantIntroduction) {
		super();
		this.wantid = wantid;
		this.userid = userid;
		this.title = title;
		this.wantIntroduction = wantIntroduction;
	}

	@Override
	public String toString() {
		return "Want [wantid=" + wantid + ", userid=" + userid + ", title=" + title + ", wantIntroduction="
				+ wantIntroduction + "]";
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
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

	@ManyToOne
	@JoinColumn(name = "userid", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "want")
	public Set<WantMessage> getWantMessage() {
		return wantMessage;
	}

	@JsonBackReference
	public void setWantMessage(Set<WantMessage> wantMessage) {
		this.wantMessage = wantMessage;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

}
