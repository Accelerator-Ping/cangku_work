<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加货物信息</title>
</head>
<body>
<form action="insertCargo" method="post">
    <table width="100%" border=1>
        请输入新增货物的信息
        <tr>
            <td>名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>种类</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
            <td colspan="2">
                <input type="button" name="Submit" value="返回" onclick="javascript:window.history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
