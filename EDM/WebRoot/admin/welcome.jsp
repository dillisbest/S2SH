<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎您</title>
	</head>

	<body>
		<div>
			<h1 align="right">
				Welcome
			</h1>
		</div>
		<hr color="blue" size="8" />
		<div align="center""
			style="float: right; width: 180px; height: 80%;">
			<h2 align="center">
				欢迎光临
			</h2>
			<hr  color="blue" size="4" >
			Hello
			<a href=""><s:property value="user.username" /> </a> Login
			successful!
			<s:property value="returnMsg" />
			<s:actionmessage cssStyle="list-style-type:none;" />
			<div style="">
			<a href="http://localhost:8080/EDM/index.jsp"> 返回首页 </a>
			</div>
		</div>
		<div style="width: 100%;height:80%;">
			<div style="width: 180px;height:100%; float: left;">
				<iframe frameborder="0" width="100%" height="100%" src="nav.jsp" name="nav"></iframe>
			</div>
			<div style="height: 60%;height:100%;">
				<iframe frameborder="0" width="100%" height="100%" src="content.jsp" name="main"></iframe>
			</div>
		</div>
		<hr color="blue" size="8" />
		<div align="right">
			@
			<a href="http://www.dusong.org">Dusong.org</a>
		</div>
	</body>
</html>