<%--
  Created by IntelliJ IDEA.
  User: 340144
  Date: 2018/4/8
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>下载文件显示页面</title>
</head>
<body>
<!-- 遍历Map集合 -->
     <c:forEach var="me" items="${fileNameMap}">

              ${me.value}
             <br />
         </c:forEach>
</body>
</html>
