/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Autorizacion;
import com.infosgroup.prueba.model.entities.AutorizacionPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class AutorizacionFacade extends AbstractFacade<Autorizacion, AutorizacionPK> {

    public AutorizacionFacade() {
        super(Autorizacion.class);
    }
}
