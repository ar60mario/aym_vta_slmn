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
public class FamiliaProducto implements Comparable<FamiliaProducto> {
    private Date fecha;
    private Double massalin;
    private Double nobleza;
    private Double cigarrillos;
    private Double tarjetas;
    private Double analgesicos;
    private Double varios;
    private Double noVenta;
    private Double total;

    public FamiliaProducto() {
    }

    public FamiliaProducto(Date fecha, Double massalin, Double nobleza, Double cigarrillos, Double tarjetas, Double analgesicos, Double noVenta, Double varios, Double total) {
        this.fecha = fecha;
        this.massalin = massalin;
        this.nobleza = nobleza;
        this.cigarrillos = cigarrillos;
        this.tarjetas = tarjetas;
        this.analgesicos = analgesicos;
        this.varios = varios;
        this.noVenta = noVenta;
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMassalin() {
        return massalin;
    }

    public void setMassalin(Double massalin) {
        this.massalin = massalin;
    }

    public Double getNobleza() {
        return nobleza;
    }

    public void setNobleza(Double nobleza) {
        this.nobleza = nobleza;
    }

    public Double getCigarrillos() {
        return cigarrillos;
    }

    public void setCigarrillos(Double cigarrillos) {
        this.cigarrillos = cigarrillos;
    }

    public Double getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Double tarjetas) {
        this.tarjetas = tarjetas;
    }

    public Double getAnalgesicos() {
        return analgesicos;
    }

    public void setAnalgesicos(Double analgesicos) {
        this.analgesicos = analgesicos;
    }

    public Double getVarios() {
        return varios;
    }

    public void setVarios(Double varios) {
        this.varios = varios;
    }

    public Double getNoVenta() {
        return noVenta;
    }

    public void setNoVenta(Double noVenta) {
        this.noVenta = noVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    @Override
    public int compareTo(FamiliaProducto o) {
        Date a = this.getFecha();
        Date b = o.getFecha();
        return a.compareTo(b);
    }
}
