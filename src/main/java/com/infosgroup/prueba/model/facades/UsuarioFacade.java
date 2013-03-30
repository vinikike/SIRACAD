/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario, String> {

    public UsuarioFacade() {
        super(Usuario.class);
    }
}
