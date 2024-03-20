/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.DomicilioDAO;
import ar.com.ventas.entities.Domicilio;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class DomicilioBO {

    private final DomicilioDAO dao = new DomicilioDAO();

    public Domicilio saveDomicilio(Domicilio domicilioCliente) throws Exception {
        Domicilio domic = null;
        try {
            domic = (Domicilio) dao.save(domicilioCliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return domic;
    }

    public Domicilio updateDomicilio(Domicilio domicilio) throws Exception {
        try {
            domicilio = (Domicilio) dao.update(domicilio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return domicilio;
    }
}
