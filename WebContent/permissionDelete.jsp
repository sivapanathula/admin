  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Sign-in User</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<script src="js/ie8-responsive-file-warning.js"></script>
<script src="js/ie-emulation-modes-warning.js"></script>

<style type="text/css">
.container {
	margin: 50px 50px 50px 50px;
}

.form-control {
	margin: 5px;
}
</style>
</head>
<body bgcolor="#daeadf">
	<table border="1" cellpadding="0" cellspacing="0" width="100%"
		bgcolor="">
		<tr>
			<td width="100%" colspan="2" valign="top"><jsp:include
					page="header.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td width="25%" align="left"><jsp:include page="menu.jsp"></jsp:include>
			</td>
			<td width="75%" valign="top">
				<div class="container">
					<div class="col-md-5">


						<form method="post" action="PermissionController">
							<div class="list-group">
								<h2 class="form-heading">Permission Delete...</h2>
							
								Permission Id : <input type="text" name="permissionId"
									class="form-control" class="col-md-2" placeholder="Permission Id"> <input
									type="hidden" name="operation" value="permissionDelete">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									class="btn btn-success" type="reset" name="reset" value="Reset">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="btn btn-primary" type="submit" name="submit"
									value="Submit">
							</div>
						</form>
					</div>
				</div>

			</td>
		</tr>
	</table>

	<tr>
		<td width="100%" colspan="2" valign="top"><jsp:include
				page="footer.jsp"></jsp:include></td>
	</tr>
</body>
</html>