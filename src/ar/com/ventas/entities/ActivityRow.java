/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.entities;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ActivityRow {
    private Long id;
    private Integer itemNro;
    private Integer codigoProducto;
    private String descripcion;
    private Double gravado;
    private Float cantidad;
    private Double exento;
    private Double noGravado;
    private Double impuesto;
    private Double descuento;
    private Double iva;
    private Double total;
    private Activity activity;
    private Double sugerido;
    private Double precioUnitario;
    private Float impuestoUnitario;

    public ActivityRow() {
    }

    public ActivityRow(Long id, Integer itemNro, Integer codigoProducto, String descripcion, Double gravado, Float cantidad, Double exento, Double noGravado, Double impuesto, Double descuento, Double iva, Double total, Activity activity, Double sugerido, Double precioUnitario, Float impuestoUnitario) {
        this.id = id;
        this.itemNro = itemNro;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.gravado = gravado;
        this.cantidad = cantidad;
        this.exento = exento;
        this.noGravado = noGravado;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.activity = activity;
        this.sugerido = sugerido;
        this.precioUnitario = precioUnitario;
        this.impuestoUnitario = impuestoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemNro() {
        return itemNro;
    }

    public void setItemNro(Integer itemNro) {
        this.itemNro = itemNro;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
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

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Double getSugerido() {
        return sugerido;
    }

    public void setSugerido(Double sugerido) {
        this.sugerido = sugerido;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Float getImpuestoUnitario() {
        return impuestoUnitario;
    }

    public void setImpuestoUnitario(Float impuestoUnitario) {
        this.impuestoUnitario = impuestoUnitario;
    }

}