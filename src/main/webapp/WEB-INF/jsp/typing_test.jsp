<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Typing Speed Test Site</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/themes/style.css">
    <script src="${pageContext.request.contextPath}/resources/user/themes/algorithm.js" defer></script>
    <script>
        var textArray = [];
        <c:forEach var="text" items="${textArray}">
        textArray.push("${text}");
        </c:forEach>
    </script>
</head>
<body>
<div class="wrapper">
    <input type="text" class="input-field">
    <div class="content-box">
        <div class="typing-text">
            <p id="paragraph"></p>
        </div>
        <div class="content">
            <ul class="result-details">
                <li class="time">
                    <p>
                        Time Left:
                    </p>
                    <span><b>60</b>s</span>
                </li>
                <li class="mistake">
                    <p>
                        Mistakes:
                    </p>
                    <span>0</span>
                </li>
                <li class="wpm">
                    <p>
                        WPM:
                    </p>
                    <span>0</span>
                </li>
                <li class="cpm">
                    <p>
                        CPM:
                    </p>
                    <span>0</span>
                </li>
            </ul>
            <button>Try Again</button>
        </div>
    </div>
</div>
</body>
</html>
