
package ar.com.ventas.entities;

public class ComprobanteVentas implements Comparable<ComprobanteVentas> {
    private Long id;
    private String orden;
    private Long id_cpbte;
    private Integer db;

    public ComprobanteVentas() {
    }

    public ComprobanteVentas(Long id, String orden, Long id_cpbte, Integer db) {
        this.id = id;
        this.orden = orden;
        this.id_cpbte = id_cpbte;
        this.db = db;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public Long getId_cpbte() {
        return id_cpbte;
    }

    public void setId_cpbte(Long id_cpbte) {
        this.id_cpbte = id_cpbte;
    }

    public Integer getDb() {
        return db;
    }

    public void setDb(Integer db) {
        this.db = db;
    }
    
    @Override
    public int compareTo(ComprobanteVentas o) {
        String a = this.getOrden();
        String b = o.getOrden();
        return a.compareTo(b);
    }
}