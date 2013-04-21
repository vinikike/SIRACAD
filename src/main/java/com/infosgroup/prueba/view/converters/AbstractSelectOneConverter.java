/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Guille
 */
public abstract class AbstractSelectOneConverter<ClaseBase> extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        ClaseBase c = (ClaseBase) value;
        return c.toString();
    }
}
