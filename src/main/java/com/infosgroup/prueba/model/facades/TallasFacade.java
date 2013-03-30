/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Tallas;
import com.infosgroup.prueba.model.entities.TallasPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class TallasFacade extends AbstractFacade<Tallas, TallasPK> {

    public TallasFacade() {
        super(Tallas.class);
    }
}
