/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Mario
 */
public class ComprobanteComprasDetalle {
    private Long id;
    private Integer orden;
    private ComprobanteCompras comprobanteCompras;
    private String texto;

    public ComprobanteComprasDetalle() {
    }

    public ComprobanteComprasDetalle(Long id, Integer orden, ComprobanteCompras comprobanteCompras, String texto) {
        this.id = id;
        this.orden = orden;
        this.comprobanteCompras = comprobanteCompras;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public ComprobanteCompras getComprobanteCompras() {
        return comprobanteCompras;
    }

    public void setComprobanteCompras(ComprobanteCompras comprobanteCompras) {
        this.comprobanteCompras = comprobanteCompras;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
