/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class PeriodoEscolarFacade extends AbstractFacade<PeriodoEscolar, Integer> {

    public PeriodoEscolarFacade() {
        super(PeriodoEscolar.class);
    }

    public Integer max() {
        try {
            TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(p.id) FROM PeriodoEscolar p", Integer.class);
            Integer resultado = tq.getSingleResult();
            return (resultado == null) ? 0 : resultado;
        } catch (Exception e) {
            return null;
        }
    }
}
