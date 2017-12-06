var loginDisplayController=new Vue({
    el: '.global-component-box',
    data: {
        login_register:'登录',
        isDisplay: false,
        isLogin:true,
        normalImg:'none',
        greetingImg:'none',
        blindfoldImg:'none',
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
                this.processSubmit('/blog/user/userLogin');
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