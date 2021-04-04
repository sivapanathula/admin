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

				<form method="post" action="UserController" >
					<h3>Enter Details :</h3>
					<table border="1">
						<tbody>
							<tr>
								<td>
									<input type="hidden" name="operation" value="userSelect" />
								</td>
							</tr>
							<tr>
							 	<td><input type="submit" value="select"></td>
								<td><input type="button" value="delete"></td>
								<td><a href="userUpdationForm.jsp">Update</a></td>
								<td><a href="userRegistrationForm.jsp">Registration</a></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><input type="checkbox" name="delete" />All</td>

								<td>First Name :</td>


								<td>Last Name :</td>


								<td>Email Id :</td>


								<td>Mobile Number :</td>


								<td>Password :</td>


								<td>Date of Birth :</td>


								<td>Gender :</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" name="firstName" /></td>

								<td><input type="text" name="laststName" /></td>

								<td><input type="text" name="emailId" /></td>

								<td><input type="text" name="mobileNumber" /></td>

								<td><input type="text" name="password" /></td>

								<td><input type="text" name="dateOfBirth" /></td>

								<td><input type="text" name="gender" /></td>
							</tr>
							<c:forEach var="user" items="${userList}">
								<tr>
									<td><input type="checkbox" name="" /></td>
									<td><c:out value="${user.firstName }" /></td>
									<td><c:out value="${user.lastName }" /></td>
									<td><c:out value="${user.emailId }" /></td>
									<td><c:out value="${user.mobileNumber }" /></td>
									<td><c:out value="${user.password }" /></td>
									<td><c:out value="${user.dateOfBirth }" /></td>
									<td><c:out value="${user.gender }" /></td>
								</tr>
							</c:forEach>
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