package com.erhuo.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.erhuo.bean.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("propertype")
public class TestAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}

	public String TestAction() throws JsonGenerationException, JsonMappingException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("a");
		User u = new User();
		u.setUserid(1);
		u.setUserimgpath("d:\\a.png");
		u.setUserintroduction("中文介绍");
		u.setUsername("aaa中文名");
		u.setUserpassword("mima");
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(response.getOutputStream(), u);
		} catch (JsonGenerationException e) {
			System.out.println("出错0");
		} catch (JsonMappingException e) {
			System.out.println("出错1");
		} catch (IOException e) {
			System.out.println("出错2");
		}
		return null;
	}

}
