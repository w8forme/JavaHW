<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 07.03.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" pageEncoding="UTF-8">
    <title>Show All Students</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Student ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Telephone</th>
        <th>Email</th>
        <th>Birthday</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.id}" /></td>
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.surname}" /></td>
            <td><c:out value="${student.telephoneNumber}" /></td>
            <td><c:out value="${student.email}" /></td>
            <td><c:out value="${student.dateOfBirth}" /></td>
            <td><a
                    href="StudentController.do?action=edit&studentId=<c:out value="${student.id }"/>">Update</a></td>
            <td><a
                    href="StudentController.do?action=delete&studentId=<c:out value="${student.id }"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="StudentController.do?action=insert">Add Student</a>
</p>
</body>
</html>
