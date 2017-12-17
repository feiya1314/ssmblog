<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/12/13
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/blog/css/markdownEditor.css"/>
    <link rel="stylesheet" type="text/css" href="/blog/css/markdown7.css"/>
    <script src="/blog/js/showdown.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
    <script src="http://apps.bdimg.com/libs/vue/1.0.14/vue.js" type="text/javascript"></script>
</head>
<body>
<div class="markdownEditor">
    <header class="editorHeader">
        <input id="editorId" placeholder="输入文章标题..." spellcheck="false" maxlength="80" class="title-input title-input">
        <div class="rightBox">
            <div class="saveBlog">
                <div class="saveBtn" v-on:click="saveBlog">
                    <span>保存</span>
                </div>
            </div>
            <div class="uploadImg" title="上传图片">
                <div class="panel">
                </div>
            </div>
            <div class="userImg">
                <div class="userHeadImgBox">
                    <img class="userHeadImg" src="/blog/images/1.jpg">
                </div>
            </div>
        </div>
    </header>
    <main class="mainContent">
        <div class="editBoxContainer" id="editBoxContainerId">
        <div id="editBoxId" class="editBox">
            <textarea class="editArea"id="text-input" wrap="off" autocorrect="off" autocapitalize="off" spellcheck="false"  oninput="convert()"
                      rows="6" cols="60">Type **Markdown** here.</textarea>

        </div>
        </div>
        <div class="previewContainer" id="previewContainerId">
            <div id="preview" class="previewBox"></div>
        </div>
        <script type="text/javascript">
            function convert(){
                var text = document.getElementById("text-input").value;
                var converter = new showdown.Converter();
                var html = converter.makeHtml(text);
                document.getElementById("preview").innerHTML = html;
            }
            var blogVue=new Vue({
                el:'.rightBox',
                data:{},
                methods:{
                    saveBlog:function () {
                        var markdownContent=getmarkdownContent();
                        var previewContent=document.getElementById("preview").innerHTML;
                        console.debug(previewContent);
                        previewContent=encodeURIComponent(previewContent);
                        console.debug(previewContent);
                        markdownContent=encodeURIComponent(markdownContent);
                        var temp=decodeURIComponent(previewContent);
                        console.debug(temp);
                        var blogForm=document.getElementById("blogForm");
                        var editorTitle=document.getElementById("editorId").value;
                        blogForm.method="post";
                        blogForm.markdown.value=markdownContent;
                        blogForm.preview.value=previewContent;
                        blogForm.title.value=editorTitle;
                        blogForm.submit();
                        /*console.debug(markdownContent);
                        alert(markdownContent11);
                        alert(previewContent);*/
                    }
                }
                
            });
            function getmarkdownContent(){
                return document.getElementById("text-input").value;
            }
        </script>
    </main>
    <form id="blogForm" action="/blog/editor">
        <input type="hidden" name="markdown">
        <input type="hidden" name="preview">
        <input type="hidden" name="userid" value='${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.id}'>
        <input type="hidden" name="title">
        <%--<input type="hidden" name="time">--%>
    </form>
</div>

</body>
</html>
