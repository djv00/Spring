<%--
  Created by IntelliJ IDEA.
  User: djymac
  Date: 2/20/21
  Time: 11:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<script>
    var userList = new Array();
    userList.push({username: "zhangsan", age: 19});
    userList.push({username: "lisi", age: 27});
    userList.push({username: "wangwu", age: 36});

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/user/quick15",
        data: JSON.stringify(userList),
        contentType: "application/json;charset=utf-8"
    });

</script>
<body>

</body>
</html>
