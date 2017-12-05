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