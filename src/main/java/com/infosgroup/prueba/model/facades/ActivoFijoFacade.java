/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Activofijo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.bouncycastle.asn1.x509.qualified.BiometricData;

/**
 *
 * @author Guille
 */
@Stateless
public class ActivoFijoFacade extends AbstractFacade<Activofijo, String> {

    public ActivoFijoFacade() {
        super(Activofijo.class);
    }

}
