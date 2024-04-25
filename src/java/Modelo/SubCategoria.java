/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alex
 */
public class SubCategoria {
    private int idSub;
    private int idCategoria;
    private String nombre;
    private int contador;

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    public static class Builder {
        private SubCategoria subcategoria;
        
        public Builder(){
            subcategoria = new SubCategoria();
        }
        
        public Builder idSub(int idSub){
            this.subcategoria.idSub = idSub;
            return this;
        }
        
        public Builder idCategoria(int idCategoria){
            this.subcategoria.idCategoria = idCategoria;
            return this;
        }
        
        
        public Builder nombre(String nombre){
            this.subcategoria.nombre = nombre;
            return this;
        }
        
        public Builder contador(int contador){
            this.subcategoria.contador = contador;
            return this;
        }
        
        public SubCategoria build(){
            return subcategoria;
        }
    }
}
