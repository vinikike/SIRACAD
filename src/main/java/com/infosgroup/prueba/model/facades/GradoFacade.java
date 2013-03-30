/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.entities.GradoPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class GradoFacade extends AbstractFacade<Grado, GradoPK> {

    public GradoFacade() {
        super(Grado.class);
    }
//    public String getSeccion(String nivel, String grado, String opcion) {
//        try {
//            TypedQuery<String> tq = getEntityManager().createQuery("SELECT MAX(g.gradoPK.seccion) FROM Grado g WHERE g.gradoPK.nivel = :nivel AND g.gradoPK.grado = :grado AND g.gradoPK.opcion = :opcion", String.class);
//            tq.setParameter("nivel", nivel);
//            tq.setParameter("grado", grado);
//            tq.setParameter("opcion", opcion);
//            String r = tq.getSingleResult();
//            return (r == null) ? "A" : r;
//        } catch (Exception excpt) {
//            return "A";
//        }
//
//    }
}
