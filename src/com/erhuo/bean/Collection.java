package com.erhuo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="collection")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class Collection {
	private int collectionid;
	private int userid;
	private int goodsid;
	
	private User user;
	private Goods goods;
	
	public Collection() {
		super();
	}
	
	public Collection(int userid, int goodsid) {
		super();
		this.userid = userid;
		this.goodsid = goodsid;
	}

	public Collection(int collectionid, int userid, int goodsid) {
		super();
		this.collectionid = collectionid;
		this.userid = userid;
		this.goodsid = goodsid;
	}
	
	@Override
	public String toString() {
		return "Collection [collectionid=" + collectionid + ", userid="
				+ userid + ", goodsid=" + goodsid + "]";
	}
	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")   
	public int getCollectionid() {
		return collectionid;
	}
	public void setCollectionid(int collectionid) {
		this.collectionid = collectionid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	
	@ManyToOne
	@JoinColumn(name = "userid",updatable = false,insertable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "userid",updatable = false,insertable=false)
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
