<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/11/7
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>--%>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
<script src="http://apps.bdimg.com/libs/vue/1.0.14/vue.js" type="text/javascript"></script>
<script src="/blog/js/header.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/blog/css/header.css"/>
<link rel="stylesheet" type="text/css" href="/blog/css/common.css"/>
<link rel="stylesheet" type="text/css" href="/blog/css/globalCompont.css"/>
<link rel="stylesheet" type="text/css" href="/blog/css/iconfont.css"/>
<link rel="icon" href="/blog/images/logoFlyicon.png">
<script type="application/javascript">
    var loginOrNot='${empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}';
    var userId='${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.id}';
</script>
<%--<link rel="stylesheet" type="text/css" href="/blog/css/ionicons.min.css"/>--%>
<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

