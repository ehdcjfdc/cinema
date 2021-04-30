<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%    
    String theater = request.getParameter("theater");
	String time = request.getParameter("time");
	String seatr = request.getParameter("seatr");
	String seatc = request.getParameter("seatc");
	
%>
<c:set var="theater" value="<%=theater%>"/>
<c:set var="time" value="<%=time%>"/>
<c:set var="seatr" value="<%=seatr%>"/>
<c:set var="seatc" value="<%=seatc%>"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
 
$(document).ready(function(){
    getAppDetail();        
});
/** 게시판 - 상세 조회  */

	function getAppDetail() {
		$.ajax({

			url : "/getfilmApp",
			data : $("#filmForm").serialize(),
			dataType : "JSON",
			cache : false,
			async : true,
			type : "POST",
			success : function(obj) {
				getAppDetailCallback(obj);
			},
			error : function(xhr, status, error) {
			}

		});
	}

	/** 예약 좌석 보기 콜벡 함수 */
	function getAppDetailCallback(obj) {
		var sr = $("#seatr").val();
		var sc = $("#seatc").val();
		var time = $("#time").val();
		var str = "";
		var listLen = obj.length;
		for(var r = 0;r<sr;r++){
			str +="<tr>";
			for(var c = 0;c<sc;c++){
				str += "<td><button type='button'>"+r+","+c+"</button></td>"
			}
			str +="</tr>";
		}

		$("#tbody").html(str);
	}
</script>
</head>
<body>
	<div class="inner">
		<h2>SCREEN</h2>
		<form id="filmForm" name="filmForm">
			<table width="100%" class="table01">
				<thead>
					<tr>
						<th>SCREEN</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<input type="hidden" id="theater" name="theaterNum" value="${theater}" /> 
			<input type="hidden" id="time" name="time" value="${time}" />
		</form>
		<input type="hidden" id="seatr" name = "seatr" value="${seatr}" />
		<input type="hidden" id="seatc" name = "seatc" value="${seatc}" />
		<div class="btn_right mt15">
			<button type="button" class="btn black mr5">예매하기</button>
		</div>
	</div>
</body>
</html>