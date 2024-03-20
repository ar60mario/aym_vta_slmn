
package ar.com.ventas.entities;

import java.util.Date;

public class Routines {
    private Long id;
    private Float iva;
    private Integer sucursal;
    private Integer numeroFactura;
    private Integer numeroRecibo;
    private Integer numeroPedido;
    private Integer cantidadFacturas;
    private Integer cantidadPedidos;
    private Integer cantidadNotasCredito;
    private Integer cantidadRecibos;
    private Date ultimaFechaCierre;
    private Date ultimaFechaSistema;
    private Boolean cajaAnteriorCerrada;
    
    public Routines() {
    }

    public Routines(Long id, Float iva, Integer sucursal, Integer numeroFactura, Integer numeroRecibo, Integer numeroPedido, Integer cantidadFacturas, Integer cantidadPedidos, Integer cantidadNotasCredito, Integer cantidadRecibos, Date ultimaFechaCierre, Date ultimaFechaSistema, Boolean cajaAnteriorCerrada) {
        this.id = id;
        this.iva = iva;
        this.sucursal = sucursal;
        this.numeroFactura = numeroFactura;
        this.numeroRecibo = numeroRecibo;
        this.numeroPedido = numeroPedido;
        this.cantidadFacturas = cantidadFacturas;
        this.cantidadPedidos = cantidadPedidos;
        this.cantidadNotasCredito = cantidadNotasCredito;
        this.cantidadRecibos = cantidadRecibos;
        this.ultimaFechaCierre = ultimaFechaCierre;
        this.ultimaFechaSistema = ultimaFechaSistema;
        this.cajaAnteriorCerrada = cajaAnteriorCerrada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Integer getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(Integer numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Integer getCantidadFacturas() {
        return cantidadFacturas;
    }

    public void setCantidadFacturas(Integer cantidadFacturas) {
        this.cantidadFacturas = cantidadFacturas;
    }

    public Integer getCantidadPedidos() {
        return cantidadPedidos;
    }

    public void setCantidadPedidos(Integer cantidadPedidos) {
        this.cantidadPedidos = cantidadPedidos;
    }

    public Integer getCantidadNotasCredito() {
        return cantidadNotasCredito;
    }

    public void setCantidadNotasCredito(Integer cantidadNotasCredito) {
        this.cantidadNotasCredito = cantidadNotasCredito;
    }

    public Integer getCantidadRecibos() {
        return cantidadRecibos;
    }

    public void setCantidadRecibos(Integer cantidadRecibos) {
        this.cantidadRecibos = cantidadRecibos;
    }

    public Date getUltimaFechaCierre() {
        return ultimaFechaCierre;
    }

    public void setUltimaFechaCierre(Date ultimaFechaCierre) {
        this.ultimaFechaCierre = ultimaFechaCierre;
    }

    public Date getUltimaFechaSistema() {
        return ultimaFechaSistema;
    }

    public void setUltimaFechaSistema(Date ultimaFechaSistema) {
        this.ultimaFechaSistema = ultimaFechaSistema;
    }

    public Boolean getCajaAnteriorCerrada() {
        return cajaAnteriorCerrada;
    }

    public void setCajaAnteriorCerrada(Boolean cajaAnteriorCerrada) {
        this.cajaAnteriorCerrada = cajaAnteriorCerrada;
    }
    
}