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
public class ListaPrecios {
    private String detalle;
    private Double precio;
    
    public ListaPrecios() {
    }

    public ListaPrecios(String detalle, Double precio) {
        this.detalle = detalle;
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
