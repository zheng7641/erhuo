package com.erhuo.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.erhuo.bean.Goods;
import com.erhuo.interfaces.IBaseService;
import com.erhuo.tools.RandomNum;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class GoodsAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final String  GOODSID="goodsid";
	private static final String USERID="userid";
	private static final String  TYPEID="typeid";
	private static final String GOODSNAME="goodsname";
	private static final String PRICE="price";
	private static final String GOODSINTRODUCTION="goodsintroduction";
	private static final String PIC1="pic1";
	private static final String PIC2="pic2";
	private static final String PIC3="pic3";
	private static final String PLACE = "place";
	private static final String PHONE = "phone";
	private static final String FIRSTRESULT = "firstresult";
	private static final String MAXRESULT = "maxresult";
	private static final String SIZE = "size";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<Goods,Integer> goodsService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<Goods, Integer> getGoodsSerice() {
		return goodsService;
	}
	@Resource(name="baseService")
	public void setGoodsSerice(IBaseService<Goods, Integer> goodsService) {
		this.goodsService = goodsService;
	}
	
	//������Ʒ��Ϣ
	public String publishGoods() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		String typeid=request.getParameter(TYPEID);
		int userid=Integer.valueOf(request.getParameter(USERID));
		String goodsname=request.getParameter(GOODSNAME);
		String price=request.getParameter(PRICE);
		String goodsintroduction=request.getParameter(GOODSINTRODUCTION);
		Timestamp createtime=new Timestamp(new Date().getTime());
		String pic1=request.getParameter(PIC1);
		String pic2=request.getParameter(PIC2);
		String pic3=request.getParameter(PIC3);
		String place = request.getParameter(PLACE);
		String phone = request.getParameter(PHONE);
		Goods goods=new Goods(typeid,userid,goodsname,price,goodsintroduction,createtime,pic1,pic2,pic3,place,phone);
		goodsService.add(goods);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//������Դ���true���߲���
		return null;
	}
	//��ȡ������Ʒ�б�
	public String getGoodsList() throws Exception
	{
		List<Goods> goodsList=goodsService.list(Goods.class);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
	//ͨ��userid��ȡ��Ʒ�б�
	public String getGoodsListByUserid() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		String sql="from Goods where userid="+userid;
		List<Goods> goodsList=goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
	//ͨ��typeid��ȡ��Ʒ�б�
	public String getGoodsListByTypeid() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		//int typeid=Integer.valueOf(request.getParameter(TYPEID));
		System.out.println("ͨ����Ʒ���Ͳ�����Ʒ����Ʒ����Ϊ"+request.getParameter(TYPEID));
		String typeid=request.getParameter(TYPEID);
		String sql="from Goods where typeid like '%"+typeid+"%'";
		List<Goods> goodsList=goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
    //ͨ��goodsid��ȡgoods
	public String getGoodsByGoodsid() throws Exception
	{
		System.out.println("ͨ��goodsid��ȡgoods��goodsid="+request.getParameter("goodsid"));
		request.setCharacterEncoding("utf-8");
		int goodsid=Integer.valueOf(request.getParameter(GOODSID));
		Goods goods=goodsService.load(Goods.class, goodsid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goods);
		return null;
	}
	//ɾ����Ʒ��Ϣ
	public String delGoods() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int goodsid=Integer.valueOf(request.getParameter(GOODSID));
		goodsService.delete(Goods.class, goodsid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);
		return null;
	}
	//�������size��goods
	public String randomGoodsList() throws Exception
	{
		int firstresult=Integer.valueOf(request.getParameter(FIRSTRESULT));
		int maxresult=Integer.valueOf(request.getParameter(MAXRESULT));
		int size = maxresult - firstresult;
		
		System.out.println("�������"+size+"��ͼƬ�����յ������ֵΪ��"+maxresult+"�����յ�����СֵΪ��"+firstresult);
		List<Goods> tempGoodsList=goodsService.list(Goods.class);
		List<Goods> goodsList=new ArrayList<Goods>();
		for(Goods g:tempGoodsList)
		{
			System.out.println("temp="+g.toString());
		}
		
		if(tempGoodsList.size()<size)
		{
			size=tempGoodsList.size();
		}
		
		int[] randomNo=RandomNum.randomCommon(0, tempGoodsList.size()+1, size);

		for(int i=0;i<size;i++)
		{
			goodsList.add(tempGoodsList.get(randomNo[i]-1));
		}
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
	
	//�������size��goods��ͨ�����ֵ����Сֵ����������
		public String randomGoodsListByResult() throws Exception
		{
			int size = Integer.valueOf(request.getParameter(SIZE));
			System.out.println("�������"+size+"��ͼƬ");
			List<Goods> tempGoodsList=goodsService.list(Goods.class);
			List<Goods> goodsList=new ArrayList<Goods>();
			for(Goods g:tempGoodsList)
			{
				System.out.println("temp="+g.toString());
			}
			
			if(tempGoodsList.size()<size)
			{
				size=tempGoodsList.size();
			}
			
			int[] randomNo=RandomNum.randomCommon(0, tempGoodsList.size()+1, size);

			for(int i=0;i<size;i++)
			{
				goodsList.add(tempGoodsList.get(randomNo[i]-1));
			}
			ObjectMapper om=new ObjectMapper();
			om.writeValue(response.getOutputStream(),goodsList);
			return null;
		}
	
	//��ȡ�������Ʒ
	public String getLatelyGoodsList() throws Exception
	{
		String sql="from Goods order by createtime DESC";
		List<Goods> goodsList=goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
	//��ȡ�����Ʒ
	public String getFreeGoodsList() throws Exception
	{
		String sql="from Goods where price='0'";
		List<Goods> goodsList=goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
	//��ȡ�����Ʒ���ӵ�n����ʼ��֮���m����Ʒ
	public String getGoodsByTimeDESC() throws Exception{
		int firstresult = Integer.valueOf(request.getParameter(FIRSTRESULT));
		int maxresult = Integer.valueOf(request.getParameter(MAXRESULT));
		System.out.println("//��ȡ�����Ʒ���ӵ�n����ʼ��֮���m����Ʒ"+"firstresult="+firstresult+"maxresult"+maxresult);
		String sql="from Goods g order by g.createtime desc";
		List<Goods> goodsList=goodsService.list(Goods.class, sql, firstresult, maxresult);
		ObjectMapper om=new ObjectMapper();
		for(Goods g:goodsList)
		{
			System.out.println(g.toString());
		}
		om.writeValue(response.getOutputStream(),goodsList);
		return null;
	}
}
