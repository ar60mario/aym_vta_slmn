/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author argia
 */
public class ClienteSaldo {
    private Long id;
    private String codigo;
    private Cliente cliente;
    private Customer customer;
    private Double saldoCliente;
    private Double saldoCustomer;

    public ClienteSaldo() {
    }

    public ClienteSaldo(Long id, String codigo, Cliente cliente, Customer customer, Double saldoCliente, Double saldoCustomer) {
        this.id = id;
        this.codigo = codigo;
        this.cliente = cliente;
        this.customer = customer;
        this.saldoCliente = saldoCliente;
        this.saldoCustomer = saldoCustomer;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(Double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Double getSaldoCustomer() {
        return saldoCustomer;
    }

    public void setSaldoCustomer(Double saldoCustomer) {
        this.saldoCustomer = saldoCustomer;
    }
    
}
