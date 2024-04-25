/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Usuario;
import java.util.LinkedList;
import java.util.List;

public class DAOActividad {

    Conexion conexion = Conexion.getInstance();

    public List<Actividad> obtenerActividades() throws SQLException {
        List<Actividad> listaActividad = new LinkedList<>();
        Statement stmt = conexion.getConnection().createStatement();
        String sql = "SELECT * FROM Actividad";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            Actividad a = new Actividad.Builder()
                    .idActividad(id)
                    .nombre(nombre)
                    .build();
            listaActividad.add(a);

        }
        stmt.close();
        conexion.close();
        return listaActividad;
    }
}
