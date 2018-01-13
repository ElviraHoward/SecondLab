<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 12.01.2018
  Time: 20:04
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
    <title>Director Management</title>
</head>
<body>
<h1>Directors Data</h1>
<form:form action="director.do" method="POST" commandName="director">
    <table>
        <tr>
            <td>ID</td>
            <td><form:input path="idDirector" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Count of oscars</td>
            <td><form:input path="countOfOscars" /></td>
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
    <th width="120">Count of oscars</th>
    <c:forEach items="${directorList}" var="director">
        <tr>
            <td>${director.idDirector}</td>
            <td>${director.name}</td>
            <td>${director.countOfOscars}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>