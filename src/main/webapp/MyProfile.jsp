<%-- 
    Document   : MyProfile
    Created on : 21-Oct-2014, 19:14:35
    Author     : Christopher
--%>

<%@page import="java.util.*"%>
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
        
            <%
                LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");                               
            %>
                
        <h1>InstaGrim !  </h1>
        <h2><%=lg.getUsername()%>'s world in Black and White</h2>
        </header>
        
        <nav>
            <ul>
                
                
                
           
                
                
                <%--<li class="nav"><a href="/Instagrim/upload.jsp">Upload a Profile Photo</a></li>--%>
                <%--<li class="nav"><a href="/Instagrim/Images/majed">Edit Bio</a></li>--%>
            </ul>
        </nav>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
    
