<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<center>
	<div style="width:60% ;border:2px solid silver;background-color:silver;" >
	<s:form action="toRegister" method="POST">
<h1>REGISTER</h1><br>
		<s:actionerror />
		<br />
 
		<s:textfield name="user.email" label="Email"/>
		<s:textfield name="user.username" label="LoginName" />
		<s:password name="user.password" label="Password" />
		<s:submit value="Register" align="center"/>
	</s:form>
	</div>
	</center>
</body>