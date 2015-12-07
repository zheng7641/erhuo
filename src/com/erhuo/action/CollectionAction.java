package com.erhuo.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.erhuo.bean.Collection;
import com.erhuo.bean.Goods;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class CollectionAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final String USERID = "userid";
	private static final String GOODSID = "goodsid";
	private static final String COLLECTIONID = "collectionid";

	private HttpServletRequest request;
	private HttpServletResponse response;

	IBaseService<Collection, Integer> collectionService;
	IBaseService<Goods, Integer> goodsService;

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}

	public IBaseService<Collection, Integer> getCollectionService() {
		return collectionService;
	}

	@Resource(name = "baseService")
	public void setCollectionService(IBaseService<Collection, Integer> collectionService) {
		this.collectionService = collectionService;
	}

	public IBaseService<Goods, Integer> getGoodsSerice() {
		return goodsService;
	}
	@Resource(name="baseService")
	public void setGoodsSerice(IBaseService<Goods, Integer> goodsService) {
		this.goodsService = goodsService;
	}

	// ͨ��userid����ȡ�ղؼ�List
	public String getCollectionListByUserid() throws Exception {
		request.setCharacterEncoding("utf-8");
		int userid = Integer.valueOf(request.getParameter(USERID));
		System.out.println("ͨ��userid����ȡ�ղؼ�List��useridΪ��" + userid);
		String sql = "from Collection where userid=" + userid;
		List<Collection> collectionList = collectionService.queryBySql(Collection.class, sql);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), collectionList);
		return null;
	}

	// ͨ��userid����ȡ�ղص���ƷList
	public String getCollectionGoodsListByUserid() throws Exception {
		request.setCharacterEncoding("utf-8");
		int userid = Integer.valueOf(request.getParameter(USERID));
		System.out.println("ͨ��userid����ȡ�ղص���ƷList��useridΪ��" + userid);
		String sql = "from Goods g where g.goodsid in ( from Collection c where c.userid=" + userid + ")";
		List<Goods> goodsList = goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), goodsList);
		return null;
	}

	// ɾ���ղؼ�
	public String delCollection() throws Exception {
		request.setCharacterEncoding("utf-8");
		int collectionid = Integer.valueOf(request.getParameter(COLLECTIONID));
		collectionService.delete(Collection.class, collectionid);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), true);// ������Դ���true���߲���
		return null;
	}

	// ����ղؼ�
	public String addCollection() throws Exception {
		request.setCharacterEncoding("utf-8");
		int userid = Integer.valueOf(request.getParameter(USERID));
		int goodsid = Integer.valueOf(request.getParameter(GOODSID));
		Collection collection = new Collection(userid, goodsid);
		collectionService.add(collection);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), true);// ������Դ���true���߲���
		return null;
	}

	// ͨ��userid,goodsid�ж��Ƿ��ղ�
	public String getCollectionStatus() throws Exception {
		request.setCharacterEncoding("utf-8");
		int userid = Integer.valueOf(request.getParameter(USERID));
		int goodsid = Integer.valueOf(request.getParameter(GOODSID));
		String sql = "from Collection c where c.userid=" + userid + " and c.goodsid=" + goodsid;
		int count = collectionService.queryBySql(Collection.class, sql).size();
		System.out.println(sql);
		System.out.println(count);
		ObjectMapper om = new ObjectMapper();
		if (count != 0) {
			om.writeValue(response.getOutputStream(), true);// ������Դ���true���߲���
		} else {
			om.writeValue(response.getOutputStream(), false);
		}
		return null;
	}

}
