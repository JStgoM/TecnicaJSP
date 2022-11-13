<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Login</title>
</head>

<body>
<center>
    <div class="container mt-5">
        <form method="post" action="ControladorLogin">
            <div class="card" style="width: 30rem;">
            <div class="card-body">
                <h4>Iniciar sesión</h4>
                <input type="text" id="nombre" name="nombre" class="form-control pt-2" placeholder="Ingresa usuario" required>
                <input type="text" id="password" name="password" class="form-control pt-2" placeholder="Ingresa contraseña" required>
                <input type="submit" id="accion" class="btn btn-primary btn-block mt-2" name="accion" value="Ingresar">
            </div>
        </div>
        </form>
    </div>
</center>
</body>
</html>
