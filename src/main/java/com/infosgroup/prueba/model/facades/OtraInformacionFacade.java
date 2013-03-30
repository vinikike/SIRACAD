/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Otrainformacion;
import com.infosgroup.prueba.model.entities.OtrainformacionPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class OtraInformacionFacade extends AbstractFacade<Otrainformacion, OtrainformacionPK> {

    public OtraInformacionFacade() {
        super(Otrainformacion.class);
    }
}
