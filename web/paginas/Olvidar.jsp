<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/style.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"/>

        <title>Recuperar contraseña</title>
    </head>
    <body style="font-size: 22px; font-family: Roboto;">
        <main>
            <section class="container mt-5">
                <div align="center">
                    <section class="card" style="width: 25rem;">

                        <form name="frmOlv" action="../UpdateUsuario" method="POST" class="card-body">
                            <h4 class="mb-5 mt-3" style="text-align: center;"><b>Recuperar Contraseña</b></h4>
                            <div>
                                <label for="txtNom">Correo de usuario</label>
                                <div class="input-group mb-3">
                                    <p style="font-size: 18px;">Se enviará un email al usuario para confirmar su identidad</p>
                                    <input type="text" class="form-control" id="cod" name="txtNom" placeholder="Usuario" aria-label="Usuario" aria-describedby="button-addon2">
                                    <button class="btn btn-outline-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" id="button-addon2" aria-expanded="false" aria-controls="collapseWidthExample">
                                        Validar
                                    </button>

                                    <div class="mt-3">
                                        <div class="collapse collapse-horizontal" id="collapseWidthExample">
                                            <div class="" style="font-size: 18px;">
                                                <p style="color: green">Correo validado correctamente! Ingresa nueva contraseña para cambiarla.</p>
                                                <label for="txtCla">Nueva Contraseña</label>
                                                <input class="form-control" type="password" name="txtCla" placeholder="Contraseña"><br>
                                                <input class="btn btn-secondary mb-2" type="submit" name="aceptar" value="   Aceptar   ">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <a style="font-size: 17px;" href="Register.jsp">¿Aùn no tienes cuenta? Registrate aquì</a>

                            </div>
                        </form>
                    </section>
                </div>
            </section>
        </main>

    </body>
</html>
