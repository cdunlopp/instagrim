<%-- 
    Document   : MyProfile
    Created on : 21-Oct-2014, 19:14:35
    Author     : Christopher
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>

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
                CurrentPage cp = (CurrentPage) session.getAttribute("CurrentPage");
            %>
                
        <h1>InstaGrim !  </h1>
        <h2><%=cp.getFirstName()%>'s world in Black and White</h2>
        
        
        <a href="/Instagrim/Image/<%=cp.getpPicID()%>" ><img src="/Instagrim/Thumb/<%=cp.getpPicID()%>"></a><br/>
        
        
        <h3>Bio: <%=cp.getBio()%></h3>
        </header>
        <footer>
            <ul>
                
                <%        
                        
                        
                        if (lg != null) {
                            if (lg.getUsername().equals(cp.getUsername())){
                    %>

                <li class="footer"><a href="/Instagrim/EditBio.jsp">Edit Bio</a></li>
                <li class="footer"><a href="/Instagrim/EditPF.jsp">Edit Profile Photo</a></li>              
                    
                    
                    <%}
                        }%>          
                
                
                <li class="footer"><a href="/Instagrim/Images/<%=cp.getUsername()%>">View Images</a></li>
                <li class="footer"><a href="/Instagrim">Home</a></li>
                
            </ul>
        </footer>
    </body>
</html>
    
