<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home - Typing Speed Test Website</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
    </style>
</head>
<body>

<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-red w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a class="w3-bar-item w3-button w3-hide-small w3-padding-large">Yaroslav Tsvyk</a>
        <a href="${pageContext.request.contextPath}/home" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Swagger UI</a>
        <a href="${pageContext.request.contextPath}/paragraph" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Paragraphs</a>
        <a href="${pageContext.request.contextPath}/paragraph/add" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Add a paragraph</a>
        <a href="${pageContext.request.contextPath}/about" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">About</a>
        <a href="#" style="float:right" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Login</a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Swagger UI</a>
        <a href="${pageContext.request.contextPath}/paragraph" class="w3-bar-item w3-button w3-padding-large">Paragraphs</a>
        <a href="${pageContext.request.contextPath}/paragraph/add" class="w3-bar-item w3-button w3-padding-large">Add a paragraph</a>
        <a href="${pageContext.request.contextPath}/about" class="w3-bar-item w3-button w3-padding-large">About</a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large">Login</a>
    </div>
</div>

<div class="account-page">
    <div class="container">
        <div class="row">
            <div class="col-2">
                ${msg }
                <form id="LoginForm" method="post" action="${pageContext.request.contextPath }/user/process-login">
                    <input type="text" placeholder="Username" id="username" name="username">
                    <input type="password" placeholder="Password" id="password" name="password">
                    <button type="submit" class="btn">Login</button>
                    <a href="">Forgot password</a>
                    <a href="${pageContext.request.contextPath }/user/register">Register</a>
                </form>

            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
    <div class="w3-xlarge w3-padding-32">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
    &copy; 2023 - Yaroslav Tsvyk - <a href="/Privacy">Privacy</a>
</footer>

<script>
    // Used to toggle the menu on small screens when clicking on the menu button
    function myFunction() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>

</body>
</html>
