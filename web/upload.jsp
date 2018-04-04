<%--
  Created by IntelliJ IDEA.
  User: 340144
  Date: 2018/4/4
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/FileUpload" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
