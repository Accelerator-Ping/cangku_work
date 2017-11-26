<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好，
        <%=session.getAttribute("username")%>
    </title>
</head>
<body>
<form action="updatePassword" method="post">
    <table width="202" border="0" align="center" cellpadding="05" cellspacing="0" id="logintable">
        <tr>
            <td>您要更改用户是:<%=request.getSession().getAttribute("username")%></td>
        </tr>
        <tr>
            <td>旧密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" name="newPassword"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>
