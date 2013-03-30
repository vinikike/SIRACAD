/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Rol;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol, String> {

    public RolFacade() {
        super(Rol.class);
    }
}
