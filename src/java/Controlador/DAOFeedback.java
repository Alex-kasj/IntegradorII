/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alex
 */
public class DAOFeedback {
    Conexion conexion = Conexion.getInstance();
    Connection cnn = conexion.getConnection();
    
    public List<FeedBack> obtenerFeedBack(int idUser) throws SQLException {
        List<FeedBack> listaFeed = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT F.IdFeed,F.IdReco,F.IdUser,F.Fecha,F.Estado,R.nombre,R.Dirección FROM FeedBack F "
                + "INNER JOIN Recomendacion R ON F.IdReco = R.IdReco WHERE IdUser = ? and F.Estado=1;";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, idUser);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idfeed = rs.getInt(1);
            int idreco = rs.getInt(2);
            int idU = rs.getInt(3);
            Date fecha = rs.getDate(4);
            int estado = rs.getInt(5);
            String nombre = rs.getString(6);
            String direccion = rs.getString(7);
            
            FeedBack fb = new FeedBack.Builder()
                    .idFeed(idfeed)
                    .idReco(idreco)
                    .idUser(idU)
                    .fecha(fecha)
                    .estado(estado)
                    .nombre(nombre)
                    .direccion(direccion)
                    .build();
            listaFeed.add(fb);

        }
        stmt.close();
        return listaFeed;
    }
}
