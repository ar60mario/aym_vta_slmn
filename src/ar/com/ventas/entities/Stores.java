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
public class Stores {

    private Long id;
    private Date fecha;
    private Date fechaAnterior;
    private Double totalFacturadoCf;
    private Double totalFacturadoOf;
    private Double saldoDeudorAnteriorCf;
    private Double saldoDeudorAnteriorOf;
    private Double subtotalArriba;
    private Double cajaInicial;
    private Double totalDeudoresHoyCf;
    private Double totalDeudoresHoyOf;
    private Double totalDeposito;
    private Double totalVales;
    private Double subtotalAbajo;
    private Double diferencia;
    private Boolean cerrado;
    private Double pagoProveedores;
    private Double cobranza;
    private Double payments;
    private Double saldosInactivosHoyCf;
    private Double saldosInactivosHoyOf;
    private Double saldosInactivosAnteriorCf;
    private Double saldosInactivosAnteriorOf;
    /*
    private Double saldoProveedoresHoy;
    private Double saldoProveedoresAnterior;
    private Double saldoCuentaCorrienteProveedoresHoy;
    private Double pagosProveedores;
*/

    public Stores() {
    }

    public Stores(Long id, Date fecha, Date fechaAnterior, Double totalFacturadoCf, Double totalFacturadoOf, Double saldoDeudorAnteriorCf, Double saldoDeudorAnteriorOf, Double subtotalArriba, Double cajaInicial, Double totalDeudoresHoyCf, Double totalDeudoresHoyOf, Double totalDeposito, Double totalVales, Double subtotalAbajo, Double diferencia, Boolean cerrado, Double pagoProveedores, Double cobranza, Double payments, Double saldosInactivosHoyCf, Double saldosInactivosHoyOf, Double saldosInactivosAnteriorCf, Double saldosInactivosAnteriorOf) {
        this.id = id;
        this.fecha = fecha;
        this.fechaAnterior = fechaAnterior;
        this.totalFacturadoCf = totalFacturadoCf;
        this.totalFacturadoOf = totalFacturadoOf;
        this.saldoDeudorAnteriorCf = saldoDeudorAnteriorCf;
        this.saldoDeudorAnteriorOf = saldoDeudorAnteriorOf;
        this.subtotalArriba = subtotalArriba;
        this.cajaInicial = cajaInicial;
        this.totalDeudoresHoyCf = totalDeudoresHoyCf;
        this.totalDeudoresHoyOf = totalDeudoresHoyOf;
        this.totalDeposito = totalDeposito;
        this.totalVales = totalVales;
        this.subtotalAbajo = subtotalAbajo;
        this.diferencia = diferencia;
        this.cerrado = cerrado;
        this.pagoProveedores = pagoProveedores;
        this.cobranza = cobranza;
        this.payments = payments;
        this.saldosInactivosHoyCf = saldosInactivosHoyCf;
        this.saldosInactivosHoyOf = saldosInactivosHoyOf;
        this.saldosInactivosAnteriorCf = saldosInactivosAnteriorCf;
        this.saldosInactivosAnteriorOf = saldosInactivosAnteriorOf;
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

    public Date getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(Date fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public Double getTotalFacturadoCf() {
        return totalFacturadoCf;
    }

    public void setTotalFacturadoCf(Double totalFacturadoCf) {
        this.totalFacturadoCf = totalFacturadoCf;
    }

    public Double getTotalFacturadoOf() {
        return totalFacturadoOf;
    }

    public void setTotalFacturadoOf(Double totalFacturadoOf) {
        this.totalFacturadoOf = totalFacturadoOf;
    }

    public Double getSaldoDeudorAnteriorCf() {
        return saldoDeudorAnteriorCf;
    }

    public void setSaldoDeudorAnteriorCf(Double saldoDeudorAnteriorCf) {
        this.saldoDeudorAnteriorCf = saldoDeudorAnteriorCf;
    }

    public Double getSaldoDeudorAnteriorOf() {
        return saldoDeudorAnteriorOf;
    }

    public void setSaldoDeudorAnteriorOf(Double saldoDeudorAnteriorOf) {
        this.saldoDeudorAnteriorOf = saldoDeudorAnteriorOf;
    }

    public Double getSubtotalArriba() {
        return subtotalArriba;
    }

    public void setSubtotalArriba(Double subtotalArriba) {
        this.subtotalArriba = subtotalArriba;
    }

    public Double getCajaInicial() {
        return cajaInicial;
    }

    public void setCajaInicial(Double cajaInicial) {
        this.cajaInicial = cajaInicial;
    }

    public Double getTotalDeudoresHoyCf() {
        return totalDeudoresHoyCf;
    }

    public void setTotalDeudoresHoyCf(Double totalDeudoresHoyCf) {
        this.totalDeudoresHoyCf = totalDeudoresHoyCf;
    }

    public Double getTotalDeudoresHoyOf() {
        return totalDeudoresHoyOf;
    }

    public void setTotalDeudoresHoyOf(Double totalDeudoresHoyOf) {
        this.totalDeudoresHoyOf = totalDeudoresHoyOf;
    }

    public Double getTotalDeposito() {
        return totalDeposito;
    }

    public void setTotalDeposito(Double totalDeposito) {
        this.totalDeposito = totalDeposito;
    }

    public Double getTotalVales() {
        return totalVales;
    }

    public void setTotalVales(Double totalVales) {
        this.totalVales = totalVales;
    }

    public Double getSubtotalAbajo() {
        return subtotalAbajo;
    }

    public void setSubtotalAbajo(Double subtotalAbajo) {
        this.subtotalAbajo = subtotalAbajo;
    }

    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Double getPagoProveedores() {
        return pagoProveedores;
    }

    public void setPagoProveedores(Double pagoProveedores) {
        this.pagoProveedores = pagoProveedores;
    }

    public Double getCobranza() {
        return cobranza;
    }

    public void setCobranza(Double cobranza) {
        this.cobranza = cobranza;
    }

    public Double getPayments() {
        return payments;
    }

    public void setPayments(Double payments) {
        this.payments = payments;
    }

    public Double getSaldosInactivosHoyCf() {
        return saldosInactivosHoyCf;
    }

    public void setSaldosInactivosHoyCf(Double saldosInactivosHoyCf) {
        this.saldosInactivosHoyCf = saldosInactivosHoyCf;
    }

    public Double getSaldosInactivosHoyOf() {
        return saldosInactivosHoyOf;
    }

    public void setSaldosInactivosHoyOf(Double saldosInactivosHoyOf) {
        this.saldosInactivosHoyOf = saldosInactivosHoyOf;
    }

    public Double getSaldosInactivosAnteriorCf() {
        return saldosInactivosAnteriorCf;
    }

    public void setSaldosInactivosAnteriorCf(Double saldosInactivosAnteriorCf) {
        this.saldosInactivosAnteriorCf = saldosInactivosAnteriorCf;
    }

    public Double getSaldosInactivosAnteriorOf() {
        return saldosInactivosAnteriorOf;
    }

    public void setSaldosInactivosAnteriorOf(Double saldosInactivosAnteriorOf) {
        this.saldosInactivosAnteriorOf = saldosInactivosAnteriorOf;
    }

}
