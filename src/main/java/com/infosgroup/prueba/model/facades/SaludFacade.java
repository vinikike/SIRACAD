/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Salud;
import com.infosgroup.prueba.model.entities.SaludPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class SaludFacade extends AbstractFacade<Salud, SaludPK> {

    public SaludFacade() {
        super(Salud.class);
    }
}
