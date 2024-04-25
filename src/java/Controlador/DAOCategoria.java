/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alex
 */
public class DAOCategoria {
    
    Conexion conexion = Conexion.getInstance();
    Connection cnn = conexion.getConnection();
    
    public List<Categoria> obtenerCategoria(int id) throws SQLException {
        List<Categoria> listaCategoria = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Categoria WHERE IdActividad=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idCat = rs.getInt(1);
            int idAct = rs.getInt(2);
            String nombre = rs.getString(3);

            Categoria c = new Categoria.Builder()
                    .idActividad(idAct)
                    .idCategoria(idCat)
                    .nombre(nombre)                   
                    .build();
            listaCategoria.add(c);

        }

        stmt.close();
        return listaCategoria;
    }
}
