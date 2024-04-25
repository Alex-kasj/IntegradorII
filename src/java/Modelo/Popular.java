/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alex
 */
public class Popular {
    private int idSub;
    private int contador;
    private String nombreSub;
    private String nombreCat;

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNombreSub() {
        return nombreSub;
    }

    public void setNombreSub(String nombreSub) {
        this.nombreSub = nombreSub;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }
    
    public static class Builder {
        private Popular popular;
        
        public Builder(){
            popular = new Popular();
        }
        
        public Builder idSub(int idSub){
            this.popular.idSub = idSub;
            return this;
        }
        
        public Builder contador(int contador){
            this.popular.contador = contador;
            return this;
        }
        
        public Builder nombreSub(String nombreSub){
            this.popular.nombreSub = nombreSub;
            return this;
        }
        
        public Builder nombreCat(String nombreCat){
            this.popular.nombreCat = nombreCat;
            return this;
        }
        
        public Popular build(){
            return popular;
        }
    }
}
