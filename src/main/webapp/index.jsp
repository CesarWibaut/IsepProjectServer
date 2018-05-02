<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome</title>
    <link rel="icon" href="http://www.isep.ipp.pt/Content/ico/favicon.ico" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body{
        	margin-top: 12%;
            width : 20%;
            text-align : center;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        button{
            margin: 2% 0;
        }

    </style>
</head>



<body class="text-center">
    <form class="form-signin">
      <%-- <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> --%>
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="email" class="form-control" placeholder="Email address" required="" autofocus="" name="email">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="password" class="form-control" placeholder="Password" required="" name="pwd"> 
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="login">Sign in</button>
      <a href="register.jsp">Register</a>
      <p class="mt-5 mb-3 text-muted">2018 - ISEP</p>
    </form>
  

</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/scriptLogin.js"></script>
</html>