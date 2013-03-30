/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class PeriodoEscolarFacade extends AbstractFacade<PeriodoEscolar, Integer> {

    public PeriodoEscolarFacade() {
        super(PeriodoEscolar.class);
    }
}
