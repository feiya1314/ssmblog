<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <jsp:include page="/pages/common.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<div class="viewcontainer">
  <jsp:include page="/pages/globalComponent.jsp"></jsp:include>
  <jsp:include page="/pages/header.jsp"></jsp:include>
</div>
  <a>User:</a><br>
  <a>hello !${user.name}</a><br>

  <script type="text/javascript" src="/blog/js/globalCompont.js"></script>
</body>
</html>