<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="theme.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<script src="js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript" src="js/bootstrap"></script>
<script type="text/javascript" src="js/bootstrap.min"></script>
<script type="text/javascript" src="js/npm"></script>
<style type="text/css">
  .form-control{
    margin: 5px;
  }
.table{
  margin: 50px 50px 50px 300px;
}
.tb{
  margin: 0px 0px 0px 150px;
  font-size: 1.6em;
  color: blue;
  font-weight: bold;
}
</style>
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
			
	<form method="post" action="UserController">
    <div class="table">
      <table class="col-md-6">
      <caption class="tb">Please fill the form properly</caption>
        <tr>
          <td class="col-md-3">First Name :</td>
          <td><input  class="form-control col-md-2"  type="text" name="firstName" placeholder="First Name"></td>
        </tr>
        <tr>
          <td class="col-md-3">Last Name :</td>
          <td><input class="form-control" placeholder="Last Name" type="text" name="lastName" required></td>
        </tr>
        <tr>
          <td class="col-md-3">Email Id :</td>
          <td><input  class="form-control" type="text" name="emailId" placeholder="Email Id"></td>
        </tr>
        <tr>
          <td class="col-md-3">Mobile Number :</td>
          <td><input  class="form-control" type="text" name="mobileNumber" placeholder="Mobile Number"></td>
        </tr>
        <tr>
          <td class="col-md-3">Password :</td>
          <td><input  class="form-control" type="password" name="password" placeholder="password"></td>
        </tr>
        <tr>
          <td class="col-md-3">Date of Birth :</td>
          <td><input  class="form-control" type="text" name="dateOfBirth" placeholder=Date of Birth></td>
        </tr>
        <tr>
          <td class="col-md-3">Gender :</td>
          <td>
            <label>Male</label>&nbsp;&nbsp;<input type="radio" name="gender" value="male">&nbsp;&nbsp;
           <label>Female</label>&nbsp;&nbsp;<input type="radio" name="gender" value="female">&nbsp;&nbsp;
            <label>Other</label>&nbsp;&nbsp;<input type="radio" name="gender" value="other">
          </td>
        </tr>
        <tr>
          <td></td>
          <td><input type="hidden" name="operation" value="userInsert">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="btn btn-success" type="reset" name="reset" value="Reset">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input class="btn btn-primary" type="submit" name="submit" value="Submit"></td>
        </tr>

      </table>
      </div>
    </form>

<tr>
			<td width="15%" colspan="2" valign="top"><jsp:include
					page="footer.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>