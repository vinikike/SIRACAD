/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Prestamolibros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class PrestamoLibroFacade extends AbstractFacade<Prestamolibros, Prestamolibros> {

    public PrestamoLibroFacade() {
        super(Prestamolibros.class);
    }

    public Integer max() {
        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(b.codprestamo) FROM Prestamolibros b", Integer.class);
        Integer resultado = tq.getSingleResult();
        return (resultado == null) ? 0 : resultado;
    }
    
        public List<Prestamolibros> listarPrestados() {
        TypedQuery<Prestamolibros> tq = getEntityManager().createQuery("SELECT b FROM Prestamolibros b WHERE b.estado = 'Prestado'", entityClass);
        return tq.getResultList();
    }
}
