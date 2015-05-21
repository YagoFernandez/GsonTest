package com.cerqueira.gson;

public class Fruta {
 
    public String nombre;
    public int unidades;
 
    public Fruta (String nombre, int unidades){
        this.nombre = nombre;
        this.unidades = unidades;
    }
    
    @Override
    public String toString() {
    	return nombre + " : " + unidades;
    }

}