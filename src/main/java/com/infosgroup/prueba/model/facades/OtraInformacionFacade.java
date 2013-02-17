/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Otrainformacion;
import com.infosgroup.prueba.model.entities.OtrainformacionPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class OtraInformacionFacade extends AbstractFacade<Otrainformacion, OtrainformacionPK> {
    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OtraInformacionFacade() {
        super(Otrainformacion.class);
    }
    
}