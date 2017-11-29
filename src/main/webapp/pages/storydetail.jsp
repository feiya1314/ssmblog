<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/11/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test='${storydetails.imageurl!=""}'>
            <div id="titleImg"class="titleImgClass">
                <div class="wordOnImgContainer">
                    <div class="wordOnImg"><p class="image_source">${storydetails.image_source}</p></div>
                    <img class="imageDetail" src='${storydetails.imageurl}'>
                </div>
            </div>
            </c:if>
            <div class="articleContent">
                ${storydetails.body}<br>
            </div>
            <div class="extra">
                <br><br>
            </div>
        </div>
    </main>
</div>
</body>
</html>
