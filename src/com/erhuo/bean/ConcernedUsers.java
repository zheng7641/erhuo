package com.erhuo.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="concernedusers")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class ConcernedUsers {
	private int concernedid;
	private int userselfid;
	private int otheruserid;
	
	private User user;
	private User Users;
	
	
	public ConcernedUsers() {
		super();
	}
	
	public ConcernedUsers(int userselfid, int otheruserid) {
		super();
		this.userselfid = userselfid;
		this.otheruserid = otheruserid;
	}
	
	@Override
	public String toString() {
		return "ConcernedUsers [concernedid=" + concernedid + ", userselfid="
				+ userselfid + ", otheruserid=" + otheruserid + "]";
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")   
	public int getConcernedid() {
		return concernedid;
	}
	public void setConcernedid(int concernedid) {
		this.concernedid = concernedid;
	}
	public int getUserselfid() {
		return userselfid;
	}
	public void setUserselfid(int userselfid) {
		this.userselfid = userselfid;
	}
	public int getOtheruserid() {
		return otheruserid;
	}
	public void setOtheruserid(int otheruserid) {
		this.otheruserid = otheruserid;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)//一对一 懒加载，级联
	@JoinColumn(name = "userselfid",updatable = false,insertable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "otheruserid",updatable = false,insertable=false)
	public User getUsers() {
		return Users;
	}

	public void setUsers(User users) {
		Users = users;
	}
}
