<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/11/7
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div calss="main-header-box">
    <header class="main-header">
        <div class="container">
            <a href="/blog/index.jsp" class="logo">
                <img src="/blog/images/logoFly.png" alt="feiya1314" class="logoImg">
            </a>
            <nav class="main-nav">
                <ul class="nav-list">
                    <li class="main-nav-list">
                        <ul class="nav-items">
                            <li class="nav-item">
                                <a class="indexPage" href="/blog/index.jsp">首页</a>
                            </li>
                            <li class="nav-item">
                                <a class="hotNewsPage" href="/blog/get/hotNews">今日热闻</a>
                            </li>
                            <li class="nav-item">
                                <a class="daliyPsychologyPage" href="/blog/get/dailyPsychology">日常心理学</a>
                            </li>
                            <li class="nav-item">
                                <a class="daliySportsPage" href="/blog/get/dailySports">体育日报</a>
                            </li>
                            <li class="nav-item">
                                <a class="pepoleRecommendPage" href="/blog/get/peopleRecommend">用户推荐</a>
                            </li>
                            <li class="nav-item">
                                <a class="moreContent" href="#">更多内容</a>
                            </li>
                            <li class="nav-item writearticle">
                                <img src="/blog/images/article.svg" class="articleicon">
                                <span class="towrite">写文章</span>
                            </li>
                            <c:if test="${empty sessionScope.username}">
                                <li class="nav-item loginRegister">
                                    <span v-on:click="displayLogin(true,'login')" class="login">登录</span>
                                    <span v-on:click="displayLogin(true,'register')" class="register">注册</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty sessionScope.username}">
                                <li class="nav-item headImgContainer">
                                    <img src="/blog/images/3.jpg" class="headImg">
                                </li>
                            </c:if>
                        </ul>
                    </li>
                    <li class="nav-item-add"></li>
                    <li class="nav-item-user"></li>
                </ul>
            </nav>
        </div>
    </header>
</div>

