package com.erhuo.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.erhuo.bean.School;
import com.erhuo.bean.User;
import com.erhuo.interfaces.IBaseService;
import com.erhuo.interfaces.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	IBaseService<School, Integer> baseService;
	IUserService<User, Integer> userService;
	User user;

	private static final String USERID = "userid";
	private static final String USERNAME = "username";
	private static final String USERPASSWORD = "userpassword";
	private static final String SCHOOLID = "schoolid";
	private static final String NICKNAME = "nickname";
	private static final String PHONE = "phone";
	private static final String USERINTRODUCTION = "userintroduction";
	private static final String USERIMGPATH = "userimgpath";
	private static final String EMAIL = "email";

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

	@Resource
	public void setUser(User user) {
		this.user = user;
	}

	@Resource
	public void setBaseService(IBaseService<School, Integer> baseService) {
		this.baseService = baseService;
	}

	/**
	 * 用户注册
	 * 
	 * @param  
	 * 			用户全部信息
	 * @return 
	 * 			true 登陆成功
	 * 			false 登陆失败
	 * @exception Exception
	 * @author zheng @Time2015-10-16
	 */
	public String register() throws Exception {
		request.setCharacterEncoding("utf-8");

		user.setUsername(request.getParameter(USERNAME).toLowerCase());
		user.setUserpassword(request.getParameter(USERPASSWORD));
		user.setSchoolid(Integer.valueOf(request.getParameter(SCHOOLID)));
		user.setNickname(request.getParameter(NICKNAME));
		user.setPhone(request.getParameter(PHONE));
		user.setUserintroduction(request.getParameter(USERINTRODUCTION));
		user.setUserimgpath(request.getParameter(USERIMGPATH));
		user.setEmail(request.getParameter(EMAIL));
		user.setCreatetime(new Timestamp(new Date().getTime()));

		ObjectMapper om = new ObjectMapper();
		try {
			userService.add(user);// userService.loadByUsername(account);
		} catch (Exception e) {
			om.writeValue(response.getOutputStream(),false);
			return null;
		}
		om.writeValue(response.getOutputStream(),true);
		return null;
	}

}
