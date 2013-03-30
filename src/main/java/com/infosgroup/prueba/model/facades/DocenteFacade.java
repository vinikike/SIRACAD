/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Docente;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class DocenteFacade extends AbstractFacade<Docente, String> {

    public DocenteFacade() {
        super(Docente.class);
    }
}
