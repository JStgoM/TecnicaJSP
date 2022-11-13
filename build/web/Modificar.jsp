<%-- 
    Document   : Modificar
    Created on : 12 nov 2022, 19:22:03
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Modificar</title>
    </head>
    <body>
    <center>
        <form action="ControladorProductos?accion=actualizar" method="POST" autocomplete="off">
            <div class="card" style="width: 20rem;">
                <div class="card-body">
                    <h2>Editar Registro</h2>
                    <input class="form-control pt-2" id="idproducto" type="hidden" name="idproducto" value="<c:out value="${producto.idproducto}"/>"/>
                    <p>
                        Código:
                        <input class="form-control pt-2" id="codigo" type="text" name="codigo" value="<c:out value="${producto.codigo}"/>"/>
                    </p>
                    <p>
                        Nombre:
                        <input class="form-control pt-2" id="nombre" type="text" name="nombre" value="<c:out value="${producto.nombre}"/>"/>
                    </p>
                    <p>
                        Existencia:
                        <input class="form-control pt-2" id="existencia" type="number" name="existencia" value="<c:out value="${producto.existencia}"/>"/>
                    </p>
                    <p>
                        Precio:
                        <input class="form-control pt-2" id="precio" type="number" name="precio" value="<c:out value="${producto.precio}"/>"/>
                    </p>
                    <button name="modificar" id="modificar" type="submit">Guardar</button>
                </div>
            </div>
        </form>
    </center>
    </body>
</html>
