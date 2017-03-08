<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 07.03.2017
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" pageEncoding="UTF-8">

    <title>Add New Student</title>
</head>
<body>
<form accept-charset="utf-8" action="StudentController.do" method="post">
    <fieldset>
        <div>
            <label for="id">Student ID</label> <input type="number"
                                                             name="id" value="<c:out value="${student.id}" />"
                                                             readonly="readonly" placeholder="Student ID" />
        </div>
        <div>
            <label for="name">First Name</label> <input type="text"
                                                             name="name" value="<c:out value="${student.name}" />"
                                                             placeholder="First Name" />
        </div>
        <div>
            <label for="surname">Last Name</label> <input type="text"
                                                           name="surname" value="<c:out value="${student.surname}" />"
                                                           placeholder="Last Name" />
        </div>
        <div>
            <label for="telephoneNumber">Telephone</label> <input type="text" name="telephoneNumber"
                                                      value="<c:out value="${student.telephoneNumber}" />" placeholder="Telephone" />
        </div>
        <div>
            <label for="email">Email</label> <input type="text" name="email"
                                                  value="<c:out value="${student.email}" />" placeholder="Email" />
        </div>
        <div>
            <label for="dateOfBirth">Birthday</label> <input type="date" name="dateOfBirth"
                                                                  value="<c:out value="${student.dateOfBirth}" />" placeholder="Birthday" />
        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </fieldset>
</form>
</body>
</html>
