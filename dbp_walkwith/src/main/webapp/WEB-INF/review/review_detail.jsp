<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>내 리뷰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/review_view.css">
</head>

<body>
    <div class="container">
        <div id="banner">
            <a href="../home/home.jsp" id="a"><img id="banner-img" src="<c:url value='/Walkwith-logo.png' />"></a>
        </div>
        <div>
        	<a href="../login/loginForm.jsp" id="login"><span>로그인 하기 ></span></a>
        </div>
        <div id="user">
            <span>Pet과 함께하는 User님</span>
        </div>
        <div class="container content-container">
            <div id="left-div">
                <ul id="menu">
                    <li><a href="../home/home.jsp" id="a">Home</a></li>
					<li><a href="../user/customer.jsp" id="a">My Page</a></li>
					<li><a href="../reservation/reservation_view.jsp" id="a">Reservation</a></li>
					<li><a href="./review_view.jsp" id="a">Review</a></li>
					<li><a href="../market/market_menu.jsp" id="a">Market</a></li>
                </ul>
            </div>
            
			<div id="right-div">
				<div id="banner">
					<img id="reser-title" src="<c:url value='/img/ReviewTitle.png' />" alt="Reservation Title">
				</div>
				<div id="review-list">		
				    <li>가게 이름</li>
				    <li>유저 아이디</li>
				    <li>리뷰 내용</li>
				    <li>별점</li>
				</div>
			</div>
                    
                    <div id="sr-third"></div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>