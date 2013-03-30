/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Talleres;
import com.infosgroup.prueba.model.entities.TalleresPK;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class TalleresFacade extends AbstractFacade<Talleres, TalleresPK> {

    public TalleresFacade() {
        super(Talleres.class);
    }

    public Integer max(Integer periodoEscolar) {
        try {
            TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(t.talleresPK.codigoTaller) FROM Talleres t WHERE t.talleresPK.idPeriodoEscolar = :periodoEscolar", Integer.class);
            tq.setParameter("periodoEscolar", periodoEscolar);
            Integer resultado = tq.getSingleResult();
            return resultado == null ? 0 : resultado;
        } catch (Exception e) {
            return 0;
        }
    }
}
