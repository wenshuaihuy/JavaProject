<%--
  Created by IntelliJ IDEA.
  User: WSHu
  Date: 2020/12/17
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件管理系统</title>
    <script src="js/jquery-2.1.0.min.js"></script>
</head>
<body>
<div style="width: 90%;text-align: right" >

    <form action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data" method="post">

        <input type="file" name="file1"><br/>
        <input type="submit"  value="上传文件"><br/>
    </form>
    <button style="size: 40px">
        <a style="text-decoration: none;color: black" href="${pageContext.request.contextPath}/listAll">查看所有文件</a>
    </button>
</div>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="80%">
    <tr align="center">
        <td colspan="3" style="height: 50px;font-weight: bold" >
            文件管理系统
        </td>
    </tr>
    <tr class="success">
    </tr>
    <tr align="center">
        <th>编号</th>
        <th>上传时间</th>
        <th>文件名称</th>
        <c:if test="${not empty list}">
        <c:forEach items="${list}" var="l" varStatus="vs" begin="0" end="5" >
    <tr align="center">
        <td>${vs.count}</td>
        <td>${l.time}</td>
        <td>${l.flow}</td>
    </tr>
    </c:forEach>
    </c:if>
    </tr>
</table>
<br>
</body>
</html>