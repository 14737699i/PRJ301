<%-- 
    Document   : attendancereport
    Created on : Jun 22, 2022, 2:44:23 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Attendance for ${requestScope.session.group.groupName} at Slot ${requestScope.session.sessionNo} on ${requestScope.session.sessionDate} in ${requestScope.session.room}</h2>
        <table>
            <tr>
                <td>No</td>
                <td>Group</td>
                <td>Code</td>
                <td>Name</td>
                <td>Status</td>
                <td>Comment</td>
                
            <c:forEach items= "${requestScope.students}" var="s"> 
                <tr>
                    <td>${requestScope.session.sessionNo}</td>
                    <td>${requestScope.session.group.groupName}</td>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td><input type="radio" name="Present"> <input type="radio" name="Absent"> </td>
                    <td><input type="text"> </td>
                </tr>
            </c:forEach>
        </tr> <br>
        
        </table>
        <input type="submit" value="Submit"/>
    </body>
</html>
