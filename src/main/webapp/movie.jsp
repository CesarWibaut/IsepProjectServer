<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" href="http://www.isep.ipp.pt/Content/ico/favicon.ico" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .nav-tabs li a {
        color: #777;
         }
        .navbar {
        margin-bottom: 0;
        background-color: #2d2d30;
        border: 0;
        font-size: 11px !important;
        letter-spacing: 4px;
        opacity: 0.9;
        }
        .navbar li a, .navbar .navbar-brand { 
            color: #d5d5d5 !important;
        }
        .navbar-nav li a:hover {
            color: #fff !important;
        }
        .navbar-nav li.active a {
            color: #fff !important;
            background-color: #29292c !important;
        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
        }
        .open .dropdown-toggle {
            color: #fff;
            background-color: #555 !important;
        }
        .dropdown-menu li a {
            color: #000 !important;
        }
        .dropdown-menu li a:hover {
            background-color: #e81f3f; !important;
        }
        * {
            box-sizing: border-box;
        }
        .jumbotron{
            margin-top:2%;
            background : gray;
            background-size:     cover;                      /* <------ */
            background-repeat:   no-repeat;
            background-position: center center; 
            height: 1000px; 
            color:white;
        }
        .jumbotron p{
            font-size : 20px;
        }
        .jumbotron img{
            margin: 4%;
        }

    </style>
    <title>Menu</title>
</head>
<body class="menu" id=<%= request.getParameter("id") %>>
    <%
        if(session.getAttribute("firstname")==null){
            response.sendRedirect("index.jsp");
        }
    %>
   <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span> 
        </button>
        <a class="navbar-brand" href="menu.jsp"><%= session.getAttribute("firstname") %></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#home">OUR RECOMANDATIONS FOR YOU</a></li>
            <li><a href="myratings.jsp">MY RATINGS</a></li>
            <li><a href="#contact">CONTACT</a></li>
            <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="Disconnect">Disconnect</a></li> 
            </ul>
            </li>
        </ul>
        </div>
    </div>
    </nav>
    <div class="jumbotron text-center">
        <h1></h1>
        <img src=""></img>
        <p></p>
    </div>

    <div class="text-center">
        <h1> Rate that movie : </h1>
        <form class="form-inline" action="Ratings" method="POST">
            <select id="rateselect" name="score">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
            <p>/10</p>
            <input type="hidden" value="" name="fid" id="fid">
            <input type="submit" value="Submit" id="rating">
        </form>
    </div>
    <script src="js/scriptMovie.js"></script>
</body>
</html>