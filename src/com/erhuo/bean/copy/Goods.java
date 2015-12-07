package com.erhuo.bean.copy;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Goods {
	private int goodsid;
	private int typeid;
	private String goodsname;
	private String price;
	private String goodsintroduction;
	private Timestamp createtime;
	private String pic1;
	private String pic2;
	private String pic3;
	private int userid;

	private User user;
	private GoodsType goodsType;
	private Set<Collection> colletion = new HashSet<Collection>();
	private Set<GoodsMessage> goodsMessage = new HashSet<GoodsMessage>();

	public Goods() {
		super();
	}

	public Goods(int typeid, int userid, String goodsname, String price, String goodsintroduction, Timestamp createtime,
			String pic1, String pic2, String pic3) {
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
	}

	public Goods(int goodsid, int userid, int typeid, String goodsname, String price, String goodsintroduction,
			Timestamp createtime, String pic1, String pic2, String pic3) {
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
	}

	public String toString() {
		return "Goods [goodsid=" + goodsid + ", typeid=" + typeid + ", goodsname=" + goodsname + ", price=" + price
				+ ", goodsintroduction=" + goodsintroduction + ",createtime=" + createtime + ", pic1=" + pic1
				+ ", pic2=" + pic2 + ", pic3=" + pic3 + ", userid=" + userid + "]";
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Collection> getColletion() {
		return colletion;
	}

	public void setColletion(Set<Collection> colletion) {
		this.colletion = colletion;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Set<GoodsMessage> getGoodsMessage() {
		return goodsMessage;
	}

	public void setGoodsMessage(Set<GoodsMessage> goodsMessage) {
		this.goodsMessage = goodsMessage;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

}
