<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
</head>
<body>
	<jsp:include page="processbar.jsp"></jsp:include>
	<h2 align="left">
		机构管理
	</h2>
	<hr  color="blue" size="4"/>
	<div align="center" style="float: left; border: 8px solid grey;">
		<s:form action="lookDepartment" method="POST" theme="simple">
    	&nbsp;ID:&nbsp;<s:textfield name="department.id" />
			<s:submit value="查看" />
		</s:form>
		<s:form action="queryDepartments" method="POST">
			<s:textfield name="department.name" label="Name" />
			<s:textfield name="department.address" label="Address" />
			<s:textfield name="department.connName" label="Conn Name" />
			<s:textfield name="department.connPhone" label="Conn Phone" />
			<s:textfield name="department.remark" label="Remark" />
			<s:submit value="查找" method="toQuery" />
			<s:submit value="查找所有" method="toGetAll" />
		</s:form>
		<pre>*查询输入框</pre>
	</div>
	<div
		style="float: right; border: 8px solid grey; min-width: 600px; height: 80%;">

		<s:property value="pageBean.pageInfo" escape="false" />

		<table style="border: 1px solid black; width: 100%;">
			<tr>
				<th>
					ID
				</th>
				<th>
					NAME
				</th>
				<th>
					ADDRESS
				</th>
				<th>
					CONNNAME
				</th>
				<th>
					CONNPHONE
				</th>
				<th>
					REMARK
				</th>
				<th>
					DEAL
				</th>
			</tr>
			<s:iterator value="departmentList">
				<tr>
					<td  style="border-top: 1px solid black;">
						<s:property value="id" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="name" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="address" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="connName" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="connPhone" />
					</td>
					<td style="border-top: 1px solid black;">
						<s:property value="remark" />
					</td>
					<td style="border-top: 1px solid black;">
						<a href="delDepartment?department.id=<s:property value="id"/>">Del</a>
						<a href="lookDepartment?department.id=<s:property value="id"/>">Modify</a>
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
		<s:form action="addDepartment" method="POST">
			<s:textfield name="department.name" label="Name" />
			<s:textfield name="department.address" label="Address" />
			<s:textfield name="department.connName" label="Conn Name" />
			<s:textfield name="department.connPhone" label="Conn Phone" />
			<s:textfield name="department.remark" label="Remark" />
			<s:submit value="添加" method="toAdd" />
			<s:submit value="更新" method="toUpdate" />
		</s:form>
		<pre>*详细信息输入框</pre>
	</div>
</body>
</html:html>
