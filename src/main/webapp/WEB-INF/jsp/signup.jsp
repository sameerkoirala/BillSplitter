<%--
  Created by IntelliJ IDEA.
  User: diwakar
  Date: 1/8/20
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Elegant Account Login Form with Avatar Icon</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/Login.css" rel="stylesheet">
</head>
<body>
<div class="login-form">
    <form:form method="post" action="/registeruser" modelAttribute = "newuser">
        <div class="avatar"><i class="material-icons">&#xE7FF;</i></div>
        <h4 class="modal-title">Register Your Details</h4>
        <div class="form-group">
        <form:input type="text" path="fullName"  class="form-control validate" placeholder="Full Name"/>
        </div>
        <div class="form-group">
            <form:input path="phoneNumber" type="text"  class="form-control validate" placeholder="Phone Number"/>
        </div>
        <div class="form-group">
            <form:input path="userName" type="text"  class="form-control validate" placeholder="Username"/>
        </div>
         <div class="form-group">
            <form:input path="password" type="password"  class="form-control validate" placeholder="Password"/>
        </div>

        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Sign up">

</form:form>
    <div class="text-center small">Do have an account? <a href="/Login">Login </a></div>
</div>
</body>
</html>

