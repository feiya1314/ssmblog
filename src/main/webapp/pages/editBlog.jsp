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
    <link rel="stylesheet" type="text/css" href="/blog/css/markdown4.css"/>
    <script src="/blog/js/showdown.min.js"></script>
</head>
<body>
<div class="markdownEditor">
    <header class="editorHeader">
        <input placeholder="输入文章标题..." spellcheck="false" maxlength="80" class="title-input title-input">
    </header>
    <main class="mainContent">
        <div class="editBoxContainer">
        <div class="editBox">
            <textarea class="editArea"id="text-input" wrap="off" autocorrect="off" autocapitalize="off" spellcheck="false"  oninput="convert()"
                      rows="6" cols="60">Type **Markdown** here.</textarea>

        </div>
        </div>
        <div class="previewContainer">
            <div id="preview" class="previewBox"></div>
        </div>
        <script type="text/javascript">
            function convert(){
                var text = document.getElementById("text-input").value;
                var converter = new showdown.Converter();
                var html = converter.makeHtml(text);
                document.getElementById("preview").innerHTML = html;
            }
        </script>
    </main>
</div>

</body>
</html>
