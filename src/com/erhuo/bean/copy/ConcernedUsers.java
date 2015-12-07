package com.erhuo.bean.copy;

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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUsers() {
		return Users;
	}

	public void setUsers(User users) {
		Users = users;
	}
}
