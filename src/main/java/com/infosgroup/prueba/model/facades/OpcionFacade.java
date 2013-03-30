/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Opcion;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class OpcionFacade extends AbstractFacade<Opcion, Integer> {

    public OpcionFacade() {
        super(Opcion.class);
    }
//    public List<Opcion> findByNivel(Nivel n) {
//        TypedQuery<Opcion> tq = getEntityManager().createQuery("SELECT o FROM Opcion o WHERE o.nivel = :nivel", Opcion.class);
//        tq.setParameter("nivel", n);
//        return tq.getResultList();
//    }
}
