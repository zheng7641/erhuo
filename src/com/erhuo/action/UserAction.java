package com.erhuo.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.erhuo.bean.User;
import com.erhuo.interfaces.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final String USERID="userid";
	private static final String USERIMGPATH="userimgpath";
	private static final String SCHOOLID="schoolid";
	private static final String NICKNAME="nickname";
	private static final String PHONE="phone";
	private static final String USERINTRODUCTION="userintroduction";
	private static final String EMAIL="email";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    IUserService<User,Integer> userService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IUserService<User, Integer> getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(IUserService<User, Integer> userService) {
		this.userService = userService;
	}
    //通过userid获取user详细信息
	public String getUser() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		User user=userService.load(User.class, userid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),user);
		return null;
	}
	//修改头像
	public String updateFace() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		String userimgpath=request.getParameter(USERIMGPATH);
		User user=userService.load(User.class, userid);
		user.setUserimgpath(userimgpath);
		userService.update(user);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);
		return null;
	}
	//完善和修改个人信息
	public String pefectInfo() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		int schoolid=Integer.valueOf(request.getParameter(SCHOOLID));
		String nickname=request.getParameter(NICKNAME);
		String phone=request.getParameter(PHONE);
		String userintroduction=request.getParameter(USERINTRODUCTION);
		String email=request.getParameter(EMAIL);
		Timestamp createtime=new Timestamp(new Date().getTime());
		User user=userService.load(User.class, userid);
		user.setSchoolid(schoolid);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setUserintroduction(userintroduction);
		user.setEmail(email);
		user.setCreatetime(createtime);
		userService.update(user);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);
		return null;
	}
    
}
