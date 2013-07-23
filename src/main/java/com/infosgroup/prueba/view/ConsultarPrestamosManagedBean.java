/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Biblioteca;
import com.infosgroup.prueba.model.entities.Prestamolibros;
import com.infosgroup.prueba.model.facades.PrestamoLibroFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "consultarPrestamosManagedBean")
@ViewScoped
public class ConsultarPrestamosManagedBean extends AbstractJSFBean implements Serializable {

@EJB
    private transient PrestamoLibroFacade prestamoLibroFacade;
    //-----------------------------------------------------------------
    @Inject
    private SessionBean sessionBean;
    //-----------------------------------------------------------------
    private Biblioteca biblioteca;
    //-----------------------------------------------------------------
    private List<Prestamolibros> listaPrestamolibros;
    private String estado;

    //=================================================================
    public List<Prestamolibros> getListaPrestamolibros() {
        return listaPrestamolibros;
    }

    public void setListaPrestamolibros(List<Prestamolibros> listaPrestamolibros) {
        this.listaPrestamolibros = listaPrestamolibros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //==================================================================

    @PostConstruct
    @Override
    public void _init() {
        super._init();
        listaPrestamolibros = prestamoLibroFacade.findAll();
    }
    
}
