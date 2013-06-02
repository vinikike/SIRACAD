/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.converters;

import com.infosgroup.prueba.model.entities.Rol;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Guille
 */
@FacesConverter(forClass = Rol.class)
public class RolConverter extends SelectItemsConverter {
}
