package ar.com.ventas.entities;

public class CustomerInactivo implements Comparable<CustomerInactivo>{
    private Long id;
    private String codigo;
    private String razonSocial;
    private Boolean tieneDescuento;
    private Float descuento;
    private Double saldo;
    private String observaciones;
    private Boolean activo;
   
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
    public CustomerInactivo() {
    }

    public CustomerInactivo(Long id, String codigo, String razonSocial, Boolean tieneDescuento, Float descuento, Double saldo, String observaciones, Boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.razonSocial = razonSocial;
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
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    @Override
    public int compareTo(CustomerInactivo o) {
        String a = this.getRazonSocial();
        String b = o.getRazonSocial();
        return a.compareTo(b);
    }
}