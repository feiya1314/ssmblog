var loginDisplayController = new Vue({
    el: '.global-component-box',
    data: {
        login_register: '登录',
        isDisplay: false,
        isLogin: true,
        normalImg: 'none',
        greetingImg: 'none',
        blindfoldImg: 'none',
        usernameMsg: "",
        usernameMsgDisplay: false,
        phoneMsg: "",
        phoneMsgDisplay: false,
        passwordMsgDisplay: false,
        passwordMsg: "",
        isRegister: false,
        displayElem: {
            display: 'none'
        },
    },
    methods: {
        displayLogin: function (display, loginOrReg) {
            this.isDisplay = display;
            if (loginOrReg == 'login') {
                this.login_register = '登录';
                this.isLogin = true;
                this.isRegister = false;
                this.normalImg = '';
                this.changePhoneErrorMessage(false, "");
                this.changeUsernameErrorMessage(false, "");
                this.changePasswordErrorMessage(false, "");
            }
            if (loginOrReg == 'register') {
                this.login_register = '注册';
                this.normalImg = 'none';
                this.greetingImg = 'none';
                this.blindfoldImg = 'none';
                this.isRegister = true;
                this.isLogin = false;
                this.changePhoneErrorMessage(false, "");
                this.changeUsernameErrorMessage(false, "");
                this.changePasswordErrorMessage(false, "");
            }
        },
        changeUsernameErrorMessage: function (isDisplay, msg) {
            this.usernameMsgDisplay = isDisplay;
            this.usernameMsg = msg;
        },
        changePasswordErrorMessage: function (isDisplay, msg) {
            this.passwordMsgDisplay = isDisplay;
            this.passwordMsg = msg;
        },
        changePhoneErrorMessage: function (isDisplay, msg) {
            this.phoneMsgDisplay = isDisplay;
            this.phoneMsg = msg;
        },
        clearErrorMsg:function () {
            this.changePhoneErrorMessage(false, "");
            this.changeUsernameErrorMessage(false, "");
            this.changePasswordErrorMessage(false, "");
        },
        submitForm: function () {
            if (this.isRegister) {
                processRegister();
            } else {
                processAjaxSubmit();
            }

        },
        processSubmit: function (actionUrl) {
            var currUrl = window.location.pathname;
            var submitForm = document.getElementById("authForm");
            submitForm.method = 'post';
            submitForm.action = actionUrl;
            submitForm.currentUrl.value = currUrl;
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
    el: '.loginRegister',
    methods: {
        displayLogin: function (display, loginOrReg) {
            loginDisplayController.displayLogin(true, loginOrReg);
        }
    }

});
new Vue({
    el: '.headImgContainer',
    data: {
        displayMenu: 'none',
    },
    methods: {
        displayDropMenu: function () {
            if (this.displayMenu == 'none') {
                this.displayMenu = '';
            } else {
                this.displayMenu = 'none'
            }
        }
    }

});

function processRegister() {
    var formData = $("#authForm").serialize();

    $.ajax(
        {
            url: "/blog/register",
            type: "POST",
            //dataType: "json",
            data: formData,
            success: function (data, textStatus, jqXHR) {
                if (data != null) {
                    if (data.errorCode == "040001") {
                        if (data.data == 103) {
                            loginDisplayController.changePhoneErrorMessage(true, "无效的手机号或邮箱");
                        }
                        if (data.data == 104) {
                            loginDisplayController.changeUsernameErrorMessage(true, "用户名不能为空");
                        }
                        if (data.data == 105) {
                            loginDisplayController.changeUsernameErrorMessage(true, "用户名已存在");
                        }
                        if (data.data == 106) {
                            loginDisplayController.changePasswordErrorMessage(true, "密码不能为空");
                        }
                        return;
                    } else {
                        window.location.reload(false);
                        loginDisplayController.changePhoneErrorMessage(false, "");
                        loginDisplayController.changeUsernameErrorMessage(false, "");
                        loginDisplayController.changePasswordErrorMessage(false, "");
                    }
                }
                //loginDisplayController.changePasswordErrorMessage(false,"");
                //loginDisplayController.changeUsernameErrorMessage(false,"");
                return;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (XMLHttpRequest.status == "401" && textStatus == 'error') {
                    var jsonResult = XMLHttpRequest.responseJSON;
                    var errcode = jsonResult.errorCode;
                    if (errcode == 101) {
                        // loginDisplayController.changeUsernameErrorMessage(true,"用户名未被注册")
                        return;
                    }
                    if (errcode == 102) {
                        //loginDisplayController.changePasswordErrorMessage(true,"账号或密码错误");
                        return;
                    }
                    return;
                }
            }
        }
    );
}

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
                loginDisplayController.changePasswordErrorMessage(false, "");
                loginDisplayController.changeUsernameErrorMessage(false, "");
                window.location.reload(false);
                return;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (XMLHttpRequest.status == "401" && textStatus == 'error') {
                    var jsonResult = XMLHttpRequest.responseJSON;
                    var errcode = jsonResult.errorCode;
                    if (errcode == 101) {
                        loginDisplayController.changeUsernameErrorMessage(true, "用户名未被注册")
                        return;
                    }
                    if (errcode == 102) {
                        loginDisplayController.changePasswordErrorMessage(true, "账号或密码错误");
                        return;
                    }
                    return;
                }
            }
        }
    );
}

