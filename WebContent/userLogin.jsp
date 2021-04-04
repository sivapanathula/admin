<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="login admin">
<meta name="author" content="shaheen">
<link rel="icon" href="../../favicon.ico">

<title>Sign-in User</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery.realperson.css">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<script src="js/ie8-responsive-file-warning.js"></script>
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery.plugin.js"></script>
<script src="js/jquery.realperson.js"></script>
<script type="text/javascript">
  $(function(){
    $("#captchaField").realperson({
      length:5
    });
  });
</script>
<style type="text/css">
.container {
  margin: 100px 100px 50px 420px;
}
.form-control{
    margin: 10px 0px 10px 0px;
  }
  .body{
  background-color: #154949;
  color: #fff;
  }
</style>
</head>

<body class="body">

  <div class="container">
    <div class="col-md-4">

      <form class="form-signin" method="post" action="UserController.do">
        <h2 class="form-signin-heading">User sign in...</h2>
        <h4>Email Id : </h4>
        <input type="email" id="emailId" class="form-control "
          placeholder="Email address" required>
        <h4>Password :</h4>
        <input
          type="password" id="password" class="form-control"
          placeholder="Password" required>
        <div class="checkbox">
        <label> <input type="checkbox" value="remember-me">
            Remember me
        </label>
        </div>
        <input type="text" id="captchaField" name="captchaField" class="form-control" placeholder="Enter Captcha"/>
        <input type="hidden" name="operation" value="userLogin">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div>
  </div>

  <!-- /container -->


  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>
