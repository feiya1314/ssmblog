<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%--<meta name="referrer" content="never">--%>
    <jsp:include page="pages/common.jsp"></jsp:include>
    <script type="text/javascript" src="js/jQuery-jcImgScroll.js"></script>
    <link rel="stylesheet" type="text/css" href="css/body.css"/>
    <title>Zhihu Daily</title>
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
                                <img src="#" class="smallImg">
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

                    </div>
                </div>
            </div>
            <%--<div>
                <h2>Hello World!</h2>
                <form action="user/getById" method="post">
                    <input type="submit" name="id" value="1"/>
                </form>
                <button type="button" id="test">tets</button>
                <form action="/api/topNewsByJs" method="get">
                    <input type="submit"/>topneste
                </form>

                <form action="user/user" method="post">
                    <input type="submit" name="id" value="1"/>
                </form>

                <form action="get/entry/88899898" method="get">
                    <input type="submit"/>rest
                </form>

                <form action="/api/topnews" method="get">
                    <input type="submit" name="date" value="20170604"/>
                </form>
                <form action="user/saveuser2" method="post">
                    <table>
                        <tr>
                            <td>
                                id&nbsp; :&nbsp;&nbsp; <input type="text" name="id">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                username&nbsp; :&nbsp;&nbsp; <input type="text" name="name">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                password&nbsp; :&nbsp;&nbsp; <input type="password" name="password">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="register"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="register2"/>
                            </td>
                        </tr>

                    </table>
                </form>
            </div>--%>
        </div>
    </main>
</div>
<script type="text/javascript" src="/blog/js/index.js"></script>
</body>
</html>
