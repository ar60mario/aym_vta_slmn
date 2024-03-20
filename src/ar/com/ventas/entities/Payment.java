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
public class Payment {
    private Long id;
    private Date fecha;
    private Integer numero;
    private Double importe;
    private Customer cliente;
    private int visto;

    public Payment() {
    }

    public Payment(Long id, Date fecha, Integer numero, Double importe, Customer cliente, int visto) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.importe = importe;
        this.cliente = cliente;
        this.visto = visto;
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

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    public int getVisto() {
        return visto;
    }

    public void setVisto(int visto) {
        this.visto = visto;
    }
}