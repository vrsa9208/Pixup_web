<%-- 
    Document   : carrito
    Created on : 4/03/2016, 06:02:02 PM
    Author     : JAVA-08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <td class="image">Item</td>
                        <td class="description"></td>
                        <td class="price">Price</td>
                        <td class="quantity">Quantity</td>
                        <td class="total">Total</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="carrito" value="${sessionScope.carrito}" />
                    <c:if test="${not empty carrito}">
                        <c:forEach items="${carrito.discos}" var="disco">
                            <tr>
                                <c:if test="${not empty disco.rutaImagen}">
                                <td class="cart_product">
                                    <a href=""><img src="<c:url value="${disco.rutaImagen}" />" alt=""></a>
                                </td>
                                </c:if>
                                <c:if test="${empty disco.rutaImagen}">
                                <td class="cart_product">
                                    <a href=""><img src="http://placehold.it/300x300" alt=""></a>
                                </td>
                                </c:if>
                                <td class="cart_description">
                                    <h4><a href=""><c:out value="${disco.titulo}" /></a></h4>
                                    <p>Web ID: 1089772</p>
                                </td>
                                <td class="cart_price">
                                    <p><c:out value="${disco.precio}" /></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href=""> + </a>
                                        <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                                        <a class="cart_quantity_down" href=""> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><c:out value="${disco.precio}" /></p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</section> <!--/#cart_items-->