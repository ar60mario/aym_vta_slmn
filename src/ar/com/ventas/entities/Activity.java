
package ar.com.ventas.entities;

import java.util.Date;

public class Activity {
    private Long id;
    private Date fecha;
    private String letra;
    private Integer numeroSucursal;
    private Integer numeroFactura;
    private Customer customer;
    private Double gravado;
    private Double gravadoCigarrillos;
    private Double exento;
    private Double noGravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private Float porcentajeDescuentoGlobal;
    private Double descuentoGlobal;
    private Date fechaCae;
    private Long cae;
    private String textoPieFactura1;
    private String textoPieFactura2;
    private Long idVendedor;
    private Double saldoActual1;
    private Double saldoActual2;

    public Activity() {
    }

    public Activity(Long id, Date fecha, String letra, Integer numeroSucursal, Integer numeroFactura, Customer customer, Double gravado, Double gravadoCigarrillos, Double exento, Double noGravado, Double impuesto, Double iva, Double total, Float porcentajeDescuentoGlobal, Double descuentoGlobal, Date fechaCae, Long cae, String textoPieFactura1, String textoPieFactura2, Long idVendedor, Double saldoActual1, Double saldoActual2) {
        this.id = id;
        this.fecha = fecha;
        this.letra = letra;
        this.numeroSucursal = numeroSucursal;
        this.numeroFactura = numeroFactura;
        this.customer = customer;
        this.gravado = gravado;
        this.gravadoCigarrillos = gravadoCigarrillos;
        this.exento = exento;
        this.noGravado = noGravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.porcentajeDescuentoGlobal = porcentajeDescuentoGlobal;
        this.descuentoGlobal = descuentoGlobal;
        this.fechaCae = fechaCae;
        this.cae = cae;
        this.textoPieFactura1 = textoPieFactura1;
        this.textoPieFactura2 = textoPieFactura2;
        this.idVendedor = idVendedor;
        this.saldoActual1 = saldoActual1;
        this.saldoActual2 = saldoActual2;
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(Integer numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getGravadoCigarrillos() {
        return gravadoCigarrillos;
    }

    public void setGravadoCigarrillos(Double gravadoCigarrillos) {
        this.gravadoCigarrillos = gravadoCigarrillos;
    }

    public Double getExento() {
        return exento;
    }

    public void setExento(Double exento) {
        this.exento = exento;
    }

    public Double getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(Double noGravado) {
        this.noGravado = noGravado;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Float getPorcentajeDescuentoGlobal() {
        return porcentajeDescuentoGlobal;
    }

    public void setPorcentajeDescuentoGlobal(Float porcentajeDescuentoGlobal) {
        this.porcentajeDescuentoGlobal = porcentajeDescuentoGlobal;
    }

    public Double getDescuentoGlobal() {
        return descuentoGlobal;
    }

    public void setDescuentoGlobal(Double descuentoGlobal) {
        this.descuentoGlobal = descuentoGlobal;
    }

    public Date getFechaCae() {
        return fechaCae;
    }

    public void setFechaCae(Date fechaCae) {
        this.fechaCae = fechaCae;
    }

    public Long getCae() {
        return cae;
    }

    public void setCae(Long cae) {
        this.cae = cae;
    }

    public String getTextoPieFactura1() {
        return textoPieFactura1;
    }

    public void setTextoPieFactura1(String textoPieFactura1) {
        this.textoPieFactura1 = textoPieFactura1;
    }

    public String getTextoPieFactura2() {
        return textoPieFactura2;
    }

    public void setTextoPieFactura2(String textoPieFactura2) {
        this.textoPieFactura2 = textoPieFactura2;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Double getSaldoActual1() {
        return saldoActual1;
    }

    public void setSaldoActual1(Double saldoActual1) {
        this.saldoActual1 = saldoActual1;
    }

    public Double getSaldoActual2() {
        return saldoActual2;
    }

    public void setSaldoActual2(Double saldoActual2) {
        this.saldoActual2 = saldoActual2;
    }
    
}