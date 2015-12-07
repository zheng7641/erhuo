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
	 * doGet方法
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
	 * doPost方法
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
		System.out.println("username为:" + request.getParameter("username"));
		user.setUsername(request.getParameter(USERNAME));
		user.setUserpassword(request.getParameter(USERPASSWORD));
		System.out.println("学校ID为：" + request.getParameter(SCHOOLID));
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
	 * 接受上传文件方法
	 * 
	 * @param request,response
	 * @return fileLastName 文件扩展名
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
		System.out.println("方法执行");

		/** 上传照片保存路径 */
		String savePath = this.getServletContext().getRealPath("/image");
		// 上传时生成的临时文件保存目录
		String tempPath = this.getServletContext().getRealPath("/") + "linshi";
		//文件扩展名
		String fileLastName = null;
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}

		// 消息提示
		System.out.println("方法执行1");
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
			// 设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 监听文件上传进度
			/*
			 * upload.setProgressListener(new ProgressListener() { public void
			 * update(long pBytesRead, long pContentLength, int arg2) {
			 * System.out.println("文件大小为：" + pContentLength + ",当前已处理：" +
			 * pBytesRead);
			 *//**
				 * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367
				 * 文件大小为：14608,当前已处理：11419 文件大小为：14608,当前已处理：14608
				 *//*
				 * } });
				 */
			System.out.println("方法执行3");
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			/*
			 * if (!ServletFileUpload.isMultipartContent(request)) {
			 * System.out.println("错误执行1"); return ""; }
			 */

			// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
			upload.setFileSizeMax(1024 * 1024 * 5);
			// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024 * 1024 * 10);
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			System.out.println("方法执行4");
			for (FileItem item : list) {
				System.out.println("方法执行5");
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");

					/*
					 * if (name.equals("Account")) { // savePath =
					 * this.getServletContext().getRealPath( // "/Temp");
					 * savePath = "d:\\zimage"; System.out.println(savePath);
					 * account = value; }
					 */
					System.out.println(name + "=" + value);
				} else {// 如果fileitem中封装的是上传文件
						// 得到上传的文件名称，
					String filename = item.getName();
					System.out.println(filename);
					/*
					 * if (filename == null || filename.trim().equals("")) {
					 * continue; }
					 */
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
					// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					// 得到上传文件的扩展名
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
					System.out.println("上传的文件的扩展名是：" + fileExtName);
					fileLastName = fileExtName;
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 得到文件保存的名称
					String saveFilename = pic + "." + fileExtName;
					// 得到文件的保存目录
					String realSavePath = savePath;
					// 创建一个文件输出流
					System.out.println("方法执行5");
					FileOutputStream out = new FileOutputStream(realSavePath + "/" + saveFilename);
					System.out.println("方法执行6");
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					System.out.println("方法执行7");
					while ((len = in.read(buffer)) > 0) {
						System.out.println("方法执行8");
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
						// + filename)当中
						out.write(buffer, 0, len);
						System.out.println("方法执行9");
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					// item.delete();
					System.out.println("方法执行11");
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "单个文件超出最大值！！！");

		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");

		} catch (Exception e) {
			om.writeValue(response.getOutputStream(), "失败");
			e.printStackTrace();
		}
			om.writeValue(response.getOutputStream(), true);
		return fileLastName;
	}

}
