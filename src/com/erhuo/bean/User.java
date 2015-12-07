package com.erhuo.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class User {
	private int userid;
	private String username;
	private String userpassword;
	private int schoolid;
	private String nickname;
	private String phone;
	private String userintroduction;
	private String userimgpath;
	private String email;
	private String place;
	private Timestamp createtime;
	
	private Set<Goods> goods= new HashSet<Goods>();
	private Set<Collection> collection= new HashSet<Collection>();
	private Set<GoodsMessage> goodsMessage= new HashSet<GoodsMessage>();
	private School school;
	private Set<Want> want= new HashSet<Want>();
	private ConcernedUsers userSelf;
	private Set<ConcernedUsers> users= new HashSet<ConcernedUsers>();
	private Set<WantMessage> wantMessage = new HashSet<WantMessage>();
	
	public User() {
		super();
	}

	public User(int userid, String username, String userpassword, int schoolid,
			String nickname, String phone, String userintroduction,
			String userimgpath, String email, Timestamp createtime) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.schoolid = schoolid;
		this.nickname = nickname;
		this.phone = phone;
		this.userintroduction = userintroduction;
		this.userimgpath = userimgpath;
		this.email = email;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", userpassword=" + userpassword + ", schoolid=" + schoolid
				+ ", nickname=" + nickname + ", phone=" + phone
				+ ", userintroduction=" + userintroduction + ", userimgpath="
				+ userimgpath + ", email=" + email + ", createtime="
				+ createtime + "]";
	}
	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")   
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserintroduction() {
		return userintroduction;
	}
	public void setUserintroduction(String userintroduction) {
		this.userintroduction = userintroduction;
	}
	public String getUserimgpath() {
		return userimgpath;
	}
	public void setUserimgpath(String userimgpath) {
		this.userimgpath = userimgpath;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	@OneToMany(mappedBy = "user") 
	@JsonBackReference
	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	@OneToMany(mappedBy = "user") 
	public Set<Collection> getCollection() {
		return collection;
	}
	@JsonBackReference
	public void setCollection(Set<Collection> collection) {
		this.collection = collection;
	}
	@OneToMany(mappedBy = "user") 
	public Set<GoodsMessage> getGoodsMessage() {
		return goodsMessage;
	}
	@JsonBackReference
	public void setGoodsMessage(Set<GoodsMessage> goodsMessage) {
		this.goodsMessage = goodsMessage;
	}

	@ManyToOne
	@JoinColumn(name = "schoolid",updatable = false,insertable=false)
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	@OneToMany(mappedBy = "user") 
	public Set<Want> getWant() {
		return want;
	}
	@JsonBackReference
	public void setWant(Set<Want> want) {
		this.want = want;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public ConcernedUsers getUserSelf() {
		return userSelf;
	}
	@JsonBackReference
	public void setUserSelf(ConcernedUsers userSelf) {
		this.userSelf = userSelf;
	}

	@OneToMany(mappedBy = "users") 
	public Set<ConcernedUsers> getUsers() {
		return users;
	}
	@JsonBackReference
	public void setUsers(Set<ConcernedUsers> users) {
		this.users = users;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	@OneToMany(mappedBy = "user")
	public Set<WantMessage> getWantMessage() {
		return wantMessage;
	}
	@JsonBackReference
	public void setWantMessage(Set<WantMessage> wantMessage) {
		this.wantMessage = wantMessage;
	}
	
	
}
