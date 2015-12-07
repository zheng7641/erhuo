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

import com.erhuo.bean.School;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class SchoolAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final String SCHOOLID="schoolid";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<School,Integer> schoolService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<School, Integer> getSchoolService() {
		return schoolService;
	}
	@Resource(name="baseService")
	public void setSchoolService(IBaseService<School, Integer> schoolService) {
		this.schoolService = schoolService;
	}
	//获取学校列表
	public String getSchoolList() throws Exception
	{
		ObjectMapper om=new ObjectMapper();
		List<School> schoolList=schoolService.list(School.class);
		om.writeValue(response.getOutputStream(),schoolList );
		return null;
	}
	//通过schoolid获取学校列表
	public String getSchoolBySchoolId() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int schoolid=Integer.valueOf(request.getParameter(SCHOOLID));
		ObjectMapper om=new ObjectMapper();
		School school=schoolService.load(School.class, schoolid);
		om.writeValue(response.getOutputStream(),school);
		return null;
	}
    
}
