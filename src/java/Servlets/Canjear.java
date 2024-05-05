package Servlets;

import ConcreteStrategy.*;
import ConcreteStrategy.Logearse;
import Controlador.AccesoDatos;
import Controlador.DAORecompensa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;

@WebServlet(name = "Canjear", urlPatterns = {"/Canjear"})
public class Canjear extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //Trae el id de recompensa de Recompensas jsp
            String idRecompensa = request.getParameter("idRecompensa");
            int idReco = Integer.parseInt(idRecompensa);
            //obtiene la session y agarra el correo del usuario
            HttpSession session = request.getSession(); 
            Usuario user = (Usuario) session.getAttribute("usuario");
            String correo = user.getNombre();
            //obtiene los puntos del ususario
            AccesoDatos access = new AccesoDatos();
            double puntosUser = access.obtenerPuntos(correo);
            //obtiene los puntos de la recompensa
            DAORecompensa daorecom = new DAORecompensa();
            double puntosRecom = daorecom.obtenerPuntos(idReco);
            System.out.println("PASE AL IF");
            
            if(puntosUser >= puntosRecom){
                access.quitarPuntos(puntosRecom, correo);
                String url = "paginas/Cupon.jsp?idRecompensa="+idRecompensa;
                System.out.println(url);
                response.sendRedirect(url);
            }else{
                response.sendRedirect("paginas/Recompensas.jsp?");
            }
           
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
}
