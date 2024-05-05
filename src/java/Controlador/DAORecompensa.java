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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alex
 */
public class DAORecompensa {

    Conexion conexion = Conexion.getInstance();
    Connection cnn = conexion.getConnection();

    public List<Recompensa> obtenerRecompensas() throws SQLException {
        List<Recompensa> listarecomp = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Recompesas";
        stmt = cnn.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            int idRecompensa = rs.getInt(1);
            String nombre = rs.getString(2);
            double puntos = rs.getDouble(3);
            String codigo = rs.getString(4);

            Recompensa rem = new Recompensa.Builder()
                    .idRecompensa(idRecompensa)
                    .nombre(nombre)
                    .puntos(puntos)
                    .codigo(codigo)
                    .build();
            listarecomp.add(rem);

        }
        stmt.close();
        return listarecomp;
    }
    
    public double obtenerPuntos(int id) throws SQLException {
        double puntos = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT Puntos FROM Recompesas WHERE idRecompensa=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next() == true) {
            puntos = rs.getDouble(1);
        } else {
            puntos = 0;
        }
        stmt.close();
        return puntos;
    }
    
    public List<Recompensa> cuponRecompensa(int id) throws SQLException {
        List<Recompensa> listarecomp = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Recompesas where idRecompensa=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            int idRecompensa = rs.getInt(1);
            String nombre = rs.getString(2);
            double puntos = rs.getDouble(3);
            String codigo = rs.getString(4);

            Recompensa rem = new Recompensa.Builder()
                    .idRecompensa(idRecompensa)
                    .nombre(nombre)
                    .puntos(puntos)
                    .codigo(codigo)
                    .build();
            listarecomp.add(rem);

        }
        stmt.close();
        return listarecomp;
    }
}
