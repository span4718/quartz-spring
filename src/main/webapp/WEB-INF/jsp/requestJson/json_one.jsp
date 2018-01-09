<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.6/dist/js/bootstrap.min.js" charset="utf-8"></script>
<script type="text/javascript">
	function subjson(){
		var a = "123";
		var b = "321";
		var c = "231";
		var url = $("#form").val();
		var json = {"username":a,"password":b,"rem":c}
		var datas = JSON.stringify(json);
		alert(datas)
		  $.ajax({
			  url:url,
			  type:"POST",
              contentType:'application/json;charset=UTF-8', // 这句不加出现415错误:Unsupported Media Type
              data:datas,
			  success:function(data){
				 alert(data);
			  }
		 });
	}
</script>
</head>
<body>

	<button id="form" value="${pageContext.request.contextPath}/json/testOne"></button>
	<button name="提交" onclick="subjson()"></button>
</body>
</html>