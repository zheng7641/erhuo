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

import com.erhuo.bean.WantMessage;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class WantMessageAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final String WANTID = "wantid";
	private static final String USERID="userid";
	private static final String MESSAGE="message";
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	IBaseService<WantMessage, Integer> wantMessageService;

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}

	public IBaseService<WantMessage, Integer> getWantMessageService() {
		return wantMessageService;
	}

	@Resource(name="baseService")
	public void setWantMessageService(IBaseService<WantMessage, Integer> wantMessageService) {
		this.wantMessageService = wantMessageService;
	}

	// ͨ��wantid��ȡ����������
	public String getWantMessageByWantid() throws Exception {
		int wantid = Integer.valueOf(request.getParameter(WANTID));
		System.out.println("��ȡ�����ۣ�ͨ������id������IDΪ��" + wantid);
		String sql = "from WantMessage where wantid = " + wantid;
		List<WantMessage> wantMessageList = wantMessageService.queryBySql(WantMessage.class, sql);
		ObjectMapper om = new ObjectMapper();
		for(WantMessage w:wantMessageList)
		{
			System.out.println(w.toString());
		}
		om.writeValue(response.getOutputStream(), wantMessageList);
		return null;
	}
	
	public String publishWantMessage() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		int wantid=Integer.valueOf(request.getParameter(WANTID));
		String message=request.getParameter(MESSAGE);
		System.out.println(userid+" "+wantid+" "+message);
		Timestamp createtime=new Timestamp(new Date().getTime());
		WantMessage wantMessage=new WantMessage();
		wantMessage.setUserid(userid);
		wantMessage.setWantid(wantid);
		wantMessage.setMessage(message);
		wantMessage.setCreatetime(createtime);
		wantMessageService.add(wantMessage);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//������Դ���true���߲���
		return null;
	}
	
}
