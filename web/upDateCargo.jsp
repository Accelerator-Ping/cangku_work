<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新货物</title>
</head>
<body>
<%
    String  s=request.getParameter("name");
    request.getSession(true).setAttribute("cargoname",s);
%>
<form action="upDateCargo?" method="post">
    <table width="202" border="0" align="center" cellpadding="05" cellspacing="0" id="logintable">
    <tr>
        <td>您要更改的是:<%=request.getParameter("name")%></td>
    </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>
