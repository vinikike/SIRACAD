/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.converters;

import com.infosgroup.prueba.model.entities.Docente;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guille
 */
@FacesConverter(forClass = Docente.class)
public class DocenteConverter extends AbstractSelectOneConverter<Docente> {

}
