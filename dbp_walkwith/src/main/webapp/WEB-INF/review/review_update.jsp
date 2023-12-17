<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Review 업데이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/community.css' />" type="text/css">
<script>
function commModify() {
	if (form.content.value == "") {
		alert("리뷰 내용을 입력하십시오.");
		form.content.focus();
		return false;
	} 
	if (form.starscore.value == "") {
		alert("별점을 입력하십시오.");
		form.starscore.focus();
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
<form name="form" method="POST" action="<c:url value='/review/update' />">
  <input type="hidden" name="commId" value="${ReviewDTO.reviewId}"/>	  
  <table style="width: 100%">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>Review 정보 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  
	    <table class="commTable">
	  	  <tr height="40">
			<td class="commHead">Review ID</td>
			<td class="commCell">${ReviewDTO.reviewId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Store ID</td>
			<td class="commCell">${ReviewDTO.storeId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">User ID</td>
			<td class="commCell">${ReviewDTO.userId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">리뷰 내용</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="content" value="${ReviewDTO.reContent}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">별점</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="starscore" value="${ReviewDTO.starScore}">
			</td>
		  </tr>	
	    </table>
	    <br>	  
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="수정" onClick="commModify()"> &nbsp;
			<input type="button" value="목록" onClick="commList('<c:url value='/review/review_view.jsp' />')">
			</td>
		  </tr>
	    </table>
	  </td>
	</tr>
  </table>  
</form>
</body>
</html>