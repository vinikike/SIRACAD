/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Compania;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class CompaniaFacade extends AbstractFacade<Compania, Integer> {

    public CompaniaFacade() {
        super(Compania.class);
    }
}
