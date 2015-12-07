package com.erhuo.action;

import java.sql.Timestamp;
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

import com.erhuo.bean.GoodsMessage;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GoodsMessageAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final String GOODSMESSAGEID="goodsmessageid";
	private static final String GOODSID="goodsid";
	private static final String WRITEUSER="writeuser";
	private static final String MESSAGE="message";
	private static final String FIRSTRESULT = "firstresult";
	private static final String MAXRESULT = "maxresult";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<GoodsMessage,Integer> goodsMessageService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<GoodsMessage, Integer> getGoodsMessageService() {
		return goodsMessageService;
	}
	@Resource(name="baseService")
	public void setGoodsMessageService(
			IBaseService<GoodsMessage, Integer> goodsMessageService) {
		this.goodsMessageService = goodsMessageService;
	}
	//发布商品评论
	public String publishGoodsMessage() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int goodsid=Integer.valueOf(request.getParameter(GOODSID));
		int writeuser=Integer.valueOf(request.getParameter(WRITEUSER));
		String message=request.getParameter(MESSAGE);
		Timestamp createtime=new Timestamp(new Date().getTime());
		GoodsMessage goodsMessage=new GoodsMessage(goodsid,writeuser,message,createtime);
		goodsMessageService.add(goodsMessage);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//这里可以传个true或者不传
		return null;
	}
	//利用商品Id获取指定条商品评论List
	public String getGoodsMessageListByGoodsidDESC() throws Exception
	{
		//request.setCharacterEncoding("utf-8");
		int goodsid=Integer.valueOf(request.getParameter(GOODSID));
		int firstresult = Integer.valueOf(request.getParameter(FIRSTRESULT));
		int maxresult = Integer.valueOf(request.getParameter(MAXRESULT));
		String sql="from GoodsMessage goodsid="+goodsid+"order by createtime DESC";
		List<GoodsMessage> goodsMessageList=goodsMessageService.list(GoodsMessage.class, sql, firstresult, maxresult);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsMessageList);
		return null;
	}
	
	//利用商品Id获取商品评论List
		public String getGoodsMessageListByGoodsid() throws Exception
		{
			//request.setCharacterEncoding("utf-8");
			System.out.println("利用商品Id获取商品评论List"+request.getParameter(GOODSID));
			int goodsid=Integer.valueOf(request.getParameter(GOODSID));
			String sql="from GoodsMessage where goodsid="+goodsid;
			List<GoodsMessage> goodsMessageList=goodsMessageService.queryBySql(GoodsMessage.class, sql);
			ObjectMapper om=new ObjectMapper();
			om.writeValue(response.getOutputStream(),goodsMessageList);
			return null;
		}
	
	//删除评论
	public String delGoodsMessage() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int goodsmessageid=Integer.valueOf(request.getParameter(GOODSMESSAGEID));
		goodsMessageService.delete(GoodsMessage.class,goodsmessageid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//这里可以传个true或者不传
		return null;
	}
}
