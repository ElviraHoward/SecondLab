<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 17.12.2017
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main menu</title>
</head>
<body>
<h3>Main menu</h3>
<br/>
<a href="<c:url value="/film"/>" target="_blank">Operations with films</a>
<br/>
<br/>
<a href="<c:url value="/director"/>" target="_blank">Operations with directors</a>
<br/>
</body>
</html>
