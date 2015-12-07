package com.erhuo.bean.copy;

import java.sql.Timestamp;

public class GoodsMessage {
	private int goodsmessageid;
	private int goodsid;
	private int writeuser;
	private String message;
	private Timestamp createtime;

	private User user;
	private Goods goods;

	public GoodsMessage() {
		super();
	}

	public GoodsMessage(int goodsid, int writeuser, String message, Timestamp createtime) {
		super();
		this.goodsid = goodsid;
		this.writeuser = writeuser;
		this.message = message;
		this.createtime = createtime;
	}

	public GoodsMessage(int goodsmessageid, int goodsid, int writeuser, String message, Timestamp createtime) {
		super();
		this.goodsmessageid = goodsmessageid;
		this.goodsid = goodsid;
		this.writeuser = writeuser;
		this.message = message;
		this.createtime = createtime;
	}

	public String toString() {
		return "Goodsmessage [goodsmessageid=" + goodsmessageid + ", goodsid=" + goodsid + ", writeuser=" + writeuser
				+ ", message=" + message + ", createtime=" + createtime + "]";
	}

	public int getGoodsmessageid() {
		return goodsmessageid;
	}

	public void setGoodsmessageid(int goodsmessageid) {
		this.goodsmessageid = goodsmessageid;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public int getWriteuser() {
		return writeuser;
	}

	public void setWriteuser(int writeuser) {
		this.writeuser = writeuser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
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
