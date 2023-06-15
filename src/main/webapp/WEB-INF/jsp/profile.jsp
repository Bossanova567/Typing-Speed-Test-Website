<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
        <a href="${pageContext.request.contextPath}/home" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Home</a>
        <a href="${pageContext.request.contextPath}/swagger-ui.html" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Swagger UI</a>
        <a href="${pageContext.request.contextPath}/paragraph" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Paragraphs</a>
        <a href="${pageContext.request.contextPath}/paragraph/add" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Add a paragraph</a>
        <a href="${pageContext.request.contextPath}/test" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Typing Speed Test</a>
        <a href="${pageContext.request.contextPath}/about" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">About</a>
        <c:if test="${pageContext.request.userPrincipal.name != null }">
            <a href="${pageContext.request.contextPath }/user/dashboard" style="float:right" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">${pageContext.request.userPrincipal.name }</a>
            <a href="${pageContext.request.contextPath }/user/process-logout" style="float:right" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null }">
            <a href="${pageContext.request.contextPath}/user-panel/login" style="float:right" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Login</a>
        </c:if>
    </div>

</div>

<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
    <div class="account-page">
        <div class="container">
            <div class="row">
                <div class="col-2">
                    ${err }
                    <s:form id="RegForm" method="post" modelAttribute="user" action="${pageContext.request.contextPath }/user/profile">
                        <p>Username</p>
                        <s:input path="username" required="required" readonly="true"/>
                        <p>Password</p>
                        <s:input path="password" required="required" onfocus="this.value=''" autocomplete="off"/>
                        <p>Email</p>
                        <s:input type="email" path="email" required="required"/>
                        <button type="submit" class="btn">Save</button>
                        <s:hidden path="id" />
                    </s:form>

                </div>
            </div>
        </div>
    </div>
</header>

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
