/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alex
 */
public class Recomendacion {
    private int idReco;
    private int idSub;
    private String nombre;
    private String direccion;

    public int getIdReco() {
        return idReco;
    }

    public void setIdReco(int idReco) {
        this.idReco = idReco;
    }

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
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
        private Recomendacion recomendacion;
        
        public Builder(){
            recomendacion = new Recomendacion();
        }
        
        public Builder idReco(int idReco){
            this.recomendacion.idReco = idReco;
            return this;
        }
        
        public Builder idSub(int idSub){
            this.recomendacion.idSub = idSub;
            return this;
        }
        
        public Builder nombre(String nombre){
            this.recomendacion.nombre = nombre;
            return this;
        }
        
        public Builder direccion(String direccion){
            this.recomendacion.direccion = direccion;
            return this;
        }
        
        public Recomendacion build(){
            return recomendacion;
        }
    }
    
}
