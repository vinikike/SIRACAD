/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@ManagedBean(name = "loginManager")
@ViewScoped
public class LoginManager extends AbstractJSFBean implements Serializable
{

private static final long serialVersionUID = 1L;
//
private String usuario;
private String pass;

@Override
@PostConstruct
public void _init()
{
    super._init();
}

// ==============================================================================
public String getUsuario()
{
    return usuario;
}

public void setUsuario(String usuario)
{
    this.usuario = usuario;
}

public String getPass()
{
    return pass;
}

public void setPass(String pass)
{
    this.pass = pass;
}

// ==============================================================================
public String iniciarSesion$action()
{
    String navegacion = null;
    try
        {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.login(usuario, pass);        
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        navegacion = inicio$action();
        }
    catch (Exception excpt)
        {
        mostrarMensajeJSF(FacesMessage.SEVERITY_ERROR, "No se permite el inicio de sesi&oacute;n: Nombre de usuario y/o contrase&ntilde;a incorrectos");
        navegacion = null;
        }
    finally
        {
        return navegacion;
        }
}

public String cerrarSesion$action()
{
    String navegacion = null;
    try
        {
        List<Object> objs = new ArrayList<Object>();
        //
        objs.add(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        objs.add(GregorianCalendar.getInstance().getTime());
        logger.log(Level.INFO, "[Cierre de sesion del usuario {0}: {1}]", objs.toArray(new Object[0]));

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.logout();

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        navegacion = inicio$action();
        }
    catch (Exception excpt)
        {
        mostrarMensajeJSF(FacesMessage.SEVERITY_ERROR, excpt.toString());
        navegacion = null;
        }
    finally
        {
        return navegacion;
        }
}
}