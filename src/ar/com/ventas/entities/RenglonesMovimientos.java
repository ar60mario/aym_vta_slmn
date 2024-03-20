/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class RenglonesMovimientos {
    private Long id;
    private String tipoComprobante;
    private Date fecha;
    private Integer cantidad;
    private Integer numeroComprobante;
    private Integer codigoProducto;
    private String nombreProducto;
    private String codigoCliente;
    private String nombreCliente;

    public RenglonesMovimientos() {
    }

    public RenglonesMovimientos(Long id, String tipoComprobante, Date fecha, Integer cantidad, Integer numeroComprobante, Integer codigoProducto, String nombreProducto, String codigoCliente, String nombreCliente) {
        this.id = id;
        this.tipoComprobante = tipoComprobante;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.numeroComprobante = numeroComprobante;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
