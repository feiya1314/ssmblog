<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/11/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="/pages/common.jsp"></jsp:include>
    <script src="/blog/js/StoryImagesLoad.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/blog/css/StoryDetail.css"/>
    <title>${storydetails.title}</title>
</head>
<body>
<div class="viewcontainer">
    <jsp:include page="/pages/header.jsp"></jsp:include>
    <main class="container main-container">
        <div class="view">
            <div class="articleContent">
                ${storydetails.body}<br>
                    <a>${storydetails.imageurl}</a><br>
                    <a>${storydetails.image_source}</a><br>
            </div>
            <div class="extra">
                <br><br>
            </div>
        </div>
    </main>
</div>
</body>
</html>
