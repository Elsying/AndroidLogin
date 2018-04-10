<%--
  Created by IntelliJ IDEA.
  User: 340144
  Date: 2018/4/10
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息提示</title>
</head>

    ${message }
    <br>
    <br>
<form method="post" action="${pageContext.request.contextPath}/FileList" >
    <input type="submit" value="显示文件" />
</form>
</body>
</html>
