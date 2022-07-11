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
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Attendance for ${requestScope.session.group.groupName} at Slot ${requestScope.session.sessionNo} on ${requestScope.session.sessionDate} in ${requestScope.session.room}</h2>

        <c:if test="${requestScope.session.status eq true}">
            <form id="formUpdate" action= "update" method="POST">
                <h3>${requestScope.session.id}</h3>
                <h3>${requestScope.session.status}</h3>
                <input type="hidden" name="sessionId" value="${requestScope.session.id}">
                <table>
                    <tr>
                        <td>No</td>
                        <td>Group</td>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Status</td>
                        <td>Comment</td>
                        <c:set var="index" value="${1}"></c:set> 
                        <c:forEach items= "${requestScope.ars}" var="a"> 
                        <tr>
                            <td><input type="hidden" name="index" value="${index}"> ${index}</td>
                            <input type="hidden" name="a.id_${index}" value="${a.id}">
                            <td>${requestScope.session.group.groupName}</td>
                            <td><input type="hidden" name="sId_${index}" value="${a.student.id}">${a.student.id}</td>
                            <td><input type="hidden" name="sName_${index}" value="${a.student.name}">${a.student.name}</td>
                            <td>
                                <input <c:if test="${a.status eq true}"> checked="checked" </c:if>< type="radio" value="true" name="status_${index}">Present 
                                <input <c:if test="${a.status eq false}"> checked="checked" </c:if> type="radio" value="false" name="status_${index}">Absent 
                                </td>
                                <td><input type="text" name="comment_${index}"> </td>
                                <c:set var="index" value="${index+1}"></c:set> 
                            </tr>
                    </c:forEach>
                    </tr> <br>
                </table>
                <input type="submit" value="Save"/>
            </form>
        </c:if>


        <c:if test="${requestScope.session.status eq false}">
            <h3>${requestScope.session.id}</h3>
            <h3>${requestScope.session.status}</h3>
            <form id="formInsert" action= "insert" method="POST">
                <input type="hidden" name="sessionId" value="${requestScope.session.id}">
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
                        <input type="hidden" value="${requestScope.session.sessionNo}}">
                        <td><input type="hidden" name="index" value="${index}">${index}</td>
                        <td>${requestScope.session.group.groupName}</td>
                        <td><input type="hidden" name="sId_${index}" value="${s.id}">${s.id}</td>
                        <td><input type="hidden" name="sName_${index}" value="${s.name}">${s.name}</td>
                        <td><input type="radio" value="true" name="status_${index}">Present <input checked="checked" type="radio" value="false" name="status_${index}">Absent </td>
                        <td><input type="text" name="comment_${index}"> </td>
                            <c:set var="index" value="${index+1}"></c:set> 
                            </tr>
                    </c:forEach>
                    </tr> <br>

                </table>
                <input type="submit" value="Save"/>
            </form>
        </c:if>



    </body>
</html>
