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
public class Periodo {
    private Long id;
    private String detalle;
    private Integer mes;
    private Integer anio;
    private Date desdeFecha;
    private Date hastaFecha;
    private Boolean cerrado;

    public Periodo() {
    }

    public Periodo(Long id, String detalle, Integer mes, Integer anio, Date desdeFecha, Date hastaFecha, Boolean cerrado) {
        this.id = id;
        this.detalle = detalle;
        this.mes = mes;
        this.anio = anio;
        this.desdeFecha = desdeFecha;
        this.hastaFecha = hastaFecha;
        this.cerrado = cerrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getDesdeFecha() {
        return desdeFecha;
    }

    public void setDesdeFecha(Date desdeFecha) {
        this.desdeFecha = desdeFecha;
    }

    public Date getHastaFecha() {
        return hastaFecha;
    }

    public void setHastaFecha(Date hastaFecha) {
        this.hastaFecha = hastaFecha;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

}