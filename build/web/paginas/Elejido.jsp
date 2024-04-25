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
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDfOEw9keFk2aOoQ8V2rakpNWlIc2YNoTw&callback=initMap"></script>
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
        <title>Categoria</title>

    </head>
    <body class="cuadro" onload="initMap()">
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
                            <a class="nav-link" href="../CerrarSesion">CERRAR SESION</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <%

                int id = Integer.parseInt(request.getParameter("id"));
                Usuario user = (Usuario) session.getAttribute("usuario");
                DAOReco daorec = new DAOReco();
                boolean tipoAct = daorec.obtenerTipoAct(id);
                String correo = user.getNombre();
                int IdUser = daorec.retornaIdUser(correo);
                daorec.registrarFeedBack(id, IdUser);
                List<Recomendacion> recomendaciones = daorec.obtenerRecoEspe(id);
                // Iteramos sobre la lista de categoria y generamos un <div> para cada una
                for (Recomendacion recomendacion : recomendaciones) {
            %>
            <script>
                function initMap() {
                    var geocoder = new google.maps.Geocoder();
                    var address = "<%= recomendacion.getDireccion()%>"; // Aquí debes colocar la dirección que quieres buscar
                    geocoder.geocode({'address': address}, function (results, status) {
                        if (status === 'OK') {
                            var map = new google.maps.Map(document.getElementById('map'), {
                                zoom: 15,
                                center: results[0].geometry.location
                            });
                            var marker = new google.maps.Marker({
                                map: map,
                                position: results[0].geometry.location
                            });
                        }
                    });
                }
            </script>
            <div class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><%= recomendacion.getNombre()%></h5>
                    <%
                        if (tipoAct == true) {
                    %>
                    <p class="card-text"><%= recomendacion.getDireccion()%> se ve interesante </p>

                    <div id="map" style="height: 400px; width: 100%;"></div>  
                    <%
                    } else {
                    %>
                    <a href="<%= recomendacion.getDireccion()%>"><%= recomendacion.getDireccion()%></a>
                    <%
                        }
                    %>

                </div>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
