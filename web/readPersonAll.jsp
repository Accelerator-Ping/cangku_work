<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="PO.Person" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/23
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询管理员信息</title>
</head>
<body style="background-image: url('./res/6.jpg');">

<form >
    管理员列表：
    <table width="100%" border=1>
        <tr>
            <td></td>
            <td>姓名</td>
            <td>身份</td>
        </tr>
        <c:forEach items="${personList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.identity}</td>
            <td><a href="deletePerson?name=${item.name}">删除</a></td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="2" >
                <a href="insertPerson.jsp">添加新管理员</a>
            </td>
        </tr>

    </table>
</form>


</body>
</html>
