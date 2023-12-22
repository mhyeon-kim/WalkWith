<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value ='/css/review_view.css' />">
    <script>
    function userCreate() {
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
    	if (form.password.value != form.password2.value) {
    		alert("비밀번호가 일치하지 않습니다.");
    		form.name.focus();
    		return false;
    	}
    	if (form.name.value == "") {
    		alert("이름을 입력하십시오.");
    		form.name.focus();
    		return false;
    	}
    	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    	if(emailExp.test(form.email.value)==false) {
    		alert("이메일 형식이 올바르지 않습니다.");
    		form.email.focus();
    		return false;
    	}
    	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
    	if(phoneExp.test(form.phone.value)==false) {
    		alert("전화번호 형식이 올바르지 않습니다.");
    		form.phone.focus();
    		return false;
    	}
    	
    	form.action = targetUri;
    	form.method="GET";		// register form 요청
    	form.submit();
    }

    </script>
</head>
<body>
    <div class="container">
        <div id="banner" class="d-flex align-items-center justify-content-center">
            <a href="<c:url value ='/home' />" id="a"><img id="banner-logo" src="<c:url value ='/img/Walkwith-logo.png' />" alt="Walkwith Logo"></a>
        </div>
        <div class="container d-flex content-container">
            <div id="right-div" class="d-flex justify-content-center align-items-center">
                <form name="form" method="POST" action="<c:url value='/customer/register'/>" class="register-form">
                <h1 class="text-center">회원가입</h1>
                    <div id="text" class="position-relative">
                        <input type="text" id="ID" name="userId" maxlength="9" placeholder="아이디" class="form-control">
                    </div>
                    <div id="text" class="position-relative">
                        <input type="password" id="uPassword" name="uPassword" placeholder="비밀번호" class="form-control">
                    </div>
                    <div id="text" class="position-relative">
                        <input type="name" id="uName" name="uName" placeholder="이름" class="form-control">
                    </div>
                    <div id="text" class="position-relative">
                        <input type="phone" id="uPhone" name="uPhone" placeholder="전화번호" class="form-control">
                    </div>
                    <div id="text" class="position-relative">
                        <input type="email" id="uMail" name="uMail" placeholder="이메일" class="form-control">
                    </div>
                    <div>
                        <label><input type="radio" name="userType" value="customer" checked> 소비자</label>
                        <label><input type="radio" name="userType" value="seller"> 사업자</label>
                    </div>                    
                    <div>
                       <input type="submit" id="btn" style=" margin-top: 25px; width: 100%;" value="회원가입" onclick="userCreate()" class="btn btn-primary"></a>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
