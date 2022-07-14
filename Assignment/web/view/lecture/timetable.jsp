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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <!-- CSS only -->
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <span>
                    <a href="../index.html" >Home</a> | 
                    <b>View Schedule</b>
                </span>
            </ol>
            <form id="formTable" action= "timetable" method="POST">
                <table>
                    <thead>
                        <tr>
                            <th rowspan="2">
                                ViewDate: <input type="date" name="chooseDate" value="${requestScope.chooseDate}" onchange="document.getElementById('formTable').submit();"> <br>
                            </th>
                            
                            <th>MON</th>
                            <th>TUE</th>
                            <th>WED</th>
                            <th>THU</th>
                            <th>FRI</th>
                            <th>SAT</th>
                            <th>SUN</th>    
                        </tr>
                        <tr>
                            <c:forEach items ="${requestScope.dates}" var = "d">
                                <th>${d}</th>
                            </c:forEach>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var = "i" begin = "1" end = "8">
                            <tr>
                                <td>Slot ${i}</td>
                                <c:forEach items ="${requestScope.dates}" var = "date">
                                    <td <c:if test="${requestScope.chooseDate eq date}"> bgcolor="#e0fffe"</c:if> >
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
                                                    <font color = "Red"> (Not yet) </font>
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
            </form>
        </div>
    </body>
</html>
