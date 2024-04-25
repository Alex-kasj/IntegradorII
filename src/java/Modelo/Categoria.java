/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Categoria {
    private int idCategoria;
    private int idActividad;
    private String nombre;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

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
        private Categoria categoria;
        
        public Builder(){
            categoria = new Categoria();
        }
        
        public Builder idCategoria(int idCategoria){
            this.categoria.idCategoria = idCategoria;
            return this;
        }
        
        public Builder idActividad(int idActividad){
            this.categoria.idActividad = idActividad;
            return this;
        }
        
        public Builder nombre(String nombre){
            this.categoria.nombre = nombre;
            return this;
        }
        
        public Categoria build(){
            return categoria;
        }
    }
}
