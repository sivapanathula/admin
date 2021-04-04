<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body bgcolor="#daeadf">
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="100%" colspan="2" valign="top"><jsp:include
					page="header.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td width="17%" align="left"><jsp:include page="menu.jsp"></jsp:include>
			</td>
			<td width="83%" valign="top">

				<form method="post" action="PermissionController">
					<table bgcolor="#ffe6e6" border="1" align="center">
						<tbody>
							<tr>
								<td>
									<button onclick="m1();">new</button>
								<td>
									<button onclick="m1();">update</button>
									<td><input type="submit" value="Select" /></td>
								</td>
							<tr>
							<td></td>
								<th>Permission Id :</th>

								<th>Permission Name :</th>
							</tr>
						</tbody>
						
						<input type="hidden" name="operation" value="permissionSelect">
						<tr>
							<th><input type="checkbox" name="" /></th>
							<th><input type="text" name="permissionId" /></th>

							<th><input type="text" name="permissionName" /></th>

						</tr>
						<c:forEach items="${List}" var="permission">
							<tr>
								<td><input type="checkbox" name="" /></td>
								<td><c:out value="${permission.permissionId }" /></td>
								<td><c:out value="${permission.permissionName }" /></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</form>
			</td>
		</tr>


		<tr>
			<td width="15%" colspan="2" valign="top"><jsp:include
					page="footer.jsp"></jsp:include></td>
		</tr>
	</table>
</body>