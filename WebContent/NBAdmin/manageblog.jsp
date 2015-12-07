<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>二货后台</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/messages.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="withvernav">
	<div class="bodywrapper">
		<div class="topheader">
			<div class="left">
				<h1 class="logo">
					二.<span>货</span>
				</h1>
				<span class="slogan">后台管理系统</span>

				<div class="search">
					<form action="" method="post">
						<input type="text" name="keyword" id="keyword"
							value="Enter keyword(s)" />
						<button class="submitbutton"></button>
					</form>
				</div>
				<!--search-->

				<br clear="all" />

			</div>
			<!--left-->

			<div class="right">
				<!--<div class="notification">
                <a class="count" href="notifications.html"><span>9</span></a>
        	</div>
			-->
				<div class="userinfo">
					<img src="images/thumbs/avatar.png" alt="" /> <span>管理员</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							Change theme: <br /> <a class="default"></a> <a class="blueline"></a>
							<a class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>Juan Dela Cruz</h4>
						<span class="email">youremail@yourdomain.com</span>
						<ul>
							<li><a href="editprofile.html">Edit Profile</a></li>
							<li><a href="accountsettings.html">Account Settings</a></li>
							<li><a href="help.html">Help</a></li>
							<li><a href="index.html">Sign Out</a></li>
						</ul>
					</div>
					<!--userdata-->
				</div>
				<!--userinfodrop-->
			</div>
			<!--right-->
		</div>
		<!--topheader-->


		<div class="header">
			<ul class="headermenu">
				<li><a href="dashboard.jsp"><span
						class="icon icon-flatscreen"></span>首页</a></li>
				<li><a href="manageblog.jsp"><span class="icon icon-pencil"></span>后台管理</a></li>
				<li class="current"><a href="messages.jsp"><span
						class="icon icon-message"></span>反馈信息</a></li>
				<li><a href="reports.jsp"><span class="icon icon-chart"></span>统计报表</a></li>
			</ul>

			<div class="headerwidget">
				<div class="earnings">
					<div class="one_half">
						<h4>总浏览量</h4>
						<h2>237</h2>
					</div>
					<!--one_half-->
					<div class="one_half last alignright">
						<h4>今日浏览量</h4>
						<h2>31</h2>
					</div>
					<!--one_half last-->
				</div>
				<!--earnings-->
			</div>
			<!--headerwidget-->

		</div>
		<!--header-->

		<div class="vernav2 iconmenu">
			<ul>
				<li><a href="#formsub" class="editor">表单提交</a> <span
					class="arrow"></span>
					<ul id="formsub">
						<li><a href="forms.html">基础表单</a></li>
						<li><a href="wizard.html">表单验证</a></li>
						<li><a href="editor.html">编辑器</a></li>
					</ul></li>
				<!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
				<li><a href="elements.html" class="elements">网页元素</a></li>
				<li><a href="widgets.html" class="widgets">网页插件</a></li>
				<li><a href="calendar.html" class="calendar">日历事件</a></li>
				<li><a href="support.html" class="support">客户支持</a></li>
				<li><a href="typography.html" class="typo">文字排版</a></li>
				<li><a href="tables.html" class="tables">数据表格</a></li>
				<li><a href="buttons.html" class="buttons">按钮 &amp; 图标</a></li>
				<li><a href="#error" class="error">错误页面</a> <span class="arrow"></span>
					<ul id="error">
						<li><a href="notfound.html">404错误页面</a></li>
						<li><a href="forbidden.html">403错误页面</a></li>
						<li><a href="internal.html">500错误页面</a></li>
						<li><a href="offline.html">503错误页面</a></li>
					</ul></li>
				<li><a href="#addons" class="addons">其他页面</a> <span
					class="arrow"></span>
					<ul id="addons">
						<li><a href="newsfeed.html">新闻订阅</a></li>
						<li><a href="profile.html">资料页面</a></li>
						<li><a href="productlist.html">产品列表</a></li>
						<li><a href="photo.html">图片视频分享</a></li>
						<li><a href="gallery.html">相册</a></li>
						<li><a href="invoice.html">购物车</a></li>
					</ul></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div class="contenttitle2">
					<h3>系统设置</h3>
				</div>
				<!--contenttitle-->

				<form class="stdform stdform2" method="post" action="">
					<p>
						<label>网站名</label> <span class="field"><input
							type="text" name="firstname" id="firstname2" class="longinput" /></span>
					</p>

					<p>
						<label>站点描述</label> <span class="field"><input
							type="text" name="lastname" id="lastname2" class="longinput" /></span>
					</p>
					<p>
						<label>功能介绍 <small>将手机端显示的功能介绍内容写在这里.</small></label> <span
							class="field"><textarea cols="80" rows="5" name="location"
								id="location2" class="longinput"></textarea></span>
					</p>
					<p>
						<label>关于我们</label> <span class="field"><input type="text"
							name="email" id="email2" class="longinput" /></span>
					</p>

					<p>
						<label>网站版权信息</label> <span class="field"><input type="text"
							name="email" id="email2" class="longinput" /></span>
					</p>




					<p class="stdformbutton">
						<button class="submit radius2">&nbsp&nbsp&nbsp提交&nbsp&nbsp&nbsp</button>
						<input type="reset" class="reset radius2" value="&nbsp&nbsp&nbsp重置&nbsp&nbsp&nbsp" />
					</p>
				</form>

				<br />

			</div>
			<!--subcontent-->

			<div id="validation" class="subcontent" style="display: none">

				<form id="form1" class="stdform" method="post" action="">
					<p>
						<label>First Name</label> <span class="field"><input
							type="text" name="firstname" id="firstname" class="longinput" /></span>
					</p>

					<p>
						<label>Last Name</label> <span class="field"><input
							type="text" name="lastname" id="lastname" class="longinput" /></span>
					</p>

					<p>
						<label>Email</label> <span class="field"><input type="text"
							name="email" id="email" class="longinput" /></span>
					</p>

					<p>
						<label>Location</label> <span class="field"><textarea
								cols="80" rows="5" name="location" class="mediuminput"
								id="location"></textarea></span>
					</p>

					<p>
						<label>Select</label> <span class="field"> <select
							name="selection" id="selection">
								<option value="">Choose One</option>
								<option value="1">Selection One</option>
								<option value="2">Selection Two</option>
								<option value="3">Selection Three</option>
								<option value="4">Selection Four</option>
						</select>
						</span>
					</p>

					<br />

					<p class="stdformbutton">
						<button class="submit radius2">Submit Button</button>
					</p>
				</form>
				<div id="compose" class="subcontent" style="display: none">&nbsp;</div>
			</div>
			<!--contentwrapper-->

		</div>
		<!--centercontent-->


	</div>
	<!--bodywrapper-->

</body>
</html>