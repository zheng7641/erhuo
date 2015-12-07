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

import com.erhuo.bean.Goods;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class SearchAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private static final String KEYWORDS="keywords";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    private IBaseService<Goods,String> goodsService;

    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) 
    {  
        this.response=servletResponse;  
    }
    
    

    public IBaseService<Goods, String> getGoodsService() {
		return goodsService;
	}
	@Resource(name="baseService")
	public void setGoodsService(IBaseService<Goods, String> goodsService) {
		this.goodsService = goodsService;
	}

	// 搜索商品，通过keyword获取商品List
	public String searchGoods() throws Exception
    {
    	request.setCharacterEncoding("utf-8");
    	String keywords=request.getParameter(KEYWORDS);
    	System.out.println("通过关键字搜索商品，关键字为："+keywords);
    	String[] tempKeywords = keywords.split(" ");//闁俺绻冪粚鐑樼壐鐏忓棗鍙ч柨顔跨槤閸掑棗绱�
    	String sql="from Goods where ";
		for(int i=0;i<tempKeywords.length;i++)//閹峰吋甯磗ql閺屻儴顕楃拠顓炲綖
		{
			 if(i<tempKeywords.length-1)
			 {
				 sql+="(goodsname like '%"+tempKeywords[i]+"%' or typeid like '%"+tempKeywords[i]+"%') and ";
			 }
			 else
			 {
				 sql+="(goodsname like '%"+tempKeywords[i]+"%' or typeid like '%"+tempKeywords[i]+"%')";
			 }
		}
		System.out.println(sql);
		List<Goods> goodsList=goodsService.queryBySql(Goods.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),goodsList);
    	return null;
    }
}
