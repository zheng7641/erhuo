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
		String typeid = unescape(request.getParameter(TYPEID));
		int userid = Integer.valueOf(request.getParameter(USERID));
		String goodsname = request.getParameter(GOODSNAME);
		String price = request.getParameter(PRICE);
		String goodsintroduction = request.getParameter(GOODSINTRODUCTION);
		Timestamp createtime = new Timestamp(new Date().getTime());
		String place = request.getParameter(PLACE);
		String phone = request.getParameter(PHONE);
		String pic[] = new String[3];// ��������ļ���
		pic[0] = UUID.randomUUID().toString();
		pic[1] = UUID.randomUUID().toString();
		pic[2] = UUID.randomUUID().toString();

		String[] fileLastName = null;
		String[] filename = new String[3];
		fileLastName = uploadFile(request, response, pic);// ����ͼƬ��׺
		System.out.println("ͼƬ�������");
		if (fileLastName == null) {// ���ͼƬΪ��
			System.out.println("ͼƬΪ��");
			for (int i = 0; i < 3; i++) {
				filename[i] = "null";
			}
			Goods goods = new Goods(typeid, userid, goodsname, price, goodsintroduction, createtime, filename[0],
					filename[1], filename[2], place, phone);
			goodsService.add(goods);
			// uploadFile(request, response, pic);
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(), true);// ������Դ���true���߲���
		} else {// ���ͼƬ��Ϊ��
			System.out.println("ͼƬ��Ϊ��");
			for (int i = 0; i < fileLastName.length; i++) {// ѭ������ͼƬ��ַ
				filename[i] = "/ErHuo/image/" + pic[i] + "." + fileLastName[i];
				//System.out.println(filename[i]);
			}
			if (3 - fileLastName.length > 0) {// ���ͼƬ������Ϊ3�����ɡ�null��
				for (int i = 0; i < 3 - fileLastName.length; i++) {
					filename[fileLastName.length + i] = "null";
				}
			}
			Goods goods = new Goods(typeid, userid, goodsname, price, goodsintroduction, createtime, filename[0],
					filename[1], filename[2], place, phone);
			goodsService.add(goods);
			// uploadFile(request, response, pic);
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(), true);// ������Դ���true���߲���
		}
	}

	/**
	 * �����ϴ��ļ�����
	 * 
	 * @param request,response
	 * @exception ServletException,
	 *                IOException
	 * @author zheng @Time2015-10-18
	 */
	public String[] uploadFile(HttpServletRequest request, HttpServletResponse response, String[] pic)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();

		/** �ϴ���Ƭ����·�� */
		String savePath = this.getServletContext().getRealPath("/image");
		System.out.println(savePath);
		// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath = this.getServletContext().getRealPath("/") + "linshi";
		// �ļ���չ������
		String[] fileLastName = new String[3];
		int i = 0;
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}

		// ��Ϣ��ʾ
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
			System.out.println("׼������ͼƬ");
			List<FileItem> list = null;
			try {
				list = upload.parseRequest(request);
			} catch (Exception e) {
				System.out.println("���ձ�������null");
				return null;
			}

			for (FileItem item : list) {
				System.out.println("����ͼƬ��ʼѭ��");
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
					fileLastName[i] = fileExtName;
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					// �õ��ļ����������
					String saveFilename = pic[i] + "." + fileExtName;
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = savePath;
					// ����һ���ļ������
					FileOutputStream out = new FileOutputStream(realSavePath + "/" + saveFilename);
					// ����һ��������
					byte buffer[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while ((len = in.read(buffer)) > 0) {
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
				}
				i++;
			}
		} catch (Exception e) {
			om.writeValue(response.getOutputStream(), "ʧ��");
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
