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
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/dashboard.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/plugins/excanvas.min.js"></script><![endif]-->
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
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
				<div class="userinfo">
					<img src="images/thumbs/avatar.png" alt="" /> <span>管理员</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
								class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>Juan</h4>
						<span class="email">youremail@yourdomain.com</span>
						<ul>
							<li><a href="editprofile.html">编辑资料</a></li>
							<li><a href="accountsettings.html">账号设置</a></li>
							<li><a href="help.html">帮助</a></li>
							<li><a href="index.html">退出</a></li>
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
				<li class="current"><a href="dashboard.jsp"><span
						class="icon icon-flatscreen"></span>首页</a></li>
				<li><a href="manageblog.jsp"><span
						class="icon icon-pencil"></span>后台管理</a></li>
				<li><a href="messages.jsp"><span class="icon icon-message"></span>反馈信息</a></li>
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

				<div id="updates" class="subcontent">
					<!-- notification announcement -->

					<div class="two_third dashboard_left">

						<ul class="shortcuts">
							<li><a href="manageblog.jsp" class="settings"><span>设置</span></a></li>
							<li><a href="" class="users"><span>用户</span></a></li>
							<li><a href="productlist.jsp" class="gallery"><span>商品</span></a></li>
							<li><a href="" class="events"><span>反馈</span></a></li>
							<li><a href="" class="analytics"><span>统计</span></a></li>
						</ul>

						<br clear="all" />

						<div class="contenttitle2 nomargintop">
							<h3>&nbsp&nbsp&nbsp访问概况</h3>
						</div>
						<!--contenttitle-->

						
						<!--overviewhead-->

						<br clear="all" />

						<table cellpadding="0" cellspacing="0" border="0"
							class="stdtable overviewtable">
							<colgroup>
								<col class="con0" width="20%" />
								<col class="con1" width="20%" />
								<col class="con0" width="20%" />
								<col class="con1" width="20%" />
								<col class="con0" width="20%" />
							</colgroup>
							<thead>
								<tr>
									
									<th class="head1">比率</th>
									<th class="head0">展示量</th>
									<th class="head1">唯一访问量</th>
									<th class="head0">平均访问量(分)</th>
									<th class="head0">平均访问量(天)</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									
									<td>67.3%</td>
									<td>856, 220</td>
									<td class="center">32, 012</td>
									<td class="center">20.5</td>
									<td>327</td>
								</tr>
							</tbody>
						</table>

						<br clear="all" />

						<div id="chartplace" style="height: 300px;"></div>

						<br clear="all" />

						<table cellpadding="0" cellspacing="0" border="0"
							class="stdtable stdtablecb overviewtable2">
							<colgroup>
								<col class="con0" style="width: 4%" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
							</colgroup>
							<thead>
								<tr>
									<th class="head0"><input type="checkbox" class="checkall" /></th>
									<th class="head1">Rendering engine</th>
									<th class="head0">Browser</th>
									<th class="head1">Platform(s)</th>
									<th class="head0">Engine version</th>
									<th class="head1">CSS grade</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th class="head0"><input type="checkbox" class="checkall" /></th>
									<th class="head1">Rendering engine</th>
									<th class="head0">Browser</th>
									<th class="head1">Platform(s)</th>
									<th class="head0">Engine version</th>
									<th class="head1">CSS grade</th>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td align="center"><input type="checkbox" /></td>
									<td>Trident</td>
									<td>Internet Explorer 5.5</td>
									<td>Win 95+</td>
									<td class="center">5.5</td>
									<td class="center">A</td>
								</tr>
								<tr>
									<td align="center"><input type="checkbox" /></td>
									<td>Trident</td>
									<td>Internet Explorer 6</td>
									<td>Win 98+</td>
									<td class="center">6</td>
									<td class="center">A</td>
								</tr>
								<tr>
									<td align="center"><input type="checkbox" /></td>
									<td>Trident</td>
									<td>Internet Explorer 7</td>
									<td>Win XP SP2+</td>
									<td class="center">7</td>
									<td class="center">A</td>
								</tr>
							</tbody>
						</table>

						<br />


						<!-- widgetbox -->


					</div>
					<!--two_third dashboard_left -->

					<div class="one_third last dashboard_right">

						<div class="contenttitle2 nomargintop">
							<h3>&nbsp&nbsp&nbsp&nbsp最多收藏&nbsp&nbsp&nbsp</h3>
						</div>
						<!--contenttitle-->


						<ul class="toplist">
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">商品1</a></span> <span
											class="desc">商品描述</span>
									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">81</span>
									</span> <!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">商品2</a></span> <span
											class="desc">商品描述2</span>
									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">78</span>
									</span> <!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">商品3</a></span> <span
											class="desc">商品描述3</span>
									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">75</span>
									</span> <!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
						</ul>

						<div class="widgetbox">
							<div class="title">
								<h3>后台登陆信息</h3>
							</div>
							<div class="widgetoptions">
								<div class="right">
									<a href="">View All Users</a>
								</div>
								<a href="">管理员注册</a>
							</div>
							<div class="widgetcontent userlistwidget nopadding">
								<ul>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">Squint</a> <br /> Front-End Engineer <br /> 18
											minutes ago
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">Eunice</a> <br /> Architectural Designer <br />
											18 minutes ago
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">Captain Gutt</a> <br /> Software Engineer <br />
											18 minutes ago
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">Flynn</a> <br /> Accounting Manager <br /> 18
											minutes ago
										</div> <!--info-->
									</li>
								</ul>
								<a class="more" href="">View More Users</a>
							</div>
							<!--widgetcontent-->
						</div>

						
						<!--widgetbox-->

					</div>
					<!--one_third last-->


				</div>
				<!-- #updates -->

				<div id="activities" class="subcontent" style="display: none;">
					&nbsp;</div>
				<!-- #activities -->

			</div>
			<!--contentwrapper-->

			<br clear="all" />

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>