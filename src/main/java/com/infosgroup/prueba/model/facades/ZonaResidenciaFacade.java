/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.ZonaResidencia;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class ZonaResidenciaFacade extends AbstractFacade<ZonaResidencia, String> {

    public ZonaResidenciaFacade() {
        super(ZonaResidencia.class);
    }
}
