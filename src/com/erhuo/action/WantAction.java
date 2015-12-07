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

import com.erhuo.bean.Want;
import com.erhuo.interfaces.IBaseService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("propertype")
public class WantAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final String WANTID="wantid";
	private static final String USERID="userid";
	private static final String TITLE="title";
	private static final String WANTINTRODUCTION="wantIntroduction";
	
	private HttpServletRequest request;  
    private HttpServletResponse response;
    
    IBaseService<Want,Integer> wantService;
    
    public void setServletRequest(HttpServletRequest servletRequest) 
    {  
        this.request=servletRequest;          
    }  
  
    public void setServletResponse(HttpServletResponse servletResponse) {  
        this.response=servletResponse;  
    }

	public IBaseService<Want, Integer> getWantService() {
		return wantService;
	}
	@Resource(name="baseService")
	public void setWantService(IBaseService<Want, Integer> wantService) {
		this.wantService = wantService;
	}
	//��ȡ�������б�
	public String getWantList() throws Exception
	{
		System.out.println("��ȡ�������б�");
		ObjectMapper om=new ObjectMapper();
		List<Want> wantList=wantService.list(Want.class);
		om.writeValue(response.getOutputStream(),wantList );
		return null;
	}
	//��ȡĳ�����б�
	public String getWantListByUserid() throws Exception{
		request.setCharacterEncoding("utf-8");
		int userid=Integer.valueOf(request.getParameter(USERID));
		String sql="from Want where userid="+userid;
		List<Want> wantList=wantService.queryBySql(Want.class, sql);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),wantList );
		return null;
	}
	//��ȡһ������Ϣ
	public String getWantByWantId() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int wantid=Integer.valueOf(request.getParameter(WANTID));
		Want want=wantService.load(Want.class, wantid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),want);
		return null;
	}
	//��������Ϣ
	public String publishWant() throws Exception
	{
		request.setCharacterEncoding("utf-8");
	
		int userid=Integer.valueOf(request.getParameter(USERID));
		String title=request.getParameter(TITLE);
		String wantIntroduction=request.getParameter(WANTINTRODUCTION);
		Timestamp createtime=new Timestamp(new Date().getTime());
		Want want=new Want(userid,title,wantIntroduction,createtime);
		wantService.add(want);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//������Դ���true���߲���
		return null;
	}
	//ɾ������Ϣ
	public String delWant() throws Exception
	{
		request.setCharacterEncoding("utf-8");
		int wantid=Integer.valueOf(request.getParameter(WANTID));
		wantService.delete(Want.class, wantid);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(),true);//������Դ���true���߲���
		return null;
	}

}
