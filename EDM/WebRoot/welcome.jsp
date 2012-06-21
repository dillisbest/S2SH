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
		<div
			style="float: right; width: 200px; height: 200px; border: 1px solid black">
			<h2>
				<b>欢迎光临</b>
			</h2>
			<hr>
			Hello
			<a href=""><s:property value="user.username" />
			</a> Login successful!
			<s:actionmessage />
			<a href="index.jsp"> 返回首页 </a>
		</div>
		<center>
			<div style="width: 60%">
				hello world!
			</div>
		</center>
	</body>
</html>