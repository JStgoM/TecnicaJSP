<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a style="color:white" class="nav-link">Bienvenido ${nombre}</a>
            <div class="dropdown">
                <a href="ControladorLogin?accion=salir" style=" color:white" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar sesión</a>
            </div>
        </nav>
        <h1>Ventas</h1>
        <a class="w-9 p-3 badge badge-dark" href="ControladorProductos?accion=nuevo">Añadir Producto</a>
        <br /><br />
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Existencia</th>
                    <th scope="col">Precio</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${lista}">
                    <tr>
                        <td><c:out value="${producto.codigo}"></c:out></td>
                        <td><c:out value="${producto.nombre}"></c:out></td>
                        <td><c:out value="${producto.existencia}"></c:out></td>
                        <td><c:out value="${producto.precio}"></c:out></td>
                        <td><a href="ControladorProductos?accion=editar&idproducto=<c:out value="${producto.idproducto}" />">
                                Editar</a></td>
                        <td><a href="ControladorProductos?accion=borrar&idproducto=<c:out value="${producto.idproducto}" />">
                                Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
