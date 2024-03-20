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
public class StockVenta {
    private Long id;
    private Integer codigo;
    private String detalle;
    private Float stock;
    private Float cantidad;

    public StockVenta() {
    }

    public StockVenta(Long id, Integer codigo, String detalle, Float stock, Float cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.detalle = detalle;
        this.stock = stock;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
}
