<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controller.customer.*" %>
<%
if (!CustomerSessionUtils.hasLogined(request.getSession())) {
}
%>
<!DOCTYPE html>
<html>

<head>
    <title>전체 매장</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        @font-face {
            /* 국립박물관문화재단클래식 Light 폰트 적용 */
            font-family: "museum";
            src: url("../font/museum.ttf") format("truetype");
            font-weight: normal;
        }

        @font-face {
            /* EBS 훈민정음 새론 L 애플산돌고딕 폰트 적용 */
            font-family: "ebs";
            src: url("../font/ebs.ttf") format("truetype");
            font-weight: normal;
        }

        #banner {
            height: 9rem;
            max-width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #user {
            color: #A99A8F;
            margin-left: 17px;
            font-size: 15px;
            font-family: 'ebs';
        }
        
        #sort {
            color: #756b64;
            font-size: 19px;
            font-family: 'ebs';
            
        }

        #rec {
            color: #756b64;
            font-size: 23px;
            font-family: 'ebs';
            font-weight: bold;
        }

        #left-div {
            background-image: url("../img/Walkwith-div-left.png");
            background-repeat: no-repeat;
            width: 230px;
            height: 280px;
            border-radius: 10px;
            display: flex;
            align-items: center;
            margin-top: 5px;
            font-family: 'museum', serif;
        }

        #menu {
            list-style: none;
            color: white;
            font-size: 1.5rem;
            padding-top: 10px;
        }

        #menu>li {
            padding-bottom: 5px;
        }

        #right-div {
            background-image: url("../img/walkwith-div-right.png");
            width: 1200px;
            height: auto;
            margin-left: 20px;
            border-radius: 10px;
            background-size: cover;
            padding-left: 4rem;
            padding-right: 4rem;
            padding-top: 1rem;
            padding-bottom: 1rem;
            font-family: 'ebs', serif;
        }

        #inner_div {
            align-items: center;
        }
        
        #market_div_top {
            background-image: url("../img/Walkwith-recommandedStore.png");
            background-size: cover;
            border-radius: 10px;
            margin-bottom: 3%;
            align-items: center;
            width: 100%;
        }
        #market_div {
            align-items: center;
            width: 100%;
            margin-bottom: 3%;
        }

        #market_token_top {
            width: 19%;
            padding-top: 2%;
            padding-bottom: 1%;
        }
        
        #market_token {
            width: 19%;
        }
		
		#a{
            text-decoration: none;
            color: #FFFFFF;
        }
        
        #login {
        	text-decoration: none;
            color: #816959;
            float: right;
            font-family: 'ebs', serif;
            font-size: 20px;
        }
        
    </style>
</head>

<body>
    <div class="container">
        <<div id="banner">           
            <a href="<c:url value='/home'/>" id="a"><img id="banner-img" src="<c:url value='../img/Walkwith-logo.png' />"></a>
        </div>
        <div>
        	<a href="<c:url value='/login/loginForm' />" id="login"><span>로그인 하기 ></span></a>
        </div>
        <div id="user">
            <span>Pet과 함께하는 User님</span>
        </div>
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
            <div id="rec">
                <span>추천 매장</span>
            </div>
              <%-- 
            <div id="market_div_top" align="center">
            	<c:forEach var="store" items="${storeList}">
            	<a href="<c:url value='/market/market.jsp' /> id="a">
            		<img id="market_token_top" src="<c:url value='${store.sImage_path}'/>" />
            	</a>
            	</c:forEach>
            
            </div>
			--%>
			<%-- 
				01. marketController 구현
				02. marketManager 구현
				03. marketController <- store 객체로 storeId 받아오기 // 위쪽 <% %> 태그에 구현
				04. 실행되는지 확인
			 --%>
            <div id="market_div_top" align="center">
  				<a id="a" href="<c:url value='/market/market' />"><img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />"></a>
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">                    
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
			</div> 
            
            <div id="market_div" align="center">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">                    
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
            </div>
            <div id="market_div" align="center">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">                    
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
                <img id="market_token" src="<c:url value='/img/Walkwith-marketToken.png' />">
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</html>