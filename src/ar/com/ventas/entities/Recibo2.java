package ar.com.ventas.entities;

import java.util.Date;

public class Recibo2 implements Comparable<Recibo2> {

    private Long id;
    private Date fecha;
    private Integer numero;
    private Double importe;
    private Cliente cliente;
    private String timer2;
    private boolean azul;

    public Recibo2() {
    }

    public Recibo2(Long id, Date fecha, Integer numero, Double importe, Cliente cliente, String timer2, boolean azul) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.importe = importe;
        this.cliente = cliente;
        this.timer2 = timer2;
        this.azul = azul;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTimer2() {
        return timer2;
    }

    public void setTimer2(String timer2) {
        this.timer2 = timer2;
    }

    public boolean isAzul() {
        return azul;
    }

    public void setAzul(boolean azul) {
        this.azul = azul;
    }

    @Override
    public int compareTo(Recibo2 o) {
        String a = this.getTimer2();
        String b = o.getTimer2();
        return a.compareTo(b);
    }
}
