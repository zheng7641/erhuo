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

import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class GoodsTypeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final String TYPEID="typeid";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<GoodsTypeAction,Integer> goodsTypeService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<GoodsTypeAction, Integer> getGoodsTypeService() {
		return goodsTypeService;
	}
	@Resource(name="baseService")
	public void setGoodsTypeService(
			IBaseService<GoodsTypeAction, Integer> goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	} 
	//获取所有商品类型
	public String getGoodsTypeList() throws Exception
	{
		ObjectMapper om=new ObjectMapper();
		List<GoodsTypeAction> goodsTypeList=goodsTypeService.list(GoodsTypeAction.class);
		om.writeValue(response.getOutputStream(),goodsTypeList );
		return null;
	}
	//通过typeid获取商品类型
	public String getGoodsTypeByTypeId() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int typeid=Integer.valueOf(request.getParameter(TYPEID));
		ObjectMapper om=new ObjectMapper();
		GoodsTypeAction goodsType=goodsTypeService.load(GoodsTypeAction.class, typeid);
		om.writeValue(response.getOutputStream(),goodsType );
		return null;
	}
    
    

}
