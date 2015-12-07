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
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/productlist.js"></script>
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
            <h1 class="logo">二.<span>货</span></h1>
            <span class="slogan">后台管理系统</span>
            
            <div class="search">
            	<form action="" method="post">
                	<input type="text" name="keyword" id="keyword" value="Enter keyword(s)" />
                    <button class="submitbutton"></button>
                </form>
            </div><!--search-->
            
            <br clear="all" />
            
        </div><!--left-->
        
        <div class="right">
        	<div class="notification">
                <a class="count" href="notifications.html"><span>9</span></a>
        	</div>
            <div class="userinfo">
            	<img src="images/thumbs/avatar.png" alt="" />
                <span>管理员</span>
            </div><!--userinfo-->
            
            <div class="userinfodrop">            	<div class="avatar">
                	<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	Change theme: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a class="custombg"></a>
                    </div>
                </div><!--avatar-->
<div class="userdata">
                	<h4>管理员</h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                    	<li><a href="editprofile.html">Edit Profile</a></li>
                        <li><a href="accountsettings.html">Account Settings</a></li>
                        <li><a href="amanda/help.html">Help</a></li>
                        <li><a href="index.html">Sign Out</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
        	<li><a href="dashboard.jsp"><span class="icon icon-flatscreen"></span>首页</a></li>
            <li><a href="manageblog.jsp"><span class="icon icon-pencil"></span>后台管理</a></li>
            <li><a href="messages.jsp"><span class="icon icon-message"></span>反馈信息</a></li>
            <li><a href="reports.jsp"><span class="icon icon-chart"></span>统计报表</a></li>
        </ul>
        
        <div class="headerwidget">
        	<div class="earnings">
            	<div class="one_half">
                	<h4>总浏览量</h4>
                    <h2>237</h2>
                </div><!--one_half-->
                <div class="one_half last alignright">
                	<h4>今日浏览量</h4>
                    <h2>31</h2>
                </div><!--one_half last-->
            </div><!--earnings-->
        </div><!--headerwidget-->
        
    </div><!--header-->
    
    <div class="vernav2 iconmenu">
    	<ul>
        	<li><a href="#formsub" class="editor">Forms</a>
            	<span class="arrow"></span>
            	<ul id="formsub">
               		<li><a href="forms.html">Basic Form</a></li>
                    <li><a href="wizard.html">Wizard</a></li>
                    <li><a href="editor.html">WYSIWYG</a></li>
                </ul>
            </li>
            <!--<li><a href="filemanager.html" class="gallery">File Manager</a></li>-->
            <li><a href="elements.html" class="elements">Elements</a></li>
            <li><a href="widgets.html" class="widgets">Widgets</a></li>
            <li><a href="calendar.html" class="calendar">Calendar</a></li>
            <li><a href="support.html" class="support">Customer Support</a></li>
            <li><a href="typography.html" class="typo">Typography</a></li>
            <li><a href="tables.html" class="tables">Tables</a></li>
			<li><a href="buttons.html" class="buttons">Buttons &amp; Icons</a></li>
            <li><a href="#error" class="error">Error Pages</a>
            	<span class="arrow"></span>
            	<ul id="error">
               		<li><a href="notfound.html">Page Not Found</a></li>
                    <li><a href="forbidden.html">Forbidden Page</a></li>
                    <li><a href="internal.html">Internal Server Error</a></li>
                    <li><a href="offline.html">Offline</a></li>
                </ul>
            </li>
            <li class="current"><a href="#addons" class="addons">Addons</a>
            	<span class="arrow"></span>
            	<ul id="addons">
               		<li><a href="newsfeed.html">News Feed</a></li>
                    <li><a href="profile.html">Profile Page</a></li>
                    <li class="current"><a href="productlist.html">Product List</a></li>
                    <li><a href="photo.html">Photo/Video Sharing</a></li>
                </ul>
            </li>
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
        
    <div class="centercontent">
    
        <div class="pageheader notab">
            <h1 class="pagetitle">商品列表</h1>
            <span class="pagedesc">This could be your portfolio list, product list, image list, etc.</span>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper nopadding">
         <div class="one_third last ps_sidebar">
            	<div class="ps_author">
                	<span class="thumb"><img alt="" src="images/thumbs/avatar5.png" /></span>
                </div><!--ps_author-->
                <div class="ps_authorinfo">
                	<a href="">Hiccup Haddock III</a> <br />
                    <small>Added: June 14, 2012 3:45pm</small>
                </div><!--ps_authorinfo-->
                
                <div class="viewinfo">
                	<span class="numviews"> 2,212 views</span>
                    <span class="numcomments"> 78 comments</span>
                </div><!--viewinfo-->
                
				<div class="contenttitle2">
                	<h3>More from this user</h3>
                </div><!--contenttitle-->
                
                <ul class="morephotolist">
                	<li><a href=""><img src="images/thumbs/image1.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image2.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image3.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image4.png" alt="" /></a></li>	
                </ul><!--morephotolist-->
                
                <br clear="all" />
                
				<div class="contenttitle2">
                	<h3>Related Photos</h3>
                </div><!--contenttitle-->
                
                <ul class="morephotolist">
                	<li><a href=""><img src="images/thumbs/image5.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image6.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image2.png" alt="" /></a></li>	
                    <li><a href=""><img src="images/thumbs/image1.png" alt="" /></a></li>	
                </ul><!--morephotolist-->
                
                <br clear="all" />
                
                <div class="contenttitle2">
                	<h3>Tags</h3>
                </div><!--contenttitle-->
                
                <ul class="morephotolist">
                	<li><a href="">Cat</a></li>	
                    <li><a href="">Ancient</a></li>	
                    <li><a href="">Crayon</a></li>	
                    <li><a href="">Egg</a></li>	
                </ul><!--morephotolist-->

            </div>
         <div class="prodwrapper">   
         
        	<div class="prodhead">
            	<ul class="prodhead_menu">
                    <li><a class="prev prev_disabled"></a></li>
                    <li><a class="next"></a></li>
                    <li class="right"><span class="pagenuminfo">Showing 1 - 20 of 69</span></li>
                </ul>
                <span class="clearall"></span>
            </div><!--prodhead-->
         
         	<div class="prodcontent">
            
                <ul class="prodlist">
                    <li class="one_third">
                        <div class="thumb"><a href="photo.jsp"><img src="images/kozers/thumb/0.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="photo.jsp" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="photo.jsp">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/1.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third last">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/2.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                                        <li class="one_third">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/3.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/4.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third last">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/5.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/6.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/7.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>
                    <li class="one_third last">
                        <div class="thumb"><a href=""><img src="images/kozers/thumb/8.jpg" alt="" /></a></div>
                        <div class="content">
                        	<div class="contentinner">
                            	<div>
                            		<span class="price">$15</span>
                            		<a href="" class="title">Lorem Ipsum</a>
                                </div>
                                <div class="by">By: <a href="">themepixels</a></div>
                                <p class="desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div><!--contentinner-->
                        </div><!--content-->
                    </li>

                </ul>
                
            
            </div><!--prodcontent-->
            
            <br clear="all" /><br /><br />
            
         </div><!--prodwrapper-->
            
            
             
        </div><!--contentwrapper-->
                
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>
