<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <jsp:include page="common.jsp"></jsp:include>
   <script type="text/javascript" src="js/jQuery-jcImgScroll.js"></script>
<title>Insert title here</title>
</head>
<body>
   <a>this is the test</a>
   <a>list:</a><br>
   <a>${TopNewsList.get(0).title}</a><br>
   <a>${TopNewsList.get(0).image}</a>
<button type="button" id="jsonTest">
   getUser;
</button>
</body>

<script type="application/javascript">
    $(function () {
        $("#jsonTest").click( function test() {
            alert("statrt test");
            $.ajax(
                {
                    url:"/blog/user/user",
                    type:"POST",
                    dataType:"json",
                    data:"id=1",
                    success:function (data, textStatus, jqXHR) {
                        alert(data);
                        alert(textStatus);
                        alert(jqXHR);
                    },
                    error:function (XMLHttpRequest, textStatus, errorThrown) {
                        if(XMLHttpRequest.status=="403"){
                            alert("not login ,to do Login");
                        }

                        //alert(textStatus);
                        //alert(errorThrown);

                    }
                }
            );
        });
    });
</script>
</html>