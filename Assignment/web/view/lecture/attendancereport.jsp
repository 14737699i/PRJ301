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
            <c:set var="index" value="${1}"></c:set> 
            <c:forEach items= "${requestScope.students}" var="s"> 
                <tr>
                    
                    <td>${index}</td>
                    <td>${requestScope.session.group.groupName}</td>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td><input type="radio" value="true" name="status_${s.id}">Present <input checked="checked" type="radio" value="false" name="status_${s.id}">Absent </td>
                    <td><input type="text"> </td>
                    <c:set var="index" value="${index+1}"></c:set> 
                </tr>
            </c:forEach>
        </tr> <br>
        
        </table>
        <input type="submit" value="Submit"/>
    </body>
</html>
