package com.erhuo.bean.copy;

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

	public String toString() {
		return "Collection [collectionid=" + collectionid + ", userid=" + userid + ", goodsid=" + goodsid + "]";
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
