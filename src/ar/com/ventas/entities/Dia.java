/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Mario
 */
public enum Dia {
    DOMINGO(0, "DOMINGO"),
    LUNES(1,"LUNES"),
    MARTES(2,"MARTES"),
    MIERCOLES(3,"MIERCOLES"),
    JUEVES(4,"JUEVES"),
    VIERNES(5,"VIERNES"),
    SABADO(6,"SABADO");
    
    private final Integer codigo;
    private final String detalle;
    
    Dia(Integer codigo, String detalle){
        this.codigo=codigo;
        this.detalle=detalle;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public String getDetalle(){
        return detalle;
    }
}
