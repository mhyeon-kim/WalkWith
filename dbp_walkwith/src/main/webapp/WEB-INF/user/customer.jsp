<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>내 정보</title>
    <style>
        @font-face {
            font-family: "museum";
            src: url("../font/museum.ttf") format("truetype");
            font-weight: normal;
        }

        @font-face {
            font-family: "ebs";
            src: url("../font/ebs.ttf") format("truetype");
            font-weight: normal;
        }

        #banner{
            height: 9rem;
            max-width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #user{
            color: #A99A8F;
            margin-left: 17px;
            font-size: 15px;
            font-family: 'ebs';
        }

        #left-div{
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

        #menu{
            list-style: none;
            color: white;
            font-size: 1.5rem;
            padding-top: 10px;
        }

        #menu > li{
            padding-bottom: 5px;
        }

        #right-div{
            background: RGB(242, 235, 226);
            width: 1200px;
            height: 670px;
            margin-left: 20px;
            border-radius: 10px;
            background-size: cover;
            padding-left: 4rem;
            padding-right: 4rem;
            padding-top: 2rem;
            padding-bottom: 1rem;
            font-family: 'ebs';
        }

        .info-head{
            background: #AC998B;
            font-size: 30px;
            font-family: 'ebs';
            color: white;
            padding-left: 15px;
            border-radius: 7px;
        }

        #right-div > a{
            color: #BAAA9C;
            display: right;
        }

        #customer-div {
            color: #AD9B8C;
            font-size: 1.5rem;
            font-family: 'ebs';
            display: flex;
            margin-bottom: 25px;
        }
        
        .ra {
            text-align: right;
            margin-top: 4px;
            color: RGB(172, 153, 139);
            margin-top: 7px;
            margin-right: 20px;
        }

        .info-menu{
            text-align: right;
            margin-right: 10px;
            display: flex;
            justify-content: center;
            font-family: 'museum', serif;
            flex-flow: column;
        }

        .info{
            margin-left: 10px;
        }

        #pet-div{
            color: #AD9B8C;
            font-size: 1.5rem;
            font-family: 'ebs';
            display: flex;
            align-items: center;
        }
        
        .store-item{
            width: 180px;
            height: 200px;
            background-size: cover;
            border-radius: 10px;
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
        <div id="banner">           
            <a href="<c:url value='/home'/>" id="a"><img id="banner-img" src="<c:url value='../img/Walkwith-logo.png' />"></a>
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
                    <li><a href="<c:url value='/user/customer' />" id="a">My Page</a></li>
                    <li><a href="<c:url value='/reservation/reservation_view' />" id="a">Reservation</a></li>
                    <li><a href="<c:url value='/review/review_view' />" id="a">Review</a></li>
                    <li><a href="<c:url value='/market/market_menu' />" id="a">Market</a></li>
                </ul>
            </div>
            <div id="right-div">
                <div class="info-head">사용자 정보</div>
                <div class="ra"><a>수정</a></div>
                <div id="customer-div">   
                    <div class="info-menu"  style="margin-left: 15px;">
                        <div>이름</div>
                        <div>ID</div>
                        <div>PW</div>
                        <div>연락처</div>
                        <div>E-Mail</div>
                    </div>
                    <div class="info">
                        <div>유저</div>
                        <div>User123</div>
                        <div>********</div>
                        <div>010-1234-1234</div>
                        <div>adress@dongduk.ac.kr</div>
                    </div>
                </div>
                <div class="info-head">반려동물 정보</div>
                <div class="ra">
                    <a style="margin-right: 20px;">추가</a>
                    <a>수정</a>
                </div>
                <div id="pet-div">
                    <img class="store-item" src="../img/Walkwith-market-Image.png"></img>
                    <div class="info-menu" style="margin-left: 25px;">
                        <div>이름</div>
                        <div>나이</div>
                        <div>분류</div>
                        <div>종</div>
                    </div>
                    <div class="info">
                        <div>진돌이</div>
                        <div>1</div>
                        <div>개</div>
                        <div>진돗개</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</body>
</html>