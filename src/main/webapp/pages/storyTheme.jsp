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
    <link rel="stylesheet" type="text/css" href="/blog/css/body.css"/>
    <title>zhihu daily - ${pageIdentity}</title>
    <meta name="pageIdentity" content="${pageIdentity}">
</head>
<body>
<div class="viewcontainer">
    <jsp:include page="/pages/globalComponent.jsp"></jsp:include>
    <jsp:include page="/pages/header.jsp"></jsp:include>
    <main class="container main-container">
        <div class="view">
            <div class="storyListZone">
                <div class="explore-story-list">
                    <div class="storylist">
                        <div class="storyitem1"><%--<button type="button" onclick="loadPastDayStories();">addmorestory</button>--%></div>
                        <c:forEach var="list" items="${stories}">
                            <div class="storyitem">
                            <div class="entry">
                                <div class="entryAddrAndAction">
                                    <div class="entryAddr">
                                        <a href="/blog/get/entry/${list.id}" target="_blank" title="">
                                            <div class="entryinfo">
                                                <div class="entrytitle">
                                                    <p class="entrytitlecontent">${list.title}</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="actionlist">
                                        <a class="collectBtn">
                                            <span class="icon"></span>
                                            <span class="actionTitle">收藏</span>
                                        </a>
                                        <a class="shareBtn">
                                            <span class="icon"></span>
                                            <span class="actionTitle">分享</span>
                                        </a>
                                    </div>
                                </div>
                                <div class="entryimage">
                                    <c:if test='${list.image!=""}'>
                                    <img src='/blog/api/imgUrl?imgurl=${list.image}'>
                                    </c:if>
                                    <c:if test='${list.image==""}'>
                                        <img src='/blog/images/blankImg.png'>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        </c:forEach>

                        <div class="flag"><br></div>
                    </div>
                </div>
                <div class="sideBar">
                    <div class="myselfImgContainer">
                        <div class="imgCircle">
                            <div class="myselfImg">
                                <img  class="myImg" src="/blog/images/1.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="simpleIntroduce">
                        <div class="nameJobContainer">
                            <div class="nameJob">
                                <div class="name">
                                    <p class="nameFont">于 飞</p>
                                </div>
                                <div class="job">
                                    <p class="jobFont">JAVA DEVELOPER</p>
                                </div>
                                <div class="delimerLine">
                                    <hr>
                                </div>
                                <div class="schoolAndPhone">
                                    <div class="school">
                                        <img class="schoolIcon introduceImg" src="/blog/images/school.png">
                                        <span>&nbsp;重庆大学</span>
                                    </div>
                                    <div class="phone">
                                        <img class="phoneIcon introduceImg" src="/blog/images/cellphone.png">
                                        <span>135-7084-5834</span>
                                    </div>
                                </div>
                                <div class="emailContainer">
                                    <div class="emailContent">
                                        <div class="emailIcon"><img class="emailImg" src="/blog/images/email.png"></div>
                                        <div>
                                            <span>&nbsp;&nbsp;yufei1313@126.com</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="webContainer">
                                    <div class="webContent">
                                        <div class="webIcon"><img class="webImg" src="/blog/images/web.png"></div>
                                        <div>
                                            <span>&nbsp;&nbsp;https://github.com/feiya1314</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="delimerLine">
                                    <hr>
                                </div>
                                <div class="abalityIntroduce">
                                    <div class="abality">
                                        <div>
                                            <span>:: 2年java开发经验</span>
                                        </div>
                                        <div>
                                            <span>:: 扎实的Java基础</span>
                                        </div>
                                        <div>
                                            <span>:: 熟练掌握Spring、SpringMVC</span><br>
                                            <span>&nbsp;&nbsp;&nbsp;等框架的开发及原理</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="delimerLineEnd">
                                    <hr>
                                </div>
                                <div class="viewMoreBtn">
                                    <dic class="viewMore">
                                        <a href="/blog/staticPages/personalInfo.html" target="_blank"><button class="moreBtn" type="button" >View More</button></a>
                                    </dic>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
<script type="text/javascript" src="/blog/js/globalCompont.js"></script>
</html>
