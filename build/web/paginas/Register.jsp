<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="../styles/style.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"/>
    </head>
    <body style="font-size: 22px; font-family: Roboto;">
        <script>
            function ValidarRegister() {
                let nom = document.frmReg.nombre.value;
                let ape = document.frmReg.apellido.value;
                let cor = document.frmReg.email.value;
                let dni = document.frmReg.dni.value;
                let pass = document.frmReg.pass.value;

                if (cor == 0) {
                    alert("El correo es necesario");
                    return 0;
                } else if (pass == 0) {
                    alert("La contraseña es obligatoria");
                    return 0;
                } else if (nom == 0) {
                    alert("El nombre es obligatorio");
                    return 0;
                } else if (ape == 0) {
                    alert("El apellido es obligatorio");
                    return 0;
                } else if (dni == 0) {
                    alert("El dni es obligatorio");
                    return 0;
                } else if (isNaN(nom) == false) {
                    alert("El nombre no debe ser numerico");
                    return 0;
                } else if (isNaN(ape) == false) {
                    alert("El apellido no debe ser numerico");
                    return 0;
                } else {
                    document.frmReg.submit();
                }
            }
        </script>
        <div class="container">
            <div class="abs-center">

                <form name="frmReg" class="form" action="../RegistrarUsuario" method="POST">
                    <div class="row g-3">
                        <div>
                            <h1>
                                Registrar
                            </h1>
                            <br>
                        </div>
                        <div class="col-md-6 form-floating mb-2">
                            <input type="text" class="form-control bg-success-subtle" id="floatingInput" placeholder="Nombre" name="nombre">
                            <label for="floatingInput">Nombre</label>
                        </div>

                        <div class="col-md-6 form-floating mb-2 ">
                            <input type="number" class="form-control bg-success-subtle" id="floatingInput" placeholder="DNI" name="dni">
                            <label for="floatingInput">DNI</label>
                        </div>
                        <div class="col-md-6 form-floating mb-2">
                            <input type="text" class="form-control bg-success-subtle" id="floatingInput" placeholder="Apellido" name="apellido">
                            <label for="floatingInput">Apellido</label>
                        </div>
                        <div class="col-md-12 form-floating mb-2 ">
                            <input type="email" class="form-control bg-success-subtle" id="floatingInput" placeholder="nombre@ejemplo.com" name="email">
                            <label for="floatingInput">Correo electronico</label>
                        </div>
                        <div class="col-md-12 form-floating">
                            <input type="password" class="form-control bg-success-subtle" id="floatingPassword" placeholder="Password" name="pass">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <br>
                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                                <label class="form-check-label" for="invalidCheck2">
                                    Agree to terms and conditions
                                </label>
                            </div>
                            
                        </div>

                        <div class="d-grid gap-2">
                            <input onclick="ValidarRegister()" type="button" class="btn btn-outline-success" value="Registrarse"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>