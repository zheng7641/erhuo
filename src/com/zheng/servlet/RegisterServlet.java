package com.zheng.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erhuo.bean.User;
import com.erhuo.interfaces.IBaseService;
import com.erhuo.service.BaseService;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;

	private static final String USERID = "userid";
	private static final String USERNAME = "username";
	private static final String USERPASSWORD = "userpassword";
	private static final String SCHOOLID = "schoolid";
	private static final String NICKNAME = "nickname";
	private static final String PHONE = "phone";
	private static final String USERINTRODUCTION = "userintroduction";
	private static final String USERIMGPATH = "userimgpath";
	private static final String EMAIL = "email";

	IBaseService<User, Integer> userService;

	public RegisterServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		userService = (IBaseService) applicationContext.getBean("baseService");
	}

	/**
	 * doGet����
	 * 
	 * @param request,response
	 * @exception ServletException,
	 *                IOException
	 * @author zheng @Time2015-10-18
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * doPost����
	 * 
	 * @param request,response
	 * @exception ServletException,
	 *                IOException
	 * @author zheng @Time2015-10-18
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pic = UUID.randomUUID().toString();
		User user = new User();
		System.out.println("usernameΪ:" + request.getParameter("username"));
		user.setUsername(request.getParameter(USERNAME));
		user.setUserpassword(request.getParameter(USERPASSWORD));
		System.out.println("ѧУIDΪ��" + request.getParameter(SCHOOLID));
		user.setSchoolid(Integer.valueOf(request.getParameter(SCHOOLID)));
		user.setNickname(request.getParameter(NICKNAME));
		user.setPhone(request.getParameter(PHONE));
		user.setUserintroduction(request.getParameter(USERINTRODUCTION));
		user.setEmail(request.getParameter(EMAIL));
		user.setCreatetime(new Timestamp(new Date().getTime()));
		
		String fileName =pic+"."+uploadFile(request, response, pic);
		
		user.setUserimgpath("/ErHuo/image/"+fileName);
		userService.add(user);// userService.loadByUsername(account);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), true);
	}

	/**
	 * �����ϴ��ļ�����
	 * 
	 * @param request,response
	 * @return fileLastName �ļ���չ��
	 * @exception ServletException,
	 *                IOException
	 * @author zheng @Time2015-10-18
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public String uploadFile(HttpServletRequest request, HttpServletResponse response, String pic)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		System.out.println("����ִ��");

		/** �ϴ���Ƭ����·�� */
		String savePath = this.getServletContext().getRealPath("/image");
		// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath = this.getServletContext().getRealPath("/") + "linshi";
		//�ļ���չ��
		String fileLastName = null;
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}

		// ��Ϣ��ʾ
		System.out.println("����ִ��1");
		try {
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024 * 100);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
			// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �����ļ��ϴ�����
			/*
			 * upload.setProgressListener(new ProgressListener() { public void
			 * update(long pBytesRead, long pContentLength, int arg2) {
			 * System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���" +
			 * pBytesRead);
			 *//**
				 * �ļ���СΪ��14608,��ǰ�Ѵ���4096 �ļ���СΪ��14608,��ǰ�Ѵ���7367
				 * �ļ���СΪ��14608,��ǰ�Ѵ���11419 �ļ���СΪ��14608,��ǰ�Ѵ���14608
				 *//*
				 * } });
				 */
			System.out.println("����ִ��3");
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			/*
			 * if (!ServletFileUpload.isMultipartContent(request)) {
			 * System.out.println("����ִ��1"); return ""; }
			 */

			// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
			upload.setFileSizeMax(1024 * 1024 * 5);
			// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
			upload.setSizeMax(1024 * 1024 * 10);
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);
			System.out.println("����ִ��4");
			for (FileItem item : list) {
				System.out.println("����ִ��5");
				// ���fileitem�з�װ������ͨ�����������
				if (item.isFormField()) {
					String name = item.getFieldName();
					// �����ͨ����������ݵ�������������
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");

					/*
					 * if (name.equals("Account")) { // savePath =
					 * this.getServletContext().getRealPath( // "/Temp");
					 * savePath = "d:\\zimage"; System.out.println(savePath);
					 * account = value; }
					 */
					System.out.println(name + "=" + value);
				} else {// ���fileitem�з�װ�����ϴ��ļ�
						// �õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					System.out.println(filename);
					/*
					 * if (filename == null || filename.trim().equals("")) {
					 * continue; }
					 */
					// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
					// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					// �õ��ϴ��ļ�����չ��
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
					fileLastName = fileExtName;
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					// �õ��ļ����������
					String saveFilename = pic + "." + fileExtName;
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = savePath;
					// ����һ���ļ������
					System.out.println("����ִ��5");
					FileOutputStream out = new FileOutputStream(realSavePath + "/" + saveFilename);
					System.out.println("����ִ��6");
					// ����һ��������
					byte buffer[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					System.out.println("����ִ��7");
					while ((len = in.read(buffer)) > 0) {
						System.out.println("����ִ��8");
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
						System.out.println("����ִ��9");
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
					System.out.println("����ִ��11");
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "�����ļ��������ֵ������");

		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������");

		} catch (Exception e) {
			om.writeValue(response.getOutputStream(), "ʧ��");
			e.printStackTrace();
		}
			om.writeValue(response.getOutputStream(), true);
		return fileLastName;
	}

}
