<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel=stylesheet href="<c:url value='/css/home.css' />" type="text/css">
    <title>홈</title>
</head>

<body>
    <div class="container">
        <div id="banner">           
            <a href="<c:url value='/home'/>" id="a"><img id="banner-img" src="<c:url value='/img/Walkwith-logo.png' />"></a>
        </div>
        <div>
        	<a href="<c:url value='/login/loginForm' />" id="login"><span>로그인 하기 ></span></a>
        </div>
        <div id="user">
                <span>Pet과 함께하는 User님</span>
        </div>
        <div class="container" style="display: flex;">
            <div id="left-div">
                <ul id="menu">
                    <li><a href="<c:url value='/home' />" id="a">Home</a></li>
                    <li><a href="<c:url value='/login/loginForm' />" id="a">My Page</a></li>
                    <li><a href="<c:url value='/reservation/reservation_view' />" id="a">Reservation</a></li>
                    <li><a href="<c:url value='/review/review_view' />" id="a">Review</a></li>
                    <li><a href="<c:url value='/market/market_menu' />" id="a">Market</a></li>
                </ul>
            </div>
            <div id="right-div">
                <img id="ad-img" src="<c:url value='/img/Walkwith-AdvertisingBanner.png' />"></img>
                <div id="store">
                    <span id="recommend">추천매장</span>
                    <a href="<c:url value='/market/market_menu' />" id="more">더 많은 매장 ></a>
                </div>
                <div id="store-list">
                    <img class="store-item" src="<c:url value='/img/Walkwith-market-Image.png' />"></img>
                    <img class="store-item" src="<c:url value='/img/Walkwith-market-Image.png' />"></img>
                    <img class="store-item" src="<c:url value='/img/Walkwith-market-Image.png' />"></img>
                    <img class="store-item" src="<c:url value='/img/Walkwith-market-Image.png' />"></img>
                    <img class="store-item" src="<c:url value='/img/Walkwith-market-Image.png' />"></img>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</body>
</html>