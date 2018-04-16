<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to this movie rating application</h1>
    <h2><a href="register.jsp">Register</a></h2>
    <h2>or</h2>
    <h2>Login : </h2>
    <form action="VerifLogin" method="GET">
        <input id="email" type="email" name="email" value="">
        <input id="password" type="password" name="pwd" value="">
        <input id="login" type="submit" value="Log In">
    </form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/scriptLogin.js"></script>
</html>