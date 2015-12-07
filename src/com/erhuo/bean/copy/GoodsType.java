package com.erhuo.bean.copy;

import java.util.HashSet;
import java.util.Set;

public class GoodsType {
	private int typeid;
	private String typename;

	private Set<Goods> goods = new HashSet<Goods>();

	public GoodsType() {
		super();
	}

	public GoodsType(int typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
	}

	public String toString() {
		return "GoodsType [typeid=" + typeid + ", typename=" + typename + "]";
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

}
