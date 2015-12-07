package com.erhuo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.erhuo.bean.ConcernedUsers;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class ConcernedUsersAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final String CONCERNEDID ="concernedid";
	private static final String USERSELFID="userselfid";
	private static final String OTHERUSERID="otheruserid";
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<ConcernedUsers,Integer> concernedUsersService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse)
    {  
        this.response=servletResponse;  
    }

	public IBaseService<ConcernedUsers, Integer> getConcernedUsersService() {
		return concernedUsersService;
	}
	@Resource(name="baseService")
	public void setConcernedUsersService(
			IBaseService<ConcernedUsers, Integer> concernedUsersService) {
		this.concernedUsersService = concernedUsersService;
	}
	
	//通过userselfid，otheruserid添加用户关注
	public String addConcernedUsers() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userselfid=Integer.valueOf(request.getParameter(USERSELFID));
		int otheruserid=Integer.valueOf(request.getParameter(OTHERUSERID));
		ConcernedUsers concernedUsers=new ConcernedUsers(userselfid,otheruserid);
		concernedUsersService.add(concernedUsers);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);
		return null;
	}
	
	public String delConcernedUsers() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int concernedid=Integer.valueOf(request.getParameter(CONCERNEDID));
		concernedUsersService.delete(ConcernedUsers.class, concernedid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);
		return null;
	}
	
	//通过userseltif获取所关注的所有用户
	public String getConcernedUsers() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userselfid=Integer.valueOf(request.getParameter(USERSELFID));
		
		String sql="from ConcernedUsers where userselfid="+userselfid;
		List<ConcernedUsers> concernedUsers=new ArrayList<ConcernedUsers>();
		concernedUsers=concernedUsersService.queryBySql(ConcernedUsers.class, sql);
		for(ConcernedUsers c:concernedUsers)
		{
			System.out.println(c.toString());
		}
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),concernedUsers);
		return null;
	}
}
