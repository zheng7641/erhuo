package com.erhuo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="school")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class School 
{
	private int schoolId;
	private String schoolName;
	private String city;
	
	private Set<User> user= new HashSet<User>();
	
	public School(){}
	
	public School(String schoolName, String city) {
		super();
		this.schoolName = schoolName;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName
				+ ", city=" + city + "]";
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")   
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

	@OneToMany(mappedBy = "school") 
	public Set<User> getUser() {
		return user;
	}
	@JsonBackReference
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}
