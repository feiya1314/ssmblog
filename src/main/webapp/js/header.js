$(function () {
    /*change nav list font color when mouse over or out*/
    var identityPage=$('meta[name="pageIdentity"]').attr("content");
    if(identityPage=="index"){
        $(".indexPage").css("color","#007fff");
    }else if(identityPage=="hotNews"){
        $(".hotNewsPage").css("color","#007fff");
    }else if(identityPage=="dailyPsychology"){
        $(".daliyPsychologyPage").css("color","#007fff");
    }else if(identityPage=="peopleRecommend"){
        $(".pepoleRecommendPage").css("color","#007fff");
    }else if(identityPage=="dailySports"){
        $(".daliySportsPage").css("color","#007fff");
    }
    var currentColor;
    $(".nav-item").find("a").mouseover(function () {
        currentColor=$(this).css("color");
        $(this).css("color","#007fff");
    });
    $(".nav-item").find("a").mouseout(function () {
        $(this).css("color",currentColor);
    });
    $(".moreBtn").mouseover(function () {
        $(this).css("color","#007fff");
    });
    $(".moreBtn").mouseout(function () {
        $(this).css("color","#000000");
    });
});