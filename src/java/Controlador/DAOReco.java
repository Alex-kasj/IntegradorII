/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alex
 */
public class DAOReco {

    Conexion conexion = Conexion.getInstance();
    Connection cnn = conexion.getConnection();

    public List<Recomendacion> obtenerRecomendacion(int id) throws SQLException {
        List<Recomendacion> listarecomendacion = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Recomendacion WHERE IdSub=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idreco = rs.getInt(1);
            int idSubCat = rs.getInt(2);
            String nombre = rs.getString(3);
            String direccion = rs.getString(4);
            Recomendacion r = new Recomendacion.Builder()
                    .idReco(idreco)
                    .idSub(idSubCat)
                    .nombre(nombre)
                    .direccion(direccion)
                    .build();
            listarecomendacion.add(r);

        }
        aumentarSubCategoria(id);
        stmt.close();
        return listarecomendacion;
    }

    public void aumentarSubCategoria(int idSub) throws SQLException {
        String sql = "update SubCategoria set contador = contador+1 where IdSub=?";
        try {
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, idSub);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
        conexion.close();
    }

    public List<Recomendacion> obtenerRecoEspe(int id) throws SQLException {
        List<Recomendacion> listarecomendacion = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Recomendacion WHERE IdReco=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idreco = rs.getInt(1);
            int idSubCat = rs.getInt(2);
            String nombre = rs.getString(3);
            String direccion = rs.getString(4);
            Recomendacion r = new Recomendacion.Builder()
                    .idReco(idreco)
                    .idSub(idSubCat)
                    .nombre(nombre)
                    .direccion(direccion)
                    .build();
            listarecomendacion.add(r);

        }
        aumentarSubCategoria(id);
        stmt.close();
        return listarecomendacion;
    }

    public void registrarFeedBack(int reco, int iduser) throws SQLException {
        String sql = "Insert into FeedBack Values(?,?,?,?,?)";
        Statement set = conexion.getConnection().createStatement();
        PreparedStatement pasar = conexion.getConnection().prepareStatement(sql);
        int cod = obtenerCodigoFeed();
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Convertir LocalDate a java.sql.Date
        java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);
        pasar.setInt(1, cod);
        pasar.setInt(2, reco);
        pasar.setInt(3, iduser);
        pasar.setDate(4,fechaSQL);
        pasar.setInt(5, 1);
        pasar.executeUpdate();
        conexion.close();
    }

    public int obtenerCodigoFeed() {
        int cod = 1;
        //Obtiene el último codigo de usuario y suma +1
        String sql = "SELECT MAX(IdFeed)+1 from FeedBack;";
        try {
            Statement stmt = conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Guarda el codigo nuevo en un String
            while (rs.next()) {
                cod = rs.getInt(1);

            }
            stmt.close();
            conexion.close();
        } catch (Exception ex) {

        }

        return cod;
    }

    public int retornaIdUser(String correo) {
        int r = 0;
        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            st = conexion.getConnection().prepareStatement("SELECT IdUser FROM Usuario WHERE correo=?");
            st.setString(1, correo);
            rs = st.executeQuery();
            if (rs.next() == true) {
                r = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        conexion.close();
        return r;
    }

    public boolean obtenerTipoAct(int id) throws SQLException {
        boolean definir = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT A.IdActividad FROM Recomendacion R INNER JOIN SubCategoria SC ON R.IdSub = SC.IdSub "
                + "INNER JOIN Categoria C ON SC.IdCategoria = C.IdCategoria "
                + "INNER JOIN Actividad A ON A.IdActividad = C.IdActividad WHERE IdReco = ?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int idActividad = rs.getInt(1);
            if (idActividad == 1) {
                definir = true;
            } else {
                definir = false;
            }
        }
        return definir;
    }

}
