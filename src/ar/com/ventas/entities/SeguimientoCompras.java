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
public class SeguimientoCompras {
    private Long id;
    private Date fecha;
    private ComprobanteCompras comprobante;
    private Boolean stock;
    private Boolean pago;
    private Boolean llevaStock;

    public SeguimientoCompras() {
    }

    public SeguimientoCompras(Long id, Date fecha, ComprobanteCompras comprobante, Boolean stock, Boolean pago, Boolean llevaStock) {
        this.id = id;
        this.fecha = fecha;
        this.comprobante = comprobante;
        this.stock = stock;
        this.llevaStock = llevaStock;
        this.pago = pago;
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

    public ComprobanteCompras getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteCompras comprobante) {
        this.comprobante = comprobante;
    }

    public Boolean getStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
    
    public Boolean getLlevaStock() {
        return llevaStock;
    }

    public void setLlevaStock(Boolean llevaStock) {
        this.llevaStock = llevaStock;
    }
}
