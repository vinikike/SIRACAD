/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Nivel;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class NivelFacade extends AbstractFacade<Nivel, Integer> {

    public NivelFacade() {
        super(Nivel.class);
    }
}
