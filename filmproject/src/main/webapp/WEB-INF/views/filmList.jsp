<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 목록</title>
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
 
    $(document).ready(function(){    
        getBoardList();
    });        
    function getBoardList(){
 
        $.ajax({    
        
            url        :"/getfilmList",
            data    : $("#filmForm").serialize(),
            dataType:"JSON",
            cache   : false,
            async   : true,
            type    :"POST",    
            success : function(obj) {
                getfilmListCallback(obj);                
            },           
            error     : function(xhr, status, error) {}
            
         });
    }
    /**예약하기 화면 이동*/
    function moveApp(theater,time,seatr,seatc){
    	location.href = "/filmApp?theater="+theater+"&time="+time+"&seatr="+seatr+"&seatc="+seatc;
    }
    /** 게시판 - 목록 조회  콜백 함수 */
    function getfilmListCallback(obj){
        
        var list = obj;
        var listLen = obj.length;
                
        var str = "";
        if(listLen >  0){
            
            for(var a=0; a<listLen; a++){
            	var theater	=list[a].theaterNum;
            	var seatr = list[a].seat_row;
            	var seatc = list[a].seat_col;
            	var current = list[a].cur;
            	var price = list[a].price;
            	var time = list[a].time;
                str += "<tr>";
                str += "<td>"+ theater+"</td>";
                str += "<td>"+ (seatr*seatc) +"</td>";
                str += "<td>"+ current +"</td>";
                str += "<td>"+ price +"</td>";    
                str += "<td>"+ time +"</td>";
                str += "<th><button type='button' onclick = \"javascript:moveApp('"+theater+"','"+time+"','"+seatr+"','"+seatc+"');\">예매하기</button></th>"
                str += "</tr>";
                
            } 
            
        } else {
            
            str += "<tr>";
            str += "<td colspan='5'>등록된 글이 존재하지 않습니다.</td>";
            str += "<tr>";
        }
        
        $("#tbody").html(str);
    }
    
</script>
</head>
<body>
<div id="wrap">
    <div id="container">
        <div class="inner">        
            <h2>영화 목록</h2>            
            <form id="filmForm" name="filmForm">
                <table width="100%" class="table01">
                    <colgroup>
                        <col width="10%" />
                        <col width="10%" />
                        <col width="25%" />
                        <col width="15%" />
                        <col width="20%" />
                        <col width="20%" />
                    </colgroup>
                    <thead>        
                        <tr>
                            <th>상영관</th>
                            <th>좌석수</th>
                            <th>현재 상영작</th>
                            <th>가격</th>
                            <th>상영시간</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                    
                    </tbody>    
                </table>
            </form>            
            <div class="btn_right mt15">
                <button type="button" class="btn black mr5">예매확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>