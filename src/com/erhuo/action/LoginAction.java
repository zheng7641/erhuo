package com.erhuo.action;

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
@Controller
@Scope("propertype")
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final String USERNAME = "username";
	private static final String USERPASSWORD = "userpassword";

	private HttpServletRequest request;
	private HttpServletResponse response;

	IUserService<User, Integer> userService;

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}

	public IUserService<User, Integer> getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(IUserService<User, Integer> userService) {
		this.userService = userService;
	}

	/**
	 * 用户登陆
	 * 
	 * @param  username	用户名
	 * @return  false 登陆失败 
	 * 			true 登陆成功
	 * @exception Exception
	 * @author zheng @Time2015-10-16
	 */
	public String login() throws Exception {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter(USERNAME);
		System.out.println("获取到的用户账号为："+username);
		String userpassword = request.getParameter(USERPASSWORD);
		System.out.println("获取到的用户密码为："+userpassword);
		ObjectMapper om = new ObjectMapper();
		User user = new User();
		try{
			user = (User) userService.loadByUsername(username).get(0);
		} catch(Exception e){
			System.out.println("用户登录执行失败");
			om.writeValue(response.getOutputStream(),false);
			return null;
		}
		if(user.getUserpassword().equals(userpassword)){
			om.writeValue(response.getOutputStream(), user);
		}else{
			om.writeValue(response.getOutputStream(), false);
		}
		return null;
	}

}
