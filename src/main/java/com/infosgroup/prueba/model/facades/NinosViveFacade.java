/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Ninosvive;
import com.infosgroup.prueba.model.entities.NinosvivePK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class NinosViveFacade extends AbstractFacade<Ninosvive, NinosvivePK> {

    public NinosViveFacade() {
        super(Ninosvive.class);
    }
}
