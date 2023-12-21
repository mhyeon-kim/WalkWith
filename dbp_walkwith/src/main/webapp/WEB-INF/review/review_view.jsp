<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>내 리뷰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/review_view.css">
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
        <div class="container content-container">
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
				<div id="banner">
					<img id="reser-title" src="<c:url value='/img/ReviewTitle.png' />" alt="Reservation Title">
				</div>
				<div id="review-list">		
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 1"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 2"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 3"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 4"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 5"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 6"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 7"></div>
				    <div class="review-list"><img src="<c:url value='img/Walkwith-marketToken.png' />" alt="review 8"></div>
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