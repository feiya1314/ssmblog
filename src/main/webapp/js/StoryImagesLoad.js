$(function(){
    $("img").each(function (i) {
        if(0!=i){
            var temp=this.src;
            this.src="/blog/api/imgUrl?imgurl="+temp;
        }
    });

   var questionTitle=$(".question-title").text();
    //console.debug(questionTitle);
    if(""==questionTitle){
        questionTitle=$("title").text();
        console.debug(questionTitle);
        $(".question-title").text(questionTitle);
    }

});