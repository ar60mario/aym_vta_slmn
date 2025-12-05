package ar.com.ventas.entities;

import java.util.Date;

public class Payment {

    private Long id;
    private Date fecha;
    private Integer numero;
    private Double importe;
    private Customer cliente;
    private Integer hora;
    private Integer minuto;
    private Integer segundo;
    private int visto;

    public Payment() {
    }

    public Payment(Long id, Date fecha, Integer numero, Double importe, Customer cliente, Integer hora, Integer minuto, Integer segundo, int visto) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.importe = importe;
        this.cliente = cliente;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.visto = visto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getSegundo() {
        return segundo;
    }

    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }

    public int getVisto() {
        return visto;
    }

    public void setVisto(int visto) {
        this.visto = visto;
    }
    
}