/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alex
 */
public class Recompensa {
    private int idRecompensa;
    private String nombre;
    private double puntos;
    private String codigo;

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public static class Builder{
    private Recompensa recompensa;
    
    public Builder(){
        recompensa = new Recompensa();
    }
    
    public Builder idRecompensa(int idRecompensa){
        this.recompensa.idRecompensa = idRecompensa;
        return this;
    }
    
    public Builder nombre(String nombre){
        this.recompensa.nombre = nombre;
        return this;
    }
    
    public Builder puntos(double puntos){
        this.recompensa.puntos = puntos;
        return this;
    }
    
    public Builder codigo(String codigo){
        this.recompensa.codigo = codigo;
        return this;
    }
    
    public Recompensa build(){
        return recompensa;
    }
    }
}
