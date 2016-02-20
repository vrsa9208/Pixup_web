<%-- 
    Document   : index.jsp
    Created on : 20/02/2016, 12:48:17 PM
    Author     : JAVA-08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración pixup</title>
    </head>
    <body>
        <h1>Menu para administración de pixup</h1>
        
        <ul>
            <li><a href="<c:url value="/admin?action=discos" />">ABC Discos</a></li>
            <li><a href="<c:url value="/admin?action=artistas" />">ABC Artistas</a></li>
        </ul>

    </body>
</html>
