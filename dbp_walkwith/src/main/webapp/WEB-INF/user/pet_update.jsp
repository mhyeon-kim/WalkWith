<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>반려동물 정보 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/community.css' />" type="text/css">
<script>
function commCreate() {
	if (form.name.value == "") {
		alert("반려동물 이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	if (form.age.value == "") {
		alert("반려동물 나이를 입력하십시오.");
		form.name.focus();
		return false;
	} 
	if (form.category.value == "") {
		alert("반려동물 종을 입력하십시오.");
		form.category.focus();
		return false;
	}
	if (form.detail.value == "") {
		alert("반려동물 종을 입력하십시오.");
		form.detail.focus();
		return false;
	}
	if (form.neureting.value == "") {
		alert("중성화 여부를 입력하십시오.");
		form.neureting.focus();
		return false;
	}	
	if (form.image.value == "") {
		alert("사진을 입력하십시오.");
		form.image.focus();
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
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/community/create' />">
  <table style="width: 100%">
    <tr>
      <td width="20"></td>
	  <td>
	    <table>
		  <tr>
		    <td class="title">&nbsp;&nbsp;<b>펫 관리 - 수정</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
	    <br>	  	   
	    <!-- 반려동물 수정이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${creationFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    <table class="commTable">
	  	  <tr height="40">
			<td class="commHead">반려동물 이름</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="name" value="${PetDTO.pName}">
			</td>
		  </tr>
	  	  <tr height="40">
			<td class="commHead">반려동물 나이</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="age" value="${PetDTO.pAge}">
			</td>
		  </tr>	 
		  <tr height="40">
			<td class="commHead">반려동물 종</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="category" value="${PetDTO.pCategory}">
			</td>
		  </tr>	
		  <tr height="40">
			<td class="commHead">반려동물 디테일 종</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="detail" value="${PetDTO.pDetailCa}">
			</td>
		  </tr>	
		  <tr height="40">
			<td class="commHead">반려동물 중성화 여부</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="neureting" value="${PetDTO.pNeureting}">
			</td>
		  </tr>	
		  <tr height="40">
			<td class="commHead">반려동물 사진</td>
			<td class="commCell">
				<input type="text" style="width: 240" name="image" value="${PetDTO.pImage}">
			</td>
		  </tr>
	    </table>
	    <br>
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="생성" onClick="commCreate()"> &nbsp;
			<input type="button" value="유저 페이지" onClick="commList('<c:url value='/user/list' />')">
			</td>
		  </tr>
	    </table>
	  </td>
    </tr>
  </table>  
</form>
</body>
</html>