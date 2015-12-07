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

import com.erhuo.bean.Banner;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class BannerAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private HttpServletRequest request;  
    private HttpServletResponse response;
    IBaseService<Banner,Integer> bannerService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<Banner, Integer> getBannerService() {
		return bannerService;
	}
	@Resource(name="baseService")
	public void setBannerService(IBaseService<Banner, Integer> bannerService) {
		this.bannerService = bannerService;
	}
	
	public String getBanner()throws Exception
	{
		List<Banner> bannerList=bannerService.list(Banner.class);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),bannerList);
		return null;
	}
    
    
}
