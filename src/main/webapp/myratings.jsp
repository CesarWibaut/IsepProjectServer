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

        form.example input[type=text] {
            padding: 10px;
            font-size: 17px;
            border: 1px solid grey;
            float: left;
            width: 80%;
            background: #f1f1f1;
        }

        form.example button {
            float: left;
            width: 20%;
            padding: 10px;
            background: #dddddd;
            color: white;
            font-size: 17px;
            border: 1px solid grey;
            border-left: none;
            cursor: pointer;
        }

        form.example button:hover {
            background: #cccccc;
        }

        form.example::after {
            content: "";
            clear: both;
            display: table;
        }

        .container{
            margin-top:5%;
        }
    </style>
    <title>Menu</title>
</head>
<body class="menu">
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

    <div class="container">
  <h2>Your Ratings</h2>
  <p>Those are the movies that you rated</p>
  <table class="table">
    <thead>
      <tr>
        <th><h2>Poster Image</h2></th>
        <th><h2>Title</h2></th>
        <th><h2>Score (/10)</h2></th>
      </tr>
    </thead>
    <tbody id="listRatings">    


      <%-- <tr class="success">
        <td>Success</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr> --%>


      <%-- <tr class="danger">
        <td>Danger</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr> --%>


      <%-- <tr class="warning">
        <td>Warning</td>
        <td>Refs</td>
        <td>bo@example.com</td>
      </tr> --%>
      
    </tbody>
  </table>
</div>

<script src="js/scriptMyRatings.js"></script>
</body>
</html>