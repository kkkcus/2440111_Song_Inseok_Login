<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.Test.User" %>
<%
    // 세션에서 사용자 정보 확인
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Name one genius that ain't crazy</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <script defer src="js/ie.js"></script>
</head>
<body>
<header>
    <div class="inner">
        <h1><a href="#">KANYE WEST</a></h1>
        
        <ul id="gnb">
            <li><a href="#">RECAP</a></li>
            <li><a href="#">GALLERY</a></li>
            <li><a href="#">YOUTUBE</a></li>
            <li><a href="#">COMMUNITY</a></li>
            <li><a href="#">LOCATION</a></li>
        </ul>
        
        <ul class="util">
            <li><a href="member1.html">CONTACT</a></li>
            <li><a href="#">HELP</a></li>
            <% if (user != null) { %>
                <!-- 로그인 상태일 때: 사용자 이름과 로그아웃 버튼 표시 -->
                <li><a href="#">Welcome, <%= user.getName() %></a></li>
                <li><a href="logout.jsp">LOGOUT</a></li>
            <% } else { %>
                <!-- 로그아웃 상태일 때: 로그인과 회원가입 버튼 표시 -->
                <li><a href="loginpage.html">LOGIN</a></li>
                <li><a href="register.jsp">JOIN</a></li>
            <% } %>
            <li><a href="#">SITEMAP</a></li>
        </ul>
    </div>
</header>
<!-- 나머지 HTML 코드는 그대로 유지 -->
<figure>
    <video src="img/visual.mp4" autoplay muted loop></video>
    <div class="inner">
        <h1>Name one genius that ain't crazy</h1>
        <p>The best producer in the history of hip-hop and music.<br>
           You can't be a genius without being crazy.</p>
        <a href="#">VIEW DETAIL</a>
    </div>
</figure>
<!-- 나머지 콘텐츠 -->
</body>
</html>
