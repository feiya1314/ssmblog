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
                            <li v-on:click="writeArticle" class="nav-item writearticle">
                                <img src="/blog/images/article.svg" class="articleicon">
                                <span class="towrite">写文章</span>
                            </li>
                            <c:if test="${empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
                                <li class="nav-item loginRegister">
                                    <span v-on:click="displayLogin(true,'login')" class="login">登录</span>
                                    <span v-on:click="displayLogin(true,'register')" class="register">注册</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
                                <li class="nav-item headImgContainer">
                                    <div v-on:click="displayDropMenu"class="avatar lazy">
                                        <img src="/blog/images/3.jpg" class="headImg">
                                    </div>
                                    <ul class="nav-menu user-dropdown-list" v-bind:style="{display:displayMenu}" v-cloak>
                                        <div class="nav-menu-item-group">
                                            <li class="nav-menu-item">
                                                <a href="/blog/pages/editBlog.jsp"><i class="fengwei fw-write"></i><span>写文章</span></a>
                                            </li>
                                            <li class="nav-menu-item">
                                                <a><i class="fengwei fw-draft"></i><span>草稿</span></a>
                                            </li>
                                        </div>
                                        <div class="nav-menu-item-group">
                                            <li class="nav-menu-item">
                                                <a href="/blog/pages/user.jsp"><i class="fengwei fw-person"></i><span>我的主页</span></a>
                                            </li>
                                            <%--<li class="nav-menu-item">
                                                <a href="/user/5788c2d1165abd00670b4c33/like"><i class="fengwei fw-like"></i><span>我喜欢的</span></a>
                                            </li>--%>
                                            <li class="nav-menu-item">
                                                <a href="/user/5788c2d1165abd00670b4c33/collection"><i class="fengwei fw-collection"></i><span>我的收藏</span></a>
                                            </li>
                                        </div>
                                        <div class="nav-menu-item-group">
                                            <li class="nav-menu-item"><a href="/user/settings">
                                                <i class="fengwei fw-setting"></i><span>设置</span></a>
                                            </li>
                                            <li class="nav-menu-item more">
                                                <a><i class="fengwei fw-info"></i><span>关于</span></a>
                                            </li>
                                        </div>
                                        <div class="nav-menu-item-group">
                                            <li class="nav-menu-item">
                                                <a href="/blog/user/logout"><i class="fengwei fw-logout"></i><span>登出</span></a>
                                            </li>
                                        </div>
                                    </ul>
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

