<%-- 
    Document   : EditPF
    Created on : 25-Oct-2014, 16:42:50
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
                                   
        <h1>InstaGrim !  </h1>
        
        <%
                LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");                               
        %>
            
        <h2><a href="/Instagrim/Image/<%=lg.getpPicID()%>" ><img src="/Instagrim/Thumb/<%=lg.getpPicID()%>"></a><br/></h2>
        <h3>
            <form method="POST" enctype="multipart/form-data" action="Image" >
                
                File to upload: <input type="file" name="upfile">
                <input type="hidden" name="source" value="Profile"/>
                <br/>
                <br/>
                <input type="submit" value="Press"> to upload the file!
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
