<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.*" %>
<%@ page import="Controlador.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/style.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"/>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <style>
            .container {
                position: absolute;
                top:60%;
                left: 50%;
                transform: translate(-50%,-50%);
                max-width: max-content;
                height: max-content;
                text-align: center;

            }
            .card{
                height: max-content;
                max-width: max-content;
                margin: 10%;

            }
        </style>
        <title>Recompensas</title>

    </head>
    <body class="cuadro">
        <nav class="navbar navbar-expand-lg bg-white navbar">
            <div class="container-fluid">
                <a class="navbar-brand" href=""><img style="width: 170px;" id="logo" src="../img/LOGO.png" alt="alt"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Actividad.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Feedback.jsp">Feedback</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Popular.jsp">Populares</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Recompensas.jsp">Recompensas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../CerrarSesion">CERRAR SESION</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <%
                Usuario user = (Usuario) session.getAttribute("usuario");
                String correo = user.getNombre();
                AccesoDatos access = new AccesoDatos();
                double puntos = access.obtenerPuntos(correo);
            %>
            <h1> PUNTOS ACUMULADOS: <%= puntos%> </h1>
            <script>
                function Validar() {
                    tableCanje.submit();
                }
            </script>
            <form name="tableCanje" action="../Canjear" method="POST">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Canjear</th>
                            <th scope="col">Puntos</th>
                            <th scope="col">Click</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            DAORecompensa daorecom = new DAORecompensa();
                            List<Recompensa> recompensas = daorecom.obtenerRecompensas();
                            for (Recompensa recompensa : recompensas) {
                        %>
                        <tr>
                            <th scope="row"><%= recompensa.getIdRecompensa()%></th>
                            <td><%= recompensa.getNombre()%></td>
                            <td><%= recompensa.getPuntos()%></td>
                            <input type="hidden" name="idRecompensa" value="<%= recompensa.getIdRecompensa()%>">
                            <td><a onclick="Validar()" class="btn btn-primary">Canjear</a></td>
                        </tr>
                        <%
                            }

                        %>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
