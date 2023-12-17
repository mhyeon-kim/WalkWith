<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Reservation 업데이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/community.css' />" type="text/css">
<script>
function commModify() {
	if (form.date.value == "") {
		alert("예약 날짜를 입력하십시오.");
		form.date.focus();
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
<form name="form" method="POST" action="<c:url value='/reservation/update' />">
  <input type="hidden" name="commId" value="${ReservationDTO.reservationId}"/>	  
  <table style="width: 100%">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>Reservation 정보 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  
	    <table class="commTable">
	  	  <tr height="40">
			<td class="commHead">Reservation ID</td>
			<td class="commCell">${ReservationDTO.reservationId}</td>
		  </tr>
			<tr height="40">
			<td class="commHead">예약 날짜</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="date" value="${ReservationDTO.resDaTi}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">예약자 ID</td>
			<td class="commCell">${ReservationDTO.userId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">예약자 성함</td>
			<td class="commCell">${ReservationDTO.uName}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 ID</td>
			<td class="commCell">${ReservationDTO.storeId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 이름</td>
			<td class="commCell">${ReservationDTO.sName}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">예약 요청 사항</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="comment" value="${ReservationDTO.comment}">
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