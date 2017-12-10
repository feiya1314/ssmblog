var loginDisplayController=new Vue({
    el: '.global-component-box',
    data: {
        login_register:'登录',
        isDisplay: false,
        isLogin:true,
        normalImg:'none',
        greetingImg:'none',
        blindfoldImg:'none',
        usernameMsg:"ss",
        usernameMsgDisplay:false,
        passwordMsgDisplay:false,
        passwordMsg:"ss",
        isRegister:false,
        displayElem:{
            display:'none'
        },
    },
    methods:{
        displayLogin:function (display,loginOrReg) {
            this.isDisplay=display;
            if(loginOrReg=='login'){
                this.login_register='登录';
                this.isLogin=true;
                this.isRegister=false;
                this.normalImg='';
            }
            if(loginOrReg=='register'){
                this.login_register='注册';
                this.normalImg='none';
                this.greetingImg='none';
                this.blindfoldImg='none';
                this.isRegister=true;
                this.isLogin=false;
            }
        },
        changeUsernameErrorMessage:function (isDisplay,msg) {
            this.usernameMsgDisplay=isDisplay;
            this.usernameMsg=msg;
        },
        changePasswordErrorMessage:function (isDisplay,msg) {
            this.passwordMsgDisplay=isDisplay;
            this.passwordMsg=msg;
        },
        submitForm:function () {
            if(this.isRegister){
                /*var currUrl=window.location.pathname;
                var submitForm=document.getElementById("authForm");
                submitForm.method='post';
                submitForm.action='/blog/register';
                submitForm.currentUrl.value=currUrl;
                console.debug(submitForm.method);
                console.debug(submitForm.action);
                console.debug(submitForm.username.value);
                console.debug(submitForm.password.value);
                submitForm.submit();
                console.debug("register submit ");*/
                this.processSubmit('/blog/register');
            }else{
                processAjaxSubmit();
            }

        },
        processSubmit:function(actionUrl){
            var currUrl=window.location.pathname;
            var submitForm=document.getElementById("authForm");
            submitForm.method='post';
            submitForm.action=actionUrl;
            submitForm.currentUrl.value=currUrl;
            console.debug(submitForm.method);
            console.debug(submitForm.action);
            console.debug(submitForm.username.value);
            console.debug(submitForm.password.value);
            submitForm.submit();
            console.debug("register submit ");
        }
    }
});
new Vue({
    el:'.loginRegister',
    methods:{
        displayLogin:function (display,loginOrReg) {
            loginDisplayController.displayLogin(true,loginOrReg);
        }
    }

});
new Vue({
    el:'.headImgContainer',
    data:{
        displayMenu:'none',
    },
    methods:{
        displayDropMenu:function () {
            if(this.displayMenu=='none'){
                this.displayMenu='';
            }else {
                this.displayMenu='none'
            }
        }
    }

});

function processAjaxSubmit() {
    var formData = $("#authForm").serializeArray();
    var jsonForm = {};
    $(formData).each(function () {
        jsonForm[this.name] = this.value.trim();
    });
    var json = JSON.stringify(jsonForm);
    $.ajax(
        {
            url: "/blog/user/userLogin",
            type: "POST",
            dataType: "json",
            data: json,
            success: function (data, textStatus, jqXHR) {
                loginDisplayController.changePasswordErrorMessage(false,"");
                loginDisplayController.changeUsernameErrorMessage(false,"");
                window.location.reload(false);
                return ;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (XMLHttpRequest.status == "401" && textStatus == 'error') {
                    var jsonResult = XMLHttpRequest.responseJSON;
                    var errcode = jsonResult.errorCode;
                    if(errcode==101){
                        loginDisplayController.changeUsernameErrorMessage(true,"用户名未被注册")
                        return;
                    }
                    if(errcode==102){
                        loginDisplayController.changePasswordErrorMessage(true,"账号或密码错误");
                        return;
                    }
                    return;
                }
            }
        }
    );
}