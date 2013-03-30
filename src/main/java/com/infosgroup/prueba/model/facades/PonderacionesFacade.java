/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Ponderaciones;
import com.infosgroup.prueba.model.entities.PonderacionesPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class PonderacionesFacade extends AbstractFacade<Ponderaciones, PonderacionesPK> {

    public PonderacionesFacade() {
        super(Ponderaciones.class);
    }
}
