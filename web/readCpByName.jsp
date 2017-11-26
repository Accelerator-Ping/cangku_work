<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="PO.C_p" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好，管理员
        <%=session.getAttribute("username")%>,你的操作记录为
    </title>
</head>
<body>
<form  >
    操作记录列表：
    <table width="100%" border=1>
        <tr>
            <td></td>
            <td>姓名</td>
            <td>操作</td>
            <td>货物名</td>
            <td>数量</td>
        </tr>
        <c:forEach items="${cpList}" var="item">
            <tr>
                <td>${item.user_name}</td>
                <td>${item.operation}</td>
                <td>${item.cargo_name}</td>
                <td>${item.number }</td>
            </tr>
        </c:forEach>
        <td colspan="2">
            <input type="button" name="Submit" value="返回" onclick="javascript:window.history.back(-1);">
        </td>
    </table>
</form>
</body>
</html>
