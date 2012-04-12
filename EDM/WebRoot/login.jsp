<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<s:form action="doLogin" method="POST">
Login<br>
		<s:actionerror />
		<br />
		<s:textfield name="user.username" label="LoginName" />
		<s:password name="user.password" label="Password" />
		<s:submit value="login" align="center" />
	</s:form>
</body>