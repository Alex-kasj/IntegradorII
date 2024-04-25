/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alex
 */
public class Actividad {
    private int idActividad;
    private String nombre;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static class Builder {
        
        private Actividad actividad;
        
        public Builder(){
            actividad = new Actividad();
        }
        
        public Builder idActividad(int idActividad){
            this.actividad.idActividad = idActividad;
            return this;
        }
        
        public Builder nombre(String nombre){
            this.actividad.nombre = nombre;
            return this;
        }
        
        public Actividad build(){
            return actividad;
        }
    }
    
    
}
