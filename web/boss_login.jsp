<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/23
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎，老板:
        <%=session.getAttribute("username")%>
    </title>
</head>
<body style="background-image: url('./res/1.jpg');">
        <center>
            <a href="findPersonAll">查看员工信息</a>
            <br><br>
            <a href="findCpAll">查看操作记录</a>
            <br><br>
            <a href="updatePassword.jsp">修改密码</a>

        </center>
</body>
</html>
