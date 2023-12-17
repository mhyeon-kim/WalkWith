<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Market 업데이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/community.css' />" type="text/css">
<script>
function commModify() {
	if (form.name.value == "") {
		alert("가게 이름을 입력하십시오.");
		form.name.focus();
		return false;
	} 	
	if (form.phone.value == "") {
		alert("전화번호를 입력하십시오.");
		form.phone.focus();
		return false;
	}
	if (form.time.value == "") {
		alert("영업 시간을 입력하십시오.");
		form.time.focus();
		return false;
	}
	if (form.open.value == "") {
		alert("영업 요일을 입력하십시오.");
		form.open.focus();
		return false;
	}
	if (form.description.value == "") {
		alert("가게 설명을 입력하십시오.");
		form.description.focus();
		return false;
	}
	if (form.path.value == "") {
		alert("가게 이미지 경로를 입력하십시오.");
		form.path.focus();
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
<form name="form" method="POST" action="<c:url value='/market/update' />">
  <input type="hidden" name="commId" value="${StoreDTO.storeId}"/>	  
  <table style="width: 100%">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>Market 정보 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  
	    <table class="commTable">
	  	  <tr height="40">
			<td class="commHead">Seller ID</td>
			<td class="commCell">${StoreDTO.sellerId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">Store ID</td>
			<td class="commCell">${StoreDTO.storeId}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 이름</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="name" value="${StoreDTO.sName}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 번호</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="phone" value="${StoreDTO.sPhone}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">영업 시간</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="time" value="${StoreDTO.sTime}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">영업 요일</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="open" value="${StoreDTO.openDate}">
			</td>	
		  </tr>	
		  <tr height="40">
			<td class="commHead">가게 별점</td>
			<td class="commCell">${StoreDTO.sStarScore}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 설명</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="description" value="${StoreDTO.sDrescription}">
			</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 좋아요 수</td>
			<td class="commCell">${StoreDTO.likeCount}</td>
		  </tr>
		  <tr height="40">
			<td class="commHead">가게 이미지 경로</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="path" value="${StoreDTO.sImage_path}">
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