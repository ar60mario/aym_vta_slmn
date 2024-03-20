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
public class RcCo {
    private Long id;
    private ReciboProveedor reciboProveedor;
    private ComprobanteCompras comprobanteCompras;
    private ComprobanteCompras notaCredito;
    private Double importeFc;
    private Double importeRc;
    private Double importeNc;
    private Double imputadoNc;
    private Double imputadoFc;
    private Double imputadoRc;
    private Boolean anulado;

    public RcCo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReciboProveedor getReciboProveedor() {
        return reciboProveedor;
    }

    public void setReciboProveedor(ReciboProveedor reciboProveedor) {
        this.reciboProveedor = reciboProveedor;
    }

    public ComprobanteCompras getComprobanteCompras() {
        return comprobanteCompras;
    }

    public void setComprobanteCompras(ComprobanteCompras comprobanteCompras) {
        this.comprobanteCompras = comprobanteCompras;
    }

    public ComprobanteCompras getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(ComprobanteCompras notaCredito) {
        this.notaCredito = notaCredito;
    }

    public Double getImporteFc() {
        return importeFc;
    }

    public void setImporteFc(Double importeFc) {
        this.importeFc = importeFc;
    }

    public Double getImporteRc() {
        return importeRc;
    }

    public void setImporteRc(Double importeRc) {
        this.importeRc = importeRc;
    }

    public Double getImporteNc() {
        return importeNc;
    }

    public void setImporteNc(Double importeNc) {
        this.importeNc = importeNc;
    }

    public Double getImputadoNc() {
        return imputadoNc;
    }

    public void setImputadoNc(Double imputadoNc) {
        this.imputadoNc = imputadoNc;
    }

    public Double getImputadoFc() {
        return imputadoFc;
    }

    public void setImputadoFc(Double imputadoFc) {
        this.imputadoFc = imputadoFc;
    }

    public Double getImputadoRc() {
        return imputadoRc;
    }

    public void setImputadoRc(Double imputadoRc) {
        this.imputadoRc = imputadoRc;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public RcCo(Long id, ReciboProveedor reciboProveedor, ComprobanteCompras comprobanteCompras, ComprobanteCompras notaCredito, Double importeFc, Double importeRc, Double importeNc, Double imputadoNc, Double imputadoFc, Double imputadoRc, Boolean anulado) {
        this.id = id;
        this.reciboProveedor = reciboProveedor;
        this.comprobanteCompras = comprobanteCompras;
        this.notaCredito = notaCredito;
        this.importeFc = importeFc;
        this.importeRc = importeRc;
        this.importeNc = importeNc;
        this.imputadoNc = imputadoNc;
        this.imputadoFc = imputadoFc;
        this.imputadoRc = imputadoRc;
        this.anulado = anulado;
    }

}