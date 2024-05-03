<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl core, function -->
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- bootstrap css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
	
</style>
<script>
	$(document).ready(function(){
		
		//이벤트 매핑 
		//$("#xxx").on("event", method);
		
		//화면 로딩시 실행 함수 
		//method();
		test();
		
	});//ready
	function test(){
		$.ajax(
			{
				type: "get",
				url:"async-error",
				data: {
					"prompt": prompt,
				},
				dataType: "text",
				success: function(data, status, xhr){
					console.log(data);
				},
				error: function(xhr, status, e){
					// console.log("실패: " + xhr.status);
					var emsg = JSON.parse(xhr.responseText).message;
					console.log(emsg);
				}
			}//ajax	
		);//ajax
	}
	
</script>
</head>
<body>
	<h1>test.jsp</h1>
<!-- bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>