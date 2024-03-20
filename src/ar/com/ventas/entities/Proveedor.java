
package ar.com.ventas.entities;

public class Proveedor {
    
    private Long id;
    private Integer codigo;
    private String razonSocial;
    private String cuit;
    private Integer categoriaIva;
    private String telefono;
    private String celular;
    private String contacto;
    private String mail;
    private String observaciones;
    private Boolean activo;
    private Double saldo;
    private Boolean stock;

    public Proveedor() {
    }

    public Proveedor(Long id, Integer codigo, String razonSocial, String contacto, String cuit, Integer categoriaIva, String telefono, String celular, String mail, String observaciones, Boolean activo, Double saldo, Boolean stock) {
        this.id = id;
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.categoriaIva = categoriaIva;
        this.telefono = telefono;
        this.celular = celular;
        this.mail = mail;
        this.observaciones = observaciones;
        this.activo = activo;
        this.saldo = saldo;
        this.contacto = contacto;
        this.stock = stock;
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Integer getCategoriaIva() {
        return categoriaIva;
    }

    public void setCategoriaIva(Integer categoriaIva) {
        this.categoriaIva = categoriaIva;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public Boolean getStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }
}