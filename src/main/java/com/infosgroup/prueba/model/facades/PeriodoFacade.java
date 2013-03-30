/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Periodo;
import com.infosgroup.prueba.model.entities.PeriodoPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class PeriodoFacade extends AbstractFacade<Periodo, PeriodoPK> {

    public PeriodoFacade() {
        super(Periodo.class);
    }
}
