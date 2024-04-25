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
public class DAOSub {
        
    Conexion conexion = Conexion.getInstance();
    Connection cnn = conexion.getConnection();
    
    public List<SubCategoria> obtenerSubCategoria(int id) throws SQLException {
        List<SubCategoria> listaSubCategoria = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM SubCategoria WHERE IdCategoria=?";
        stmt = cnn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idSubCat = rs.getInt(1);
            int idCat = rs.getInt(2);
            String nombre = rs.getString(3);
            int contador = rs.getInt(4);
            SubCategoria sc = new SubCategoria.Builder()
                    .idSub(idSubCat)
                    .idCategoria(idCat)
                    .nombre(nombre)
                    .contador(contador)
                    .build();
            listaSubCategoria.add(sc);

        }

        stmt.close();
        return listaSubCategoria;
    }
    
    public List<Popular> obtenerSubPopular() throws SQLException {
        List<Popular> listaPopular = new LinkedList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT SC.IdSub,SC.contador, SC.nombre,C.Nombre FROM SubCategoria SC "
                + "inner JOIN Categoria C ON SC.IdCategoria = C.IdCategoria order by contador desc limit 10;";
        stmt = cnn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idSubCat = rs.getInt(1);
            int contador = rs.getInt(2);
            String nombreSub = rs.getString(3);
            String nombreCat = rs.getString(4);
            Popular p = new Popular.Builder()
                    .idSub(idSubCat)
                    .contador(contador)
                    .nombreSub(nombreSub)
                    .nombreCat(nombreCat)
                    .build();
            listaPopular.add(p);

        }

        stmt.close();
        return listaPopular;
    }
}
