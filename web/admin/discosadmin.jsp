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
    <body align="center">
        <h1>Administración de discos PIXUP</h1>
        <c:if test="${not empty requestScope.error}">
            <p style="color: red">
                <c:out value="${requestScope.error}" />
            </p>
        </c:if>
        <form action="<c:url value="/discosadmin" />" method="POST" >
            <c:if test="${not empty requestScope.action}">
                <input type="hidden" name="action" value="edit" />
            </c:if>
            <c:if test="${empty requestScope.action}">
                <input type="hidden" name="action" value="add" />
            </c:if>
            <table align="center">
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
                            <c:set var="idiomas" value="${applicationScope.catalogo_idiomas}" />
                            <c:forEach items="${idiomas}" var="idioma">
                                <option value="${idioma.id}">
                                    <c:out value="${idioma.descripcion}" />
                                </option>
                            </c:forEach>
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
                <tr>
                    <td>Genero Musical:</td>
                    <td>
                        <select name="genero_musical">
                            <option value="-1">Seleccione una opción</option>
                            <c:set var="generos_musicales" value="${applicationScope.catalogo_genero_musical}" />
                            <c:forEach items="${generos_musicales}" var="genero">
                                <option value="${genero.id}">
                                    <c:out value="${genero.nombre}" />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Disquera:</td>
                    <td>
                        <select name="disquera">
                            <option value="-1">Seleccione una opción</option>
                            <c:set var="disqueras" value="${applicationScope.catalogo_disquera}" />
                            <c:forEach items="${disqueras}" var="disquera">
                                <option value="${disquera.id}">
                                    <c:out value="${disquera.nombre}" />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Aceptar" />
        </form>

        <style>
            
            table.discos {
                margin-top: 30px;
                border-top: solid #CE3C2D;
            }
            table.discos tbody tr:nth-child(odd){
                background: #CE3C2D;
                color: white;
            }
            
            table.discos tbody tr:nth-child(odd) a{
                color: white;
            }
        </style>
        <h3>Lista de Discos</h3>
        <table class="discos" align="center">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Género</th>
                    <th>Idioma</th>
                    <th>País</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="discos" value="${requestScope.lista_discos}" />
                <c:forEach items="${discos}" var="disco">
                    <tr>
                        <td>${disco.titulo}</td>
                        <td>${disco.generoMusical.nombre}</td>
                        <td>${disco.idioma.descripcion}</td>
                        <td>${disco.pais.nombre}</td>
                        <td>${disco.precio}</td>
                        <td>
                            <a href="<c:url value="/discosadmin?action=edit&id=${disco.id}" />">Editar</a>
                            <a href="<c:url value="/discosadmin?action=delete&id=${disco.id}" />">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
