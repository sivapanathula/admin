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

					<table align="center">
						<tr>
							<td>Permission Id :</td>
							<td><input type="text" name="permissionId"></td>
						</tr>
						<tr>
							<td>Permission Name :</td>
							<td><input type="text" name="permissionName"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="operation"
								value="permissionInsert"> <input type="reset"
								name="reset" value="Reset"></td>
							<td><input type="submit" name="submit" value="Submit"></td>
						</tr>

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
</html>
