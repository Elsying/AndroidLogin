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
    <title>下载文件</title>
</head>
<!-- 遍历Map集合 -->
 <h4>文件列表：</h4>
     <c:forEach var="me" items="${fileNameMap}">
         <c:url value="/FileDownload" var="downurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
        <ul>
            <li> ${me.value}</li>
            <a href="${downurl}">下载</a>
        </ul>
     </c:forEach>
</body>
</html>
