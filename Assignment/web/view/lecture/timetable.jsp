<%-- 
    Document   : timetable
    Created on : Jun 29, 2022, 3:27:14 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    WEEK
                </td>
                <td>MON</td>
                <td>TUE</td>
                <td>WED</td>
                <td>THU</td>
                <td>FRI</td>
                <td>SAT</td>
                <td>SUN</td>
            </tr>

            <tbody>
                <c:forEach var = "i" begin = "1" end = "8">
                    <tr>
                        <td>Slot ${i}</td>
                        <c:forEach items ="${requestScope.dates}" var = "date">
                            <td>
                                <c:set var="flag" value="0"></c:set>
                                <c:forEach items="${requestScope.sessions}" var = "s">
                                    <c:if test = "${(s.sessionDate eq date) and (s.timeSlotId eq i)}">
                                        <c:set var="flag" value="1"></c:set>
                                        <a href=""> ${s.group.groupName}<br>-${s.group.courseId} </a> <br>
                                        at ${s.room} <br>
                                        <c:if test="${s.status eq true}">
                                            <font color = "Green"> (Attendance) </font>
                                        </c:if>
                                        <c:if test="${s.status eq false}">
                                            <font color = "#f28383"> (Not yet) </font>
                                        </c:if> <br>
                                    </c:if>


                                </c:forEach>
                                <c:if test="${flag eq 0}">
                                    -
                                </c:if>
                            </td>
                        </c:forEach>

                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </body>
</html>
