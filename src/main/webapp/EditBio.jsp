<%-- 
    Document   : EditBio
    Created on : 25-Oct-2014, 16:07:57
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
                                   
        <h1>InstaGrim !  </h1>
        
        <%
                LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");                               
        %>
            
        <h2>Bio: <%=lg.getBio()%></h2>
        <h3>
            <form method="POST"  action="EditBio">
                <li>New Bio: <input type="text" name="bio"></li>
                <input type="submit" value="Edit Bio"> 
                </form>
        </h3>
        </header>
        <footer>
            <ul>
                
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
