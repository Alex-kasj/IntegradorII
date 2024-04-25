<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/style.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <style>
            header.masthead {
                padding-top: 10.5rem;
                padding-bottom: 6rem;
                text-align: center;
                color: #000000;
                background-image: url("img/LOGO.png");
                background-repeat: no-repeat;
                background-attachment: scroll;
                background-position: center center;
                background-size: cover;
            }
            @media (min-width: 768px) {
                header.masthead {
                    padding-top: 17rem;
                    padding-bottom: 12.5rem;
                }

            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"/>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <title>Login</title>
    </head>
    <header class="masthead">
        <div class="container">
            <body style="font-size: 22px; font-family: Roboto;">
                <script>
                    function ValidarLogin() {
                        let corr = document.frmLog.txtNom.value;
                        let pass = document.frmLog.txtCla.value;

                        if (corr == 0) {
                            alert("El correo es necesario");
                            return 0;
                        } else if (pass == 0) {
                            alert("La contraseña es obligatoria");
                            return 0;
                        } else {
                            document.frmLog.submit();
                        }
                    }
                </script>
                <section class="mb-5 mt-5"> 
                    <div align="center">
                        <section class="card" style="width: 25rem;">
                            <form name="frmLog" action="LoginConexion" method="POST" class="form card-body">
                                <h4 class="mb-5" style="text-align: center;"><b>INICIAR SESIÓN</b></h4>
                                <div class="texto-reclamos">
                                    <label for="txtNom">Correo de usuario</label>
                                    <input id="cod" class="form-control" type="text" name="txtNom" placeholder="Ingrese su Correo"><br>	
                                    <label for="txtCla">Contraseña</label>
                                    <input id="nombre" class="form-control" type="password" name="txtCla" placeholder="Ingrese su Contraseña"><br>
                                    <input onclick="ValidarLogin()" class="btn btn-secondary mb-2" type="button" name="aceptar" value="Aceptar">
                                    <br/>
                                    <a style="font-size: 17px;" href="paginas/Register.jsp">Registrate aqui</a>
                                    <a style="font-size: 17px;" href="paginas/Olvidar.jsp">¿Olvidaste tu contraseña?</a>
                                </div>
                            </form>
                        </section>
                    </div>
                </section>
            </body>
        </div>
    </header>
</html>
