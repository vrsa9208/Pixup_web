<%-- 
    Document   : discosadmin.jsp
    Created on : 20/02/2016, 01:36:06 PM
    Author     : JAVA-08
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:if test="${empty sessionScope.idioma}">
   <fmt:setLocale value="es_MX" scope="session" /> 
</c:if>

<c:if test="${not empty sessionScope.idioma}">
    <fmt:setLocale value="${sessionScope.idioma}" scope="session" /> 
</c:if>

<fmt:setBundle basename="pixup" var="bundle" scope="application" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Pixup Discos</title>
    </head>
    <body align="center">
        <h1><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.cabecera" /></h1>
        <c:if test="${not empty requestScope.error}">
            <p style="color: red">
                <c:out value="${requestScope.error}" />
            </p>
        </c:if>
        <form action="<c:url value="/discosadmin" />" method="POST" >
            <c:set var="discoAtributo" value="${requestScope.discoAtributo}" />
            <c:set var="action" value="${requestScope.action}" />
            <c:if test="${not empty requestScope.action}">
                <input type="hidden" name="action" value="edit" />
            </c:if>
            <c:if test="${empty requestScope.action}">
                <input type="hidden" name="action" value="add" />
            </c:if>
            <input type="hidden" value="${discoAtributo != null ? discoAtributo.id : null}" name="id" />
            <table align="center">
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.titulo" /></td><td><input type="text" name="titulo" value="${discoAtributo != null ? discoAtributo.titulo : null}" /></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.fecha" /></td><td><input type="text" name="fechaLanzamiento" value="${discoAtributo != null ? discoAtributo.fechaLanzamiento : null}" /></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.precio" /></td><td><input type="text" name="precio" value="${discoAtributo != null ? discoAtributo.precio : null}"  /></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.cantidad" /></td><td><input type="text" name="cantidad" value="${discoAtributo != null ? discoAtributo.cantidadDisponible : null}" /></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.idioma" /></td>
                    <td>
                        <select name="idioma">
                            <option value="-1"><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.select.seleccionarOpcion" /></option>
                            <c:set var="idiomas" value="${applicationScope.catalogo_idiomas}" />
                            <c:forEach items="${idiomas}" var="idioma">
                                <c:if test="${discoAtributo != null  && discoAtributo.idioma.id == idioma.id}">
                                    <option value="${idioma.id}" selected="true"><c:out value="${idioma.descripcion}" /></option>
                                </c:if>
                                <c:if test="${discoAtributo.idioma.id != idioma.id}">
                                    <option value="${idioma.id}"><c:out value="${idioma.descripcion}" /></option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.pais" /></td>
                    <td>
                        <select name="pais">
                            <option value="-1"><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.select.seleccionarOpcion" /></option>
                            <c:set var="paises" value="${applicationScope.catalogo_pais}" />
                            <c:forEach items="${paises}" var="pais">
                                <c:if test="${discoAtributo != null  && discoAtributo.pais.id == pais.id}">
                                    <option value="${pais.id}" selected="true"><c:out value="${pais.nombre}" /></option>
                                </c:if>
                                <c:if test="${discoAtributo.pais.id != pais.id}">
                                    <option value="${pais.id}"><c:out value="${pais.nombre}" /></option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.genero" /></td>
                    <td>
                        <select name="genero_musical">
                            <option value="-1"><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.select.seleccionarOpcion" /></option>
                            <c:set var="generos_musicales" value="${applicationScope.catalogo_genero_musical}" />
                            <c:forEach items="${generos_musicales}" var="genero">
                                <c:if test="${discoAtributo != null  && discoAtributo.generoMusical.id == genero.id}">
                                    <option value="${genero.id}" selected="true"><c:out value="${genero.nombre}" /></option>
                                </c:if>
                                <c:if test="${discoAtributo.generoMusical.id != genero.id}">
                                    <option value="${genero.id}"><c:out value="${genero.nombre}" /></option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.disquera" /></td>
                    <td>
                        <select name="disquera">
                            <option value="-1"><fmt:message bundle="${bundle}" key="etiqueta.disco.admin.select.seleccionarOpcion" /></option>
                            <c:set var="disqueras" value="${applicationScope.catalogo_disquera}" />
                            <c:forEach items="${disqueras}" var="disquera">
                                <c:if test="${discoAtributo != null  && discoAtributo.disquera.id == disquera.id}">
                                    <option value="${disquera.id}" selected="true"><c:out value="${disquera.nombre}" /></option>
                                </c:if>
                                <c:if test="${discoAtributo.disquera.id != disquera.id}">
                                    <option value="${disquera.id}"><c:out value="${disquera.nombre}" /></option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="<fmt:message bundle="${bundle}" key="etiqueta.disco.admin.boton.aceptar" />" />
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
                            <a href="<c:url value="/discosadmin?action=get&idDisco=${disco.id}" />">Editar</a>
                            <a href="<c:url value="/discosadmin?action=delete&idDisco=${disco.id}" />">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h3>Idiomas Disponibles</h3>
        <a href="<c:url value="/Locale?idioma=en_US" />">Inglés</a>
        <a href="<c:url value="/Locale?idioma=es_MX" />">Español</a>
        <a href="<c:url value="/Locale?idioma=it_IT" />">Italiano</a>
    </body>
</html>
