<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<center>
	<div style="width:60% ;border:2px solid silver;background-color:silver;" >
	<a style="float:right;" href="register.jsp">Register&nbsp;</a>
	<s:form action="toLogin" method="POST">
<h1>LOGIN</h1><br>
		<s:actionerror />
		<br />
 
		<s:textfield name="user.email" label="Email"/>
		<s:textfield name="user.username" label="LoginName" />
		<s:password name="user.password" label="Password" />
		<s:submit value="Login" align="center"/>
	</s:form>
	</div>
	</center>
</body>