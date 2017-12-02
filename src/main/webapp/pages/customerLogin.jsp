<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2017/12/2
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/j_spring_security_check" method="post">
    <table>
        <tr>
            <th>zidingyi</th>
        </tr>
        <tr>
            <td>
                username:<input type="text">
            </td>
        </tr>
        <tr>
            <td>
                password:<input type="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
