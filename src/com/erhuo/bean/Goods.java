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
@Table(name = "goods")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Goods {
	private int goodsid;
	private String typeid;
	private String goodsname;
	private String price;
	private String goodsintroduction;
	private Timestamp createtime;
	private String pic1;
	private String pic2;
	private String pic3;
	private int userid;
	private String place;
	private String phone;

	private User user;
	// private GoodsType goodsType;
	private Set<Collection> colletion = new HashSet<Collection>();
	private Set<GoodsMessage> goodsMessage = new HashSet<GoodsMessage>();

	public Goods() {
		super();
	}

	public Goods(String typeid, int userid, String goodsname, String price, String goodsintroduction,
			Timestamp createtime, String pic1, String pic2, String pic3, String place, String phone) {
		super();
		this.typeid = typeid;
		this.userid = userid;
		this.goodsname = goodsname;
		this.price = price;
		this.goodsintroduction = goodsintroduction;
		this.createtime = createtime;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.place = place;
		this.phone = phone;
	}

	public Goods(int goodsid, int userid, String typeid, String goodsname, String price, String goodsintroduction,
			Timestamp createtime, String pic1, String pic2, String pic3, String place, String phone) {
		super();
		this.goodsid = goodsid;
		this.userid = userid;
		this.typeid = typeid;
		this.goodsname = goodsname;
		this.price = price;
		this.goodsintroduction = goodsintroduction;
		this.createtime = createtime;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.place = place;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", typeid=" + typeid + ", goodsname=" + goodsname + ", price=" + price
				+ ", goodsintroduction=" + goodsintroduction + ", createtime=" + createtime + ", pic1=" + pic1
				+ ", pic2=" + pic2 + ", pic3=" + pic3 + ", userid=" + userid + ", place=" + place + ", user=" + user
				+ ", colletion=" + colletion + ", goodsMessage=" + goodsMessage + "]";
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoodsintroduction() {
		return goodsintroduction;
	}

	public void setGoodsintroduction(String goodsintroduction) {
		this.goodsintroduction = goodsintroduction;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	@ManyToOne
	@JoinColumn(name = "userid", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "goods")
	public Set<Collection> getColletion() {
		return colletion;
	}
	@JsonBackReference
	public void setColletion(Set<Collection> colletion) {
		this.colletion = colletion;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@OneToMany(mappedBy = "goods")
	public Set<GoodsMessage> getGoodsMessage() {
		return goodsMessage;
	}
	@JsonBackReference
	public void setGoodsMessage(Set<GoodsMessage> goodsMessage) {
		this.goodsMessage = goodsMessage;
	}
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "typeid",updatable = false,insertable=false) public
	 * GoodsType getGoodsType() { return goodsType; } public void
	 * setGoodsType(GoodsType goodsType) { this.goodsType = goodsType; }
	 */

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
