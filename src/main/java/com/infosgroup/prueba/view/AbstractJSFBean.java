/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicio Enrique Mercado Moreno
 * @version 2.0
 */
public class AbstractJSFBean
{

protected static final Logger logger = Logger.getGlobal();

// =============================================================================
public void _init()
{
    logger.log(Level.INFO, "Creando instancia [{0}]", getClass().getCanonicalName());
}

public String inicio$action()
{
    return "/app/inicio?faces-redirect=true";
}

public void mostrarMensajeJSF(FacesMessage.Severity severidad, String mensaje)
{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, null, mensaje));   
}


}