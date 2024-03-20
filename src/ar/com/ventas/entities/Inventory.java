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
public class Inventory {
    private Long id;
    private Date fecha;
    private Double debe;
    private Double haber;
    private Double saldo;
    private Customer cliente;
    private String tipo;
    private Activity factura;
    private Activity notaCredito;
    private Payment recibo;

    public Inventory() {
    }

    public Inventory(Long id, Date fecha, Double debe, Double haber, Double saldo, Customer cliente, String tipo, Activity factura, Activity notaCredito, Payment recibo) {
        this.id = id;
        this.fecha = fecha;
        this.debe = debe;
        this.haber = haber;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipo = tipo;
        this.factura = factura;
        this.notaCredito = notaCredito;
        this.recibo = recibo;
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

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Activity getFactura() {
        return factura;
    }

    public void setFactura(Activity factura) {
        this.factura = factura;
    }

    public Activity getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(Activity notaCredito) {
        this.notaCredito = notaCredito;
    }

    public Payment getRecibo() {
        return recibo;
    }

    public void setRecibo(Payment recibo) {
        this.recibo = recibo;
    }
    
}