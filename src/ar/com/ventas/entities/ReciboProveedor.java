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
public class ReciboProveedor {
    private Long id;
    private Date fecha;
    private Proveedor proveedor;
    private Integer numero;
    private Double importe;
    private Boolean imputado;
    private Double importeImputado;

    public ReciboProveedor() {
    }

    public ReciboProveedor(Long id, Date fecha, Proveedor proveedor, Integer numero, Double importe, Boolean imputado, Double importeImputado) {
        this.id = id;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.numero = numero;
        this.importe = importe;
        this.imputado = imputado;
        this.importeImputado = importeImputado;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getImputado() {
        return imputado;
    }

    public void setImputado(Boolean imputado) {
        this.imputado = imputado;
    }

    public Double getImporteImputado() {
        return importeImputado;
    }

    public void setImporteImputado(Double importeImputado) {
        this.importeImputado = importeImputado;
    }

}