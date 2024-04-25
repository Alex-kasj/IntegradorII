/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author alex
 */
public class FeedBack {
    private int idFeed;
    private int idReco;
    private String nombre;
    private String direccion;
    private int idUser;
    private Date fecha;
    private int estado;
    
    public int getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(int idFeed) {
        this.idFeed = idFeed;
    }

    public int getIdReco() {
        return idReco;
    }

    public void setIdReco(int idReco) {
        this.idReco = idReco;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public static class Builder {
        private FeedBack feedback;
        
        public Builder(){
            feedback = new FeedBack();
        }
        
        public Builder idFeed(int idFeed){
            this.feedback.idFeed = idFeed;
            return this;
        }
        
        public Builder idReco(int idReco){
            this.feedback.idReco = idReco;
            return this;
        }
        
        public Builder idUser(int idUser){
            this.feedback.idUser = idUser;
            return this;
        }
        
        public Builder fecha(Date fecha){
            this.feedback.fecha = fecha;
            return this;
        }
        
        public Builder estado(int estado){
            this.feedback.estado = estado;
            return this;
        }
        
        public Builder nombre(String nombre){
            this.feedback.nombre = nombre;
            return this;
        }
        
        public Builder direccion(String direccion){
            this.feedback.direccion = direccion;
            return this;
        }
        
        public FeedBack build(){
            return feedback;
        }
        
    }
    
}
