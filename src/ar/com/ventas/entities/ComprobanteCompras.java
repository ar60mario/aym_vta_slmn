package ar.com.ventas.entities;

import java.util.Date;

public class ComprobanteCompras {
    private Long id;
    private Date fechaPeriodo;
    private Date fechaFactura;
    private Date fechaEntrega;
    private Proveedor proveedor;
    private String tipoComprobante;
    private String letra;
    private Integer numeroSucursal;
    private Integer numeroFactura;
    private Double gravado;
    private Double noGravado;
    private Double impuestoInterno;
    private Double percepcionIiBb;
    private Double percepcionIva;
    private Double otro;
    private Double iva;
    private Double total;
    private Boolean esDebito;
    private Double pagado;
    private Boolean estaPago;
    private Boolean enLibro;
    private Boolean tieneDetalle;
    private Boolean prontoPago;
    private Integer diasVencimiento;
    private Date fechaCalculoVencimiento;

    public ComprobanteCompras() {
    }

    public ComprobanteCompras(Long id, Date fechaPeriodo, Date fechaFactura, Date fechaEntrega, Proveedor proveedor, String tipoComprobante, String letra, Integer numeroSucursal, Integer numeroFactura, Double gravado, Double noGravado, Double impuestoInterno, Double percepcionIiBb, Double percepcionIva, Double otro, Double iva, Double total, Boolean esDebito, Double pagado, Boolean estaPago, Boolean enLibro, Boolean tieneDetalle, Boolean prontoPago, Integer diasVencimiento, Date fechaCalculoVencimiento) {
        this.id = id;
        this.fechaPeriodo = fechaPeriodo;
        this.fechaFactura = fechaFactura;
        this.fechaEntrega = fechaEntrega;
        this.proveedor = proveedor;
        this.tipoComprobante = tipoComprobante;
        this.letra = letra;
        this.numeroSucursal = numeroSucursal;
        this.numeroFactura = numeroFactura;
        this.gravado = gravado;
        this.noGravado = noGravado;
        this.impuestoInterno = impuestoInterno;
        this.percepcionIiBb = percepcionIiBb;
        this.percepcionIva = percepcionIva;
        this.otro = otro;
        this.iva = iva;
        this.total = total;
        this.esDebito = esDebito;
        this.pagado = pagado;
        this.estaPago = estaPago;
        this.enLibro = enLibro;
        this.tieneDetalle = tieneDetalle;
        this.prontoPago = prontoPago;
        this.diasVencimiento = diasVencimiento;
        this.fechaCalculoVencimiento = fechaCalculoVencimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPeriodo() {
        return fechaPeriodo;
    }

    public void setFechaPeriodo(Date fechaPeriodo) {
        this.fechaPeriodo = fechaPeriodo;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(Integer numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(Double noGravado) {
        this.noGravado = noGravado;
    }

    public Double getImpuestoInterno() {
        return impuestoInterno;
    }

    public void setImpuestoInterno(Double impuestoInterno) {
        this.impuestoInterno = impuestoInterno;
    }

    public Double getPercepcionIiBb() {
        return percepcionIiBb;
    }

    public void setPercepcionIiBb(Double percepcionIiBb) {
        this.percepcionIiBb = percepcionIiBb;
    }

    public Double getPercepcionIva() {
        return percepcionIva;
    }

    public void setPercepcionIva(Double percepcionIva) {
        this.percepcionIva = percepcionIva;
    }

    public Double getOtro() {
        return otro;
    }

    public void setOtro(Double otro) {
        this.otro = otro;
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

    public Boolean getEsDebito() {
        return esDebito;
    }

    public void setEsDebito(Boolean esDebito) {
        this.esDebito = esDebito;
    }

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public Boolean getEstaPago() {
        return estaPago;
    }

    public void setEstaPago(Boolean estaPago) {
        this.estaPago = estaPago;
    }

    public Boolean getEnLibro() {
        return enLibro;
    }

    public void setEnLibro(Boolean enLibro) {
        this.enLibro = enLibro;
    }
    
    public Boolean getTieneDetalle() {
        return tieneDetalle;
    }

    public void setTieneDetalle(Boolean tieneDetalle) {
        this.tieneDetalle = tieneDetalle;
    }
    
    public Boolean getProntoPago() {
        return prontoPago;
    }

    public void setProntoPago(Boolean prontoPago) {
        this.prontoPago = prontoPago;
    }

    public Integer getDiasVencimiento() {
        return diasVencimiento;
    }

    public void setDiasVencimiento(Integer diasVencimiento) {
        this.diasVencimiento = diasVencimiento;
    }

    public Date getFechaCalculoVencimiento() {
        return fechaCalculoVencimiento;
    }

    public void setFechaCalculoVencimiento(Date fechaCalculoVencimiento) {
        this.fechaCalculoVencimiento = fechaCalculoVencimiento;
    }
    
}