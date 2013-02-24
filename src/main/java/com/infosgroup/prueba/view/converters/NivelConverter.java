/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.converters;

import com.infosgroup.prueba.model.entities.Nivel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Guille
 */
@FacesConverter(value = "defaultNivelConverter")
public class NivelConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Nivel nivel = (Nivel) value;
        return nivel.getIdNivel().toString();
    }
}
