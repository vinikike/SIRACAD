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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "devolucionLibrosManagedBean")
@ViewScoped
public class DevolucionLibrosManagedBean extends AbstractJSFBean implements Serializable {

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
        listaPrestamolibros = prestamoLibroFacade.listarPrestados();
    }

    public String devolverLibro$action() {
        Prestamolibros devolucion = prestamoLibroSeleccionado;
        devolucion.setEstado("Devuelto");
        prestamoLibroFacade.edit(devolucion);
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Devolucion realizada con Exito");

        listaPrestamolibros = prestamoLibroFacade.listarPrestados();
        return null;
    }
    
    private Prestamolibros prestamoLibroSeleccionado;

    public Prestamolibros getPrestamoLibroSeleccionado() {
        return prestamoLibroSeleccionado;
    }

    public void setPrestamoLibroSeleccionado(Prestamolibros prestamoLibroSeleccionado) {
        this.prestamoLibroSeleccionado = prestamoLibroSeleccionado;
    }
    
    
}
