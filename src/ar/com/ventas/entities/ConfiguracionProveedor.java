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
public class ConfiguracionProveedor {
    private Long id;
    private Integer numeroReciboCompras;

    public ConfiguracionProveedor() {
    }

    public ConfiguracionProveedor(Long id, Integer numeroReciboCompras) {
        this.id = id;
        this.numeroReciboCompras = numeroReciboCompras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroReciboCompras() {
        return numeroReciboCompras;
    }

    public void setNumeroReciboCompras(Integer numeroReciboCompras) {
        this.numeroReciboCompras = numeroReciboCompras;
    }
}
