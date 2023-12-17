<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>내 예약</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/css/reservation_view.css' />">
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
                    <li><a href="<c:url value='/user/customer' />" id="a">My Page</a></li>
                    <li><a href="<c:url value='/reservation/reservation_view' />" id="a">Reservation</a></li>
                    <li><a href="<c:url value='/review/review_view' />" id="a">Review</a></li>
                    <li><a href="<c:url value='/market/market_menu' />" id="a">Market</a></li>
                </ul>
            </div>
            
			<div id="right-div">
				<div id="banner">
					<img id="reser-title" src="/img/Reservation-title.png" alt="Reservation Title">
				</div>
			    <!-- 소비자 입장의 예약 내역 -->
				<div id="customer-view">
				    <table style="width: 100%">
				        <thead>
				            <tr>
				                <th width="100" align="center">예약 ID</th>
				                <th width="200" align="center">예약한 시간</th>
				                <th width="200" align="center">가게명</th>
				                <th width="100" align="center">예약 상태</th>
				            </tr>
				        </thead>
				        <tbody>
				            <tr>
				                <td>1</td>
				                <td>2023-11-30 13:00</td>
				                <td>가게1</td>
				                <td>예약 확정</td>
				            </tr>
				            <!-- 이런 식으로 다른 예약 정보를 추가할 수 있습니다 -->
				        </tbody>
				    </table>
				</div>

			
			    <!-- 가게 입장의 예약 내역 -->
			    <div id="store-view">
			        <!-- 예약 내역을 나타내는 코드를 여기에 입력 -->
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