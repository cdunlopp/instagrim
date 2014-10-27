<%-- 
    Document   : SearchResults
    Created on : 26-Oct-2014, 22:28:57
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
        <h2>Search Results:</h2>
        <%
            java.util.LinkedList<FoundList> fl = (java.util.LinkedList<FoundList>) request.getAttribute("results");
            if (fl == null) {
        %>
        <p>No Matches found</p>
        <%
        } else {
            Iterator<FoundList> iterator;
            iterator = fl.iterator();
            while (iterator.hasNext()) {
                FoundList fi = (FoundList) iterator.next();

        %>
        <a href="/Instagrim/MyProfile/<%=fi.login%>" ><img src="/Instagrim/Thumb/<%=fi.picID%>"></a> <%=fi.fname%> <%=fi.sname%> (<%=fi.login%>)<br/><%
        
            }
            }
        %>
        </header>
        
        <footer>
            <ul>
                
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
