<%-- 
    Document   : Nuevo
    Created on : 12 nov 2022, 18:46:58
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Agregar</title>
    </head>
    <body>
    <center>
        <div class="card" style="width: 20rem;">
            <div class="card-body">
                <h2 class="mx-auto" style="width: 300px;">Nuevo Registro</h2>
                <form class="mx-auto" action="ControladorProductos?accion=agregar" method="POST" autocomplete="off">
                    <p>
                        Código:
                        <input class="form-control pt-2" id="codigo" type="text" name="codigo" required/>
                    </p>
                    <p>
                        Nombre:
                        <input class="form-control pt-2" id="nombre" type="text" name="nombre" required/>
                    </p>
                    <p>
                        Existencia:
                        <input class="form-control pt-2" id="existencia" type="number" name="existencia" required/>
                    </p>
                    <p>
                        Precio:
                        <input class="form-control pt-2" id="precio" type="number" name="precio" required/>
                    </p>
                    <button name="guardar" id="guardar" type="submit">Guardar</button>
                </form>
            </div>
        </div>
    </center>
</body>
</html>
