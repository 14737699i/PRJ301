<%-- 
    Document   : takeattendance
    Created on : Jun 22, 2022, 12:23:42 AM
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
        <h3>Today(${requestScope.currentDate}) Class:</h3>
        <table>
            <tr>
                <td>Slot</td>
                <td>Class</td>
                <td>Course</td>
                <td>Take Attendance</td>
            </tr>
            <c:forEach items= "${requestScope.sessions}" var="s"> 
                <tr>
                    <td>${s.timeSlotId}</td>
                    <td>${s.group.id}</td>
                    <td>${s.group.courseId}</td>
                    
                </tr>
            </c:forEach> 
            
        </table>
    </body>
</html>
