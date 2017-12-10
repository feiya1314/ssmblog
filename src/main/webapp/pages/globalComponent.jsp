<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/12/4
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="global-component-box" v-cloak>
    <div v-if="isDisplay" class="auth-modal-box">
    <form id="authForm" class="auth-form">
        <input type="hidden" name="currentUrl">
        <div class="panfish">
            <img src="/blog/images/normal.0447fe9.png" class="normal" v-bind:style="{display:normalImg}">
            <img src="/blog/images/greeting.1415c1c.png" class="greeting" v-bind:style="{display:greetingImg}">
            <img src="/blog/images/blindfold.58ce423.png" class="blindfold" v-bind:style="{display:blindfoldImg}">
        </div>
        <i title="关闭" v-on:click="displayLogin(false)" class="close-btn ion-close-round"></i>
        <div class="panel">
            <h1 class="loginTitle">{{login_register}}</h1>
            <div class="input-group">
                <div v-if="isLogin" class="input-box">
                    <input v-on:focus="clearErrorMsg" name="username" maxlength="64" placeholder="请输入账号" class="input">
                    <label v-if="usernameMsgDisplay"  class="errorInfo">{{usernameMsg}}</label>
                </div>
                <div v-if="isLogin" class="input-box">
                    <input v-on:focus="clearErrorMsg" name="password" type="password" maxlength="64" placeholder="请输入密码" class="input">
                    <label v-if="passwordMsgDisplay" v-on:focus="clearErrorMsg" class="errorInfo">{{passwordMsg}}</label>
                </div>
                <%--注册input--%>
                <div v-if="isRegister" class="input-box">
                    <input v-on:focus="clearErrorMsg" name="username" maxlength="20" placeholder="请输入用户名" class="input">
                    <label v-if="usernameMsgDisplay" v-on:focus="clearErrorMsg" class="errorInfo">{{usernameMsg}}</label>
                </div>
                <div v-if="isRegister" class="input-box">
                    <input v-on:focus="clearErrorMsg" name="registerPhoneOrEmail" maxlength="64" placeholder="请填写手机号或邮箱" class="input">
                    <label v-if="phoneMsgDisplay" v-on:focus="clearErrorMsg" class="errorInfo">{{phoneMsg}}</label>
                </div>
                <div v-if="isRegister" class="input-box">
                    <input v-on:focus="clearErrorMsg" name="password" type="password" maxlength="64" placeholder="请输入密码" class="input">
                    <label v-if="passwordMsgDisplay" v-on:focus="clearErrorMsg" class="errorInfo">{{passwordMsg}}</label>
                </div>
            </div>
            <button v-on:click="submitForm" type="button" class="loginBtn">{{login_register}}</button>
            <div v-if="isLogin" class="prompt-box">
                没有账号？
                <span v-on:click="displayLogin(true,'register')" class="clickable">注册</span>
                <a href="/reset-password" class="right clickable">忘记密码</a>
            </div>
            <div v-if="isRegister" class="prompt-box textcenter">
                <span v-on:click="displayLogin(true,'login')" class="clickable">已有账号登录</span>
            </div>
        </div>
        <div class="oauth-box">
            第三方账号登录：
            <img title="微博" alt="微博" src="/blog/images/weibo.svg" class="oauth-btn">
            <img title="微信" alt="微信" src="/blog/images/wechat.svg" class="oauth-btn">
            <img title="GitHub" alt="GitHub" src="/blog/images/github.svg" class="oauth-btn">
        </div>
    </form>
    </div>
</div>
