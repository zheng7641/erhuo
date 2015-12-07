package com.erhuo.bean.copy;

import java.util.List;

public class Pager<T> {
	private List<T> datas;// 数据列表
	private int num;// 页码
	private int size;// 每页大小
	private long total;// 总熟�?

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
