/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Representante;
import com.infosgroup.prueba.model.entities.RepresentantePK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class RepresentanteFacade extends AbstractFacade<Representante, RepresentantePK> {

    public RepresentanteFacade() {
        super(Representante.class);
    }
}
