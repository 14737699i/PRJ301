<%-- 
    Document   : login
    Created on : May 26, 2022, 11:08:06 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="login" method="POST">
        user:  <input type="text" name="user" /> <br/>
        pass: <input type="password" name="pass"/> <br/>
        <input type="submit" value="Send" />
        </form>
    </body>
</html>
