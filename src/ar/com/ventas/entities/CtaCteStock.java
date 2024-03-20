/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class CtaCteStock {
    private Long id;
    private Date fecha;
    private Date fechaSistema;
    private String letra;
    private Integer sucursal;
    private Integer numero;
    private Float cantidad;
    private Proveedor proveedor;
    private Producto producto;
    private Usuario usuario;
    private Long comprobante;

    public CtaCteStock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getComprobante() {
        return comprobante;
    }

    public void setComprobante(Long comprobante) {
        this.comprobante = comprobante;
    }

    public CtaCteStock(Long id, Date fecha, Date fechaSistema, String letra, Integer sucursal, Integer numero, Float cantidad, Proveedor proveedor, Producto producto, Usuario usuario, Long comprobante) {
        this.id = id;
        this.fecha = fecha;
        this.fechaSistema = fechaSistema;
        this.letra = letra;
        this.sucursal = sucursal;
        this.numero = numero;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.producto = producto;
        this.usuario = usuario;
        this.comprobante = comprobante;
    }

}