<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
</head>
<body>
	<jsp:include page="processbar.jsp"></jsp:include>
	<h2 align="left"  >
		用户管理
	</h2>
	<hr  color="blue" size="4"/>
	<div style="float: left; border: 8px solid grey; width: 250px;">
		<s:form action="lookUser" method="POST" theme="simple">
    	&nbsp;ID:&nbsp;<s:textfield name="user.id" />
			<s:submit value="查看" />
		</s:form>
		<s:form action="queryUsers" method="POST">
			<s:textfield name="user.email" label="Email" />
			<s:textfield name="user.username" label="LoginName" />
			<s:password name="user.password" label="Password" />
			<s:select name="user.department.id" label="Department"
			list="departmentList" listKey="id"  listValue="name" 
			headerKey="0" headerValue="--请选择机构--"></s:select>
			<s:submit value="查找" method="toQuery" />
			<s:submit value="查找所有" method="toGetAll" />
		</s:form>
		<pre>*查询输入框</pre>
	</div>
	<div style="float: right; border: 8px solid grey; min-width: 600px; height: 80%;">

		<s:property value="pageBean.pageInfo" escape="false" />

		<table align="center" style="border: 1px solid black; width: 100%;">
			<tr>
				<th>
					ID
				</th>
				<th>
					NAME
				</th>
				<th>
					DEPARTMENT
				</th>
				<th>
					EMAIL
				</th>
				<th>
					DEAL
				</th>
			</tr>
			<s:iterator value="userList">
				<tr>
					<td style="border-top: 1px solid black;">
						<s:property value="id" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="username" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="department.name" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="email" />
					</td>
					<td style="border-top: 1px solid black;">
						<a href="delUser?user.id=<s:property value="id"/>">Del</a>
						<a href="lookUser?user.id=<s:property value="id"/>">Modify</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<pre>
			 1.列表显示查询或所有的数据信息
			 2.点击DEAL栏目的"Modify"进行修改，
			 3.点击"Del"进行删除操作</pre>
	</div>

	<div style="float: left; border: 8px solid grey;">

		<s:form action="addUser" method="POST">
			<s:textfield name="user.email" label="Email" />
			<s:textfield name="user.username" label="LoginName" />
			<s:password name="user.password" label="Password" />
			<s:select name="user.department.id" label="Department"
			list="departmentList" listKey="id"  listValue="name" 
			headerKey="0" headerValue="--请选择机构--"></s:select>
			<s:submit value="添加" method="toAdd" />
			<s:submit value="更新" method="toUpdate" />
		</s:form>
		<pre>*详细信息输入框</pre>
	</div>
</body>
</html:html>
