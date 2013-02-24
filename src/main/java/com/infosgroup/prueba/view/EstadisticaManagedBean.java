/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.facades.EstadisticaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresarEstadistica")
@ViewScoped
public class EstadisticaManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient EstadisticaFacade estadisticaFacade;
    
    

    /**
     * Creates a new instance of EstadisticaManagedBean
     */
    public EstadisticaManagedBean() {
    }
}
