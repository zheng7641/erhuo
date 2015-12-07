package com.erhuo.bean.copy;

import java.util.HashSet;
import java.util.Set;

public class School {
	private int schoolId;
	private String schoolName;
	private String city;

	private Set<User> user = new HashSet<User>();

	public School() {
	}

	public School(String schoolName, String city) {
		super();
		this.schoolName = schoolName;
		this.city = city;
	}

	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", city=" + city + "]";
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}
