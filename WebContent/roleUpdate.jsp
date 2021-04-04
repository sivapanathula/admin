<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>UPDATE</title>
</head>
<body bgcolor="#daeadf">
	<table border="1" cellpadding="0" cellspacing="0" width="75%"
		bgcolor="">
		<tr>
			<td width="100%" colspan="2" valign="top"><jsp:include
					page="header.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td width="17%" align="left"><jsp:include page="menu.jsp"></jsp:include>
			</td>
			<td width="83%" valign="top">



				<form method="post" action="RoleController">
					<table align="center" border="1">
						<tr>
							<td>Role Id :</td>
							<td><input type="text" name="roleId">
							</td>
						</tr>
						<tr>
							<td>Role Name :</td>
							<td><input type="text" name="roleName">
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="operation" value="roleUpdate">
								<input type="reset" name="reset" value="Reset">
							</td>
							<td><input type="submit" name="submit" value="Update">
							</td>
						</tr>
					</table>
				</form>
		</tr>

		<tr>
			<td width="15%" colspan="2" valign="top"><jsp:include
					page="footer.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>