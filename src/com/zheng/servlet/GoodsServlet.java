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

import com.erhuo.bean.Goods;
import com.erhuo.interfaces.IBaseService;

public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
	private static final String GOODSID = "goodsid";
	private static final String USERID = "userid";
	private static final String TYPEID = "typeid";
	private static final String GOODSNAME = "goodsname";
	private static final String PRICE = "price";
	private static final String GOODSINTRODUCTION = "goodsintroduction";
	private static final String PLACE = "place";
	private static final String PHONE = "phone";

	IBaseService<Goods, Integer> goodsService;

	public GoodsServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		goodsService = (IBaseService) applicationContext.getBean("baseService");
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
		String typeid = unescape(request.getParameter(TYPEID));
		int userid = Integer.valueOf(request.getParameter(USERID));
		String goodsname = request.getParameter(GOODSNAME);
		String price = request.getParameter(PRICE);
		String goodsintroduction = request.getParameter(GOODSINTRODUCTION);
		Timestamp createtime = new Timestamp(new Date().getTime());
		String place = request.getParameter(PLACE);
		String phone = request.getParameter(PHONE);
		String pic[] = new String[3];// 随机生成文件名
		pic[0] = UUID.randomUUID().toString();
		pic[1] = UUID.randomUUID().toString();
		pic[2] = UUID.randomUUID().toString();

		String[] fileLastName = null;
		String[] filename = new String[3];
		fileLastName = uploadFile(request, response, pic);// 返回图片后缀
		System.out.println("图片接收完成");
		if (fileLastName == null) {// 如果图片为空
			System.out.println("图片为空");
			for (int i = 0; i < 3; i++) {
				filename[i] = "null";
			}
			Goods goods = new Goods(typeid, userid, goodsname, price, goodsintroduction, createtime, filename[0],
					filename[1], filename[2], place, phone);
			goodsService.add(goods);
			// uploadFile(request, response, pic);
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(), true);// 这里可以传个true或者不传
		} else {// 如果图片不为空
			System.out.println("图片不为空");
			for (int i = 0; i < fileLastName.length; i++) {// 循环生成图片地址
				filename[i] = "/ErHuo/image/" + pic[i] + "." + fileLastName[i];
				//System.out.println(filename[i]);
			}
			if (3 - fileLastName.length > 0) {// 如果图片数量不为3，生成“null”
				for (int i = 0; i < 3 - fileLastName.length; i++) {
					filename[fileLastName.length + i] = "null";
				}
			}
			Goods goods = new Goods(typeid, userid, goodsname, price, goodsintroduction, createtime, filename[0],
					filename[1], filename[2], place, phone);
			goodsService.add(goods);
			// uploadFile(request, response, pic);
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(), true);// 这里可以传个true或者不传
		}
	}

	/**
	 * 接受上传文件方法
	 * 
	 * @param request,response
	 * @exception ServletException,
	 *                IOException
	 * @author zheng @Time2015-10-18
	 */
	public String[] uploadFile(HttpServletRequest request, HttpServletResponse response, String[] pic)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();

		/** 上传照片保存路径 */
		String savePath = this.getServletContext().getRealPath("/image");
		System.out.println(savePath);
		// 上传时生成的临时文件保存目录
		String tempPath = this.getServletContext().getRealPath("/") + "linshi";
		// 文件扩展名数组
		String[] fileLastName = new String[3];
		int i = 0;
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}

		// 消息提示
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
			System.out.println("准备接收图片");
			List<FileItem> list = null;
			try {
				list = upload.parseRequest(request);
			} catch (Exception e) {
				System.out.println("接收报错，返回null");
				return null;
			}

			for (FileItem item : list) {
				System.out.println("接受图片开始循环");
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
					fileLastName[i] = fileExtName;
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 得到文件保存的名称
					String saveFilename = pic[i] + "." + fileExtName;
					// 得到文件的保存目录
					String realSavePath = savePath;
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(realSavePath + "/" + saveFilename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
						// + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					// item.delete();
				}
				i++;
			}
		} catch (Exception e) {
			om.writeValue(response.getOutputStream(), "失败");
			e.printStackTrace();
		}
		// om.writeValue(response.getOutputStream(), true);
		return fileLastName;
	}

	public String unescape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int l = s.length();
		int ch = -1;
		int b, sumb = 0;
		for (int i = 0, more = -1; i < l; i++) {
			/* Get next byte b from URL segment s */
			switch (ch = s.charAt(i)) {
			case '%':
				ch = s.charAt(++i);
				int hb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				ch = s.charAt(++i);
				int lb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				b = (hb << 4) | lb;
				break;
			case '+':
				b = ' ';
				break;
			default:
				b = ch;
			}
			/* Decode byte b as UTF-8, sumb collects incomplete chars */
			if ((b & 0xc0) == 0x80) { // 10xxxxxx (continuation byte)
				sumb = (sumb << 6) | (b & 0x3f); // Add 6 bits to sumb
				if (--more == 0)
					sbuf.append((char) sumb); // Add char to sbuf
			} else if ((b & 0x80) == 0x00) { // 0xxxxxxx (yields 7 bits)
				sbuf.append((char) b); // Store in sbuf
			} else if ((b & 0xe0) == 0xc0) { // 110xxxxx (yields 5 bits)
				sumb = b & 0x1f;
				more = 1; // Expect 1 more byte
			} else if ((b & 0xf0) == 0xe0) { // 1110xxxx (yields 4 bits)
				sumb = b & 0x0f;
				more = 2; // Expect 2 more bytes
			} else if ((b & 0xf8) == 0xf0) { // 11110xxx (yields 3 bits)
				sumb = b & 0x07;
				more = 3; // Expect 3 more bytes
			} else if ((b & 0xfc) == 0xf8) { // 111110xx (yields 2 bits)
				sumb = b & 0x03;
				more = 4; // Expect 4 more bytes
			} else /* if ((b & 0xfe) == 0xfc) */ { // 1111110x (yields 1 bit)
				sumb = b & 0x01;
				more = 5; // Expect 5 more bytes
			}
			/* We don't test if the UTF-8 encoding is well-formed */
		}
		return sbuf.toString();
	}
}
