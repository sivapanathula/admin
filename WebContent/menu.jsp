<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
</head>
<body>	
	<div class="col-md-12">
          <div class="list-group">
          <div class="warning"></div>
          
            <h4 class="list-group-item active">
             List of Operation
             </h4>
          	<a href="UserController.do?operation=forward&page=userInsert.jsp" class="list-group-item">User Insert</a>
          	<a href="UserController.do?operation=forward&page=userUpdate.jsp" class="list-group-item">User Update</a>
            <a href="userInsert.jsp" class="list-group-item">User Insert</a>
            <a href="userUpdate.jsp" class="list-group-item">User Update</a>
            <a href="userDelete.jsp" class="list-group-item">User Delete</a>
            <a href="userSelect.jsp" class="list-group-item">User Select</a>
			
			<h4 class="list-group-item active">Role Operation</h4>
            <a href="roleInsert.jsp" class="list-group-item">Role Insert</a>
            <a href="roleUpdate.jsp" class="list-group-item">Role Update</a>
            <a href="roleDelete.jsp" class="list-group-item">Role Delete</a>
            <a href="roleSelect.jsp" class="list-group-item">Role Select</a>

			<h4 class="list-group-item active">Permission Operation</h4>
            <a href="permissionInsert.jsp" class="list-group-item">Permission Insert</a>
            <a href="permissionUpdate.jsp" class="list-group-item">Permission Update</a>
            <a href="permissionDelete.jsp" class="list-group-item">Permission Delete</a>
            <a href="permissionSelect.jsp" class="list-group-item">Permission Select</a>
            
          </div>
        </div>
</body>
</html>
