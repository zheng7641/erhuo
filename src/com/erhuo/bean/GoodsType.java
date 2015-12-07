package com.erhuo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

/*@Entity
@Table(name="goodstype")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) */
public class GoodsType {
	private int typeid;
	private String typename;
	
	private Set<Goods> goods= new HashSet<Goods>();
	
	public GoodsType() {
		super();
	}
	public GoodsType(int typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "GoodsType [typeid=" + typeid + ", typename=" + typename + "]";
	}
	/*@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")  */ 
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
	
	/*@OneToMany(mappedBy = "goodsType") 
	@JsonBackReference*/
	public Set<Goods> getGoods() {
		return goods;
	}
	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	
	

}
