<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value = '/css/login_view' />">
    <script>
    function login() {
    	if (form.userId.value == "") {
    		alert("사용자 ID를 입력하십시오.");
    		form.userId.focus();
    		return false;
    	} 
    	if (form.password.value == "") {
    		alert("비밀번호를 입력하십시오.");
    		form.password.focus();
    		return false;
    	}		
    	form.submit();
    }

    function userCreate(targetUri) {
    	form.action = targetUri;
    	form.method="GET";		// register form 요청
    	form.submit();
    }
    </script>
    <link rel="stylesheet" href="<c:url value = '/css/login_view.css' />">
</head>
<body>
    <div class="container">
        <div id="banner" class="d-flex align-items-center justify-content-center">
            <a href="<c:url value = '/home' />" id="a"><img id="banner-logo" src="<c:url value='/img/Walkwith-logo.png' />" alt="Walkwith Logo"></a>
        </div>
        <div class="container d-flex content-container">
            <div id="right-div" class="d-flex justify-content-center align-items-center">
                <form name="form" method="POST" action="/customer/login" class="login-form">
                <h1 class="text-center">로그인</h1>
                    <div id="text" class="position-relative">
                        <input type="text" id="ID" style="width: 100%;" name="userId" maxlength="9" placeholder="아이디" class="form-control">
                        <img id="img" src="<c:url value='../img/Walkwith-User-Icon.png'/>" alt="person" class="position-absolute" style="top: 10px;">
                    </div>
                    <div id="text" class="position-relative">
                        <input type="password" id="PW" style="width: 100%;" name="password" maxlength="9" placeholder="비밀번호" class="form-control">
                        <img id="img" src="<c:url value='../img/Walkwith-key-Icon.png' />" alt="lock" class="position-absolute" style="top: 10px;">
                    </div>
                     <div>
                        <label><input type="radio" name="userType" value="consumer" checked> 소비자</label>
                        <label><input type="radio" name="userType" value="seller"> 사업자</label>
                    </div>                   
                    <div>
                       <a href="<c:url value = '/user/customer' />" id="a"><input type="button" id="btn" style="margin-top: 25px; width: 100%;" value="로그인" onclick="login()" class="btn btn-primary"></a>
                       <a href="<c:url value = '/register/registerForm' />" id="a"><input type="button" id="btn" style="margin-top: 25px; width: 100%;" value="회원가입" onclick="userCreate('/user/register')" class="btn btn-secondary"></a>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>