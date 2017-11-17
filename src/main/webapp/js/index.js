$(function () {
    getTopNews();
});
function getTopNews() {
    $.getJSON("api/topNewsByJs", function (json) {
        var title ;
        var id;
        var image;
        $(".topNewsAdd").each(function (i) {
            id="get/entry/"+json.data.topNews[i].id;
            title=json.data.topNews[i].title;
            image="api/imgUrl?imgurl="+json.data.topNews[i].image;

            $(this).attr("href",id);
            $(this).attr("title",title);
            $(this).find("img").attr("src",image);
            $(this).find("p").text(title);
        });
        //initPage();
        entryInit(json);
    });
}
var loadWhichDay="";
function loadPastDayStories() {
    //loadWhichDay
    $.getJSON("api/moreStories",{date:"20171114"}, function (json) {
        entryInit(json);
    });

}
/*<div class="storyitem">
    <div class="entry">
    <div class="entryAddrAndAction"><div class="entryAddr">
    <a href="get/entry/4772126" target="_blank" title="">
    <div class="entryinfo"><div class="entrytitle"><p class="entrytitlecontent">woxianzaishigeceshi 很好的护额韩国</p></div></div></a></div>
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
    </div>*/

function entryInit(json) {
    console.debug("jsonlength");
    console.debug(json.data.stories.length);
    var jsonLength=json.data.stories.length;
    var id;
    var title;
    var imgurl;
    for(var i=0;i<jsonLength;i++){
        id=json.data.stories[i].id;
        title=json.data.stories[i].title;
        imgurl=json.data.stories[i].image;
        console.debug(id);
        console.debug(title);
        console.debug(imgurl);
        var appendContent=getStoryItem(id,title)+getActionList(imgurl);
        $(".flag").before(appendContent);
    }
}
function getStoryItem(id,title){
    var str1="<div class=\"storyitem\"><div class=\"entry\"><div class=\"entryAddrAndAction\"><div class=\"entryAddr\"><a href=\"get/entry/"+id+"\" target=\"_blank\" title=\"\">";
    var str2="<div class=\"entryinfo\"><div class=\"entrytitle\"><p class=\"entrytitlecontent\">"+title+"</p></div></div></a></div>";
    return str1+str2;
}
function getActionList(entryimage) {
    var str1="<div class=\"actionlist\"><a class=\"collectBtn\"><span class=\"icon\"></span><span class=\"actionTitle\">收藏</span><a class=\"shareBtn\">"
            +"<span class=\"icon\"></span><span class=\"actionTitle\">分享</span></a></div></div><div class=\"entryimage\"><img src=\"";
    if(entryimage!=""){
        var imgurl="api/imgUrl?imgurl="+entryimage;
    }
    else{
        var imgurl="/blog/images/entrydefault.png";
    }
    var str2="\"></div></div></div>";
    return str1+imgurl+str2;
}
/*
function initPage() {
    (function () {
        $("#sPrev").hide();
        $("#sNext").hide();
    })();
    $("#topnewscontainer").jcImgScroll({
        arrow: {
            width: 45,
            height: 400,
            x: 30,
            y: 0
        },
        width: 330, //设置图片宽度
        height: 350, //设置图片高度
        imgtop: 10,//每张图片的上下偏移量
        imgleft: -10,//每张图片的左边偏移量
        imgwidth: 20,//每张图片的宽度偏移量
        imgheight: 0,//每张图片的高度偏移量
        count: 5,
        offsetX: 120,
        NumBtn: false,
        title: false,
        setZoom: .8,
    });
    $("#topnewscontainer").hover(
        function () {
            $("#sPrev").show();
            $("#sNext").show();
        },
        function () {
            $("#sPrev").hide();
            $("#sNext").hide();
        }
    )
}*/
