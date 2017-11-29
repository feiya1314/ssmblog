<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%--<meta name="referrer" content="never">--%>
    <jsp:include page="pages/common.jsp"></jsp:include>
    <script type="text/javascript" src="js/jQuery-jcImgScroll.js"></script>
    <link rel="stylesheet" type="text/css" href="/blog/css/body.css"/>
    <title>Zhihu Daily</title>
    <meta name="pageIdentity" content="index">
</head>
<body>

<div class="viewcontainer">
    <jsp:include page="pages/header.jsp"></jsp:include>
    <main class="container main-container">
        <div class="view">
            <div class="topnews">
                <div id="topnewscontainer" class="jcImgScroll">
                    <div class="largestTopImg">
                        <a class="topNewsAdd" href="#" target="_blank" title="">
                            <img src="/blog/images/default.png" class="largeImg">
                            <div class="articletitleLarge">
                                <p class="articletitleTop"></p>
                            </div>
                        </a>

                    </div>
                    <div class="smallTopImgs">
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>

                        </div>
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>

                        </div>
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>
                        </div>
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>

                        </div>
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>

                        </div>
                        <div class="rightImg">
                            <a class="topNewsAdd" href="#" target="_blank" title="">
                                <img src="/blog/images/default.png" class="smallImg">
                                <div class="articletitlesmall">
                                    <p class="articletitle"></p>
                                </div>
                            </a>
                        </div>

                    </div>

                </div>
            </div>
            <%--<button type="button" onclick="getLastDay(5)">TestBtn</button>--%>
            <div class="underTopNew">
                <div class="explore-story-list">
                    <div class="storylist">
                        <div class="storyitem1"><%--<button type="button" onclick="loadPastDayStories();">addmorestory</button>--%></div>
                        <%--<div class="storyitem">
                            <div class="entry">
                                <div class="entryAddrAndAction">
                                    <div class="entryAddr">
                                        <a href="get/entry/4772126" target="_blank" title="">
                                            <div class="entryinfo">
                                                <div class="entrytitle">
                                                    <p class="entrytitlecontent">woxianzaishigeceshi 很好的护额韩国</p>
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
                                    <img src="/blog/images/entrydefault.png">
                                </div>
                            </div>
                        </div>
                        <div class="storyitem">
                            <div class="entry">
                                <div class="entryAddrAndAction">
                                    <div class="entryAddr">
                                        <a href="get/entry/4772126" target="_blank" title="">
                                            <div class="entryinfo">
                                                <div class="entrytitle">
                                                    <p class="entrytitlecontent">woxianzaishigeceshi 很好的护额韩国</p>
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
                                    <img src="/blog/images/entrydefault.png">
                                </div>
                            </div>
                        </div>--%>
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
<script type="text/javascript" src="/blog/js/index.js"></script>
</body>
</html>
