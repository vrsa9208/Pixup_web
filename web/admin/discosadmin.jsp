<%-- 
    Document   : discosadmin.jsp
    Created on : 20/02/2016, 01:36:06 PM
    Author     : JAVA-08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Pixup Discos</title>
    </head>
    <body>
        <h1>Administración de discos PIXUP</h1>
        
        <form action="#" method="POST" >
            <table>
                <tr>
                    <td>Título:</td><td><input type="text" name="titulo" /></td>
                </tr>
                <tr>
                    <td>Fecha Lanzamiento:</td><td><input type="text" name="fechaLanzamiento" /></td>
                </tr>
                <tr>
                    <td>Precio:</td><td><input type="text" name="precio" /></td>
                </tr>
                <tr>
                    <td>Cantidad:</td><td><input type="text" name="cantidad" /></td>
                </tr>
                <tr>
                    <td>Idioma:</td>
                    <td>
                        <select name="idioma">
                            <option value="-1">Seleccione una opción</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>País:</td>
                    <td>
                        <select name="pais">
                            <option value="-1">Seleccione una opción</option>
                            <c:set var="paises" value="${applicationScope.catalogo_pais}" />
                            <c:forEach items="${paises}" var="pais">
                                <option value="${pais.id}">
                                    <c:out value="${pais.nombre}" />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
