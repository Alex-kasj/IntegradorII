package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Usuario;

public class AccesoDatos {

    Conexion conexion = Conexion.getInstance();

    //Login
    public int Buscar(String n, String c) throws SQLException {
        int r = 0;
        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            st = conexion.getConnection().prepareStatement("SELECT correo,contra FROM Usuario WHERE correo=? AND contra=?");
            st.setString(1, n);
            st.setString(2, c);
            rs = st.executeQuery();
            if (rs.next() == true) {
                r = 1;
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        conexion.close();
        return r;
    }

    //Register
    public void registrarUsuario(int cod,String nom, String ape, String pass, String dni, String email) throws SQLException {
        String sql = "Insert into Usuario Values(?,?,?,?,?,?)";
        Statement set = conexion.getConnection().createStatement();
        PreparedStatement pasar = conexion.getConnection().prepareStatement(sql);
        pasar.setInt(1, cod);
        pasar.setString(2, nom);
        pasar.setString(3, ape);
        pasar.setString(4, pass);
        pasar.setString(5, dni);
        pasar.setString(6, email);
        pasar.executeUpdate();
        conexion.close();

    }

    public int obtenerCodigo() {
        int cod = 1;
        //Obtiene el último codigo de usuario y suma +1
        String sql = "SELECT MAX(IdUser)+1 from Usuario;";
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
    /*
    //obtener el estado del usuario
    public int obtenerEstado(String n, String c) {
        int cod=0;
        //Obtiene el último codigo de usuario y suma +1
        String sql = "SELECT rol_id from usuarios WHERE emailusu='"+ n +"' AND passusu='" + c + "';";
        
        try {
            Statement stmt = conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Guarda el codigo nuevo en un String
            while (rs.next()) {
                cod = rs.getInt(1);

            }
            stmt.close();
        } catch (Exception ex) {

        }
        return cod;
    }
    */
    //Olvidaste Contraseña
    public void updateUsuario(String correo, String clave) throws SQLException {
        //Actualiza passusu de la tabla usuarios
        String sql = "UPDATE Usuario SET contra=? WHERE correo=?";
        try {
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setString(1, clave);
            ps.setString(2, correo);
            //Ejecuta la consulta
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
        conexion.close();
    }
    /*
    //Busca usuario por carreo
    public ArrayList<String> buscaUsuario(String correo) throws SQLException {
        ArrayList usu = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE emailusu=?";
            stmt = conexion.getConnection().prepareStatement(sql);
            stmt.setString(1, correo);
            rs = stmt.executeQuery();
            usu = new ArrayList<>();
            if (rs.next()) {
                usu.add(rs.getString(1));
                usu.add(rs.getString(2));
                usu.add(rs.getString(3));
                usu.add(rs.getString(4));
                usu.add(rs.getString(5));
                usu.add(rs.getString(6));
                usu.add(rs.getString(7));
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            conexion.close();
        }

        return usu;
    }
     */
}
