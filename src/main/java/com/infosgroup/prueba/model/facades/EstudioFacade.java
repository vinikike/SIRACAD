/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Estudio;
import com.infosgroup.prueba.model.entities.EstudioPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class EstudioFacade extends AbstractFacade<Estudio, EstudioPK> {

    public EstudioFacade() {
        super(Estudio.class);
    }
}
