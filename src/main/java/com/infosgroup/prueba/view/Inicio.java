/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "inicio")
@ViewScoped
public class Inicio extends AbstractJSFBean implements Serializable
{

private static final long serialVersionUID = 1L;
private Integer i;

@Override
@PostConstruct
public void _init()
{
    super._init();
    i = 0;
}

public String sumar()
{
    ++i;
    mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "i: " + i);
    return null;
}

public String restar()
{
    --i;
    mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "i: " + i);
    return null;
}

public Integer getI()
{
    return i;
}

public void setI(Integer i)
{
    this.i = i;
}

}
