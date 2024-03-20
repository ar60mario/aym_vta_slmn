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
public class ProductoStockOrder implements Comparable<ProductoStockOrder> {
    private Integer orden;
    private Integer codigo;
    private String Detalle;
    private Float cantidad;
    private Float stock;
    private Float total;
    private Float minimo;

    public ProductoStockOrder() {
    }

    public ProductoStockOrder(Integer orden, Integer codigo, String Detalle, Float cantidad, Float stock, Float total, Float minimo) {
        this.orden = orden;
        this.codigo = codigo;
        this.Detalle = Detalle;
        this.cantidad = cantidad;
        this.stock = stock;
        this.total = total;
        this.minimo = minimo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getMinimo() {
        return minimo;
    }

    public void setMinimo(Float minimo) {
        this.minimo = minimo;
    }
    
    @Override
    public int compareTo(ProductoStockOrder o) {
        Integer a = this.getCodigo();
        Integer b = o.getCodigo();
        return a.compareTo(b);
    }
}