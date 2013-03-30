/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "EditarDatosAlumno")
@ViewScoped
public class EditarDatosdeAlumnoManagedBean extends AbstractJSFBean implements Serializable {

    private String EditarAlumno$NIE;

    //----------------------------------------------------------------------
    public String getEditarAlumno$NIE() {
        return EditarAlumno$NIE;
    }

    public void setEditarAlumno$NIE(String EditarAlumno$NIE) {
        this.EditarAlumno$NIE = EditarAlumno$NIE;
    }
    
    //----------------------------------------------------------------------

    

}
