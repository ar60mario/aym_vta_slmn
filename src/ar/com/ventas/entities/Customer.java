package ar.com.ventas.entities;

public class Customer {
    private Long id;
    private String codigo;
    private Boolean tieneDescuento;
    private Float descuento;
    private Double saldo;
    private String observaciones;
    private Boolean activo;
    private Boolean tieneLimiteVenta;
    private Double limiteVenta;
   
    /* categorias IVA
    1 Inscripto
    2 Monotributo
    3 Exento
    4 Consumidor Final.
    
    formas de pago
    1 Contado
    2 7 dias fecha factura
    3 14 dias fecha factura
    4 otro
     */
    public Customer() {
    }

    public Customer(Long id, String codigo, Boolean tieneDescuento, Float descuento, Double saldo, String observaciones, Boolean activo, Boolean tieneLimiteVenta, Double limiteVenta) {
        this.id = id;
        this.codigo = codigo;
        this.tieneDescuento = tieneDescuento;
        this.descuento = descuento;
        this.saldo = saldo;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(Boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getTieneLimiteVenta() {
        return tieneLimiteVenta;
    }

    public void setTieneLimiteVenta(Boolean tieneLimiteVenta) {
        this.tieneLimiteVenta = tieneLimiteVenta;
    }
    
    public Double getLimiteVenta() {
        return limiteVenta;
    }

    public void setLimiteVenta(Double limiteVenta) {
        this.limiteVenta = limiteVenta;
    }
}