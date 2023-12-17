<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Customer 업데이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/community.css' />" type="text/css">
<script>
function commModify() {
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}	
	if (form.phone.value == "") {
		alert("전화번호를 입력하십시오.");
		form.phone.focus();
		return false;
	}
	if (form.email.value == "") {
		alert("메일 주소를 입력하십시오.");
		form.email.focus();
		return false;
	}
	form.submit();
}

function commList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
<br>
<!-- Update Form  -->
<form name="form" method="POST" action="<c:url value='/user/customer_update' />">
  <input type="hidden" name="commId" value="${CustomerDTO.userId}"/>	  
  <table style="width: 100%">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>Customer 정보 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  
	    <table class="commTable">
	  	  <tr height="40">
			<td class="commHead">Customer ID</td>
			<td class="commCell">${CustomerDTO.userId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Customer 이름</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="name" value="${CustomerDTO.uName}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Customer Password</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="password" value="${CustomerDTO.uPassword}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Customer 전화번호</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="phone" value="${CustomerDTO.uPhone}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Customer E-mail</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="email" value="${CustomerDTO.uMail}">
			</td>	
		  </tr>	
	    </table>
	    <br>	  
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="수정" onClick="commModify()"> &nbsp;
			<input type="button" value="목록" onClick="commList('<c:url value='/user/customer_page.jsp' />')">
			</td>
		  </tr>
	    </table>
	  </td>
	</tr>
  </table>  
</form>
</body>
</html>