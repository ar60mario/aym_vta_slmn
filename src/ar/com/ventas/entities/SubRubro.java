/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Administrador
 */
public class SubRubro {

    private Long id;
    private Integer codigo;
    private String detalle;
    private Boolean lista;

    public SubRubro() {
    }

    public SubRubro(Long id, Integer codigo, String detalle, Boolean lista) {
        this.id = id;
        this.codigo = codigo;
        this.detalle = detalle;
        this.lista = lista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getLista() {
        return lista;
    }

    public void setLista(Boolean lista) {
        this.lista = lista;
    }
}
