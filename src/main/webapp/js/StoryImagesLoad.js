$(function(){
    $("img").each(function (i) {
        if(0!=i){
            var temp=this.src;
            this.src="/blog/api/imgUrl?imgurl="+temp;
        }
    });

   var questionTitle=$(".question-title").text();
   var questionTitle2=$(".headline-title").text();
    console.debug(questionTitle2);
    if(""==questionTitle&&questionTitle2==""){
        questionTitle=$("title").text();
        console.debug(questionTitle);
        $(".question-title").text(questionTitle);
    }

});