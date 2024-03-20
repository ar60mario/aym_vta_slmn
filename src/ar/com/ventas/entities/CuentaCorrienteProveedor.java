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
public class CuentaCorrienteProveedor {
    private Long id;
    private Proveedor proveedor;
    private Double debe;
    private Double haber;
    private Double saldo;
    private ComprobanteCompras comprobante;
    private ReciboProveedor reciboProveedor;
    private Date fecha;

    public CuentaCorrienteProveedor() {
    }

    public CuentaCorrienteProveedor(Long id, Proveedor proveedor, Double debe, Double haber, Double saldo, ComprobanteCompras comprobante, ReciboProveedor reciboProveedor, Date fecha) {
        this.id = id;
        this.proveedor = proveedor;
        this.debe = debe;
        this.haber = haber;
        this.saldo = saldo;
        this.comprobante = comprobante;
        this.reciboProveedor = reciboProveedor;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ComprobanteCompras getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteCompras comprobante) {
        this.comprobante = comprobante;
    }

    public ReciboProveedor getReciboProveedor() {
        return reciboProveedor;
    }

    public void setReciboProveedor(ReciboProveedor reciboProveedor) {
        this.reciboProveedor = reciboProveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
