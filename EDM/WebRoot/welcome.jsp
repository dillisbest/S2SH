<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎您</title>
</head>

<body>
<h1 align="center">Welcome</h1>
<hr color="blue" size="8"/>
<center>
<h2><b>欢迎光临</b></h2>
Login successful!<br>
Hello <s:property value="userDto.Name"/>!<s:actionmessage/>
<a href="index.jsp">
返回首页
</a>
</center>
</body>
</html>