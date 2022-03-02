<%--
  Created by IntelliJ IDEA.
  User: djymac
  Date: 2/21/21
  Time: 5:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="uploads"><br/>
        文件2<input type="file" name="uploads"><br/>
        <input type="submit" value="提交"><br/>
    </form>


    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="upload"><br/>
        文件2<input type="file" name="upload2"><br/>
           <input type="submit" value="提交"><br/>
    </form>
</body>
</html>
