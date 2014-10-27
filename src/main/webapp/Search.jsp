<%-- 
    Document   : Search
    Created on : 26-Oct-2014, 22:14:39
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
        <h3>
            <form method="POST" action="Search" >
                <li>Search User by Surname:<input type="text" name="name"></li>
                <input type="submit" value="Search">
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
