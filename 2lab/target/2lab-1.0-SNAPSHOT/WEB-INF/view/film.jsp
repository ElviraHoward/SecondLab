<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 17.12.2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Film Management</title>
</head>
<body>
<h1>Films Data</h1>
<form:form action="film.do" method="POST" commandName="film">
    <table>
        <tr>
            <td>ID</td>
            <td><form:input path="idFilm" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Release year</td>
            <td><form:input path="releaseDate" /></td>
        </tr>
        <tr>
            <td>Rating</td>
            <td><form:input path="rating" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
            </td>
        </tr>
    </table>
</form:form>
<br>
<table border="1">
    <th width="40">ID</th>
    <th width="120">Name</th>
    <th width="120">Release year</th>
    <th width="120">Rating</th>
    <c:forEach items="${filmList}" var="film">
        <tr>
            <td>${film.idFilm}</td>
            <td>${film.name}</td>
            <td>${film.releaseDate}</td>
            <td>${film.rating}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
