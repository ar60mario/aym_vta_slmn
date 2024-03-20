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
public class ContadorCpbteStock {
    private Integer id;
    private Long comprobante;

    public ContadorCpbteStock() {
    }

    public ContadorCpbteStock(Integer id, Long comprobante) {
        this.id = id;
        this.comprobante = comprobante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getComprobante() {
        return comprobante;
    }

    public void setComprobante(Long comprobante) {
        this.comprobante = comprobante;
    }
    
}
