<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>
</head>
<body style="background-image: url('./res/6.jpg');">
<form action="insertPerson" method="post">
    <table width="100%" border=1>
        请输入新增管理员的姓名
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码(默认为123456)</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
            <td colspan="2">
                <input type="button" name="Submit" value="返回" onclick="javascript:window.history.back(-1);">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
