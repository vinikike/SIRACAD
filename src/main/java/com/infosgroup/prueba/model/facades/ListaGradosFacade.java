/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.ListaGrados;
import com.infosgroup.prueba.model.entities.Nivel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class ListaGradosFacade extends AbstractFacade<ListaGrados, Integer> {

    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaGradosFacade() {
        super(ListaGrados.class);
    }

    public List<ListaGrados> findByNivel(Nivel n) {
        TypedQuery<ListaGrados> tq = getEntityManager().createQuery("SELECT l FROM ListaGrados l WHERE l.nivel = :nivel", ListaGrados.class);
        tq.setParameter("nivel", n);
        return tq.getResultList();
    }
}
