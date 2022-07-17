<%-- 
    Document   : report_confirm
    Created on : Jul 15, 2022, 3:18:56 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Confirm</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>

        <script>
            var count = 15;
            function redirect()
            {
                count--;
                document.getElementById('timer').innerHTML = count;
                
                if (count <= 0){
                    window.location.href = 'takeattendance';
                }
                    
            }
            setInterval(redirect, 1000);
        </script>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <span>
                    <a href="../index.html" >Home</a> |
                    <a href="takeattendance">Take Attendance
                    </a> | 
                    <b>Report</b>
                </span>
            </ol>
            
            
            Attendance Report has been ${requestScope.action} successfully<br/>
            Redirect to Take Attendance page after <span id="timer">15</span> seconds
        </div>


    </body>
</html>
