/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Estadistica;
import com.infosgroup.prueba.model.entities.EstadisticaPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class EstadisticaFacade extends AbstractFacade<Estadistica, EstadisticaPK> {

    public EstadisticaFacade() {
        super(Estadistica.class);
    }
}
