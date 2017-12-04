<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/12/2
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <title>admine</title>
    <script type="application/javascript" >
        $(function () {
            $(".updateStory").click(function () {
                $.getJSON("/blog/adminTopThanSky/updateStory",function (json) {
                    console.debug("update result-->"+json);
                });
            });
        });
    </script>
</head>
<body>
    <p>admin page</p>
    uaername:${admin.username}<br>
id:${admin.id}<br>
role:${admin.role}
<button type="button" class="updateStory" >更新</button><br>
<a href="/blog/adminTopThanSky/logout">登出</a>
</body>
</html>
