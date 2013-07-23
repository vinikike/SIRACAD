/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.entities.Talleres;
import com.infosgroup.prueba.model.entities.TalleresPK;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import com.infosgroup.prueba.model.facades.TalleresFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "editarTaller")
@ViewScoped
public class EditarTalleresManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient TalleresFacade talleresFacade;
    @EJB
    private transient DocenteFacade docenteFacade;
    //========================================================================
    @Inject
    private SessionBean sessionBean;
    //========================================================================   
    private List<Docente> listaDocentes;
    private List<Talleres> listaTalleres;
    //-----------------------------------------------------------------------
    private Integer talleres$periodoEscolar;
    private Integer talleres$idTaller;
    private String talleres$nombreTaller;
    private String talleres$descripcionTaller;
    private String talleres$responsableTaller;
    private Talleres talleres$taller;

//-----------sets y Gets--------------------------------------------------------
    public Integer getTalleres$periodoEscolar() {
        return talleres$periodoEscolar;
    }

    public void setTalleres$periodoEscolar(Integer talleres$periodoEscolar) {
        this.talleres$periodoEscolar = talleres$periodoEscolar;
    }

    public Integer getTalleres$idTaller() {
        return talleres$idTaller;
    }

    public void setTalleres$idTaller(Integer talleres$idTaller) {
        this.talleres$idTaller = talleres$idTaller;
    }

    public String getTalleres$nombreTaller() {
        return talleres$nombreTaller;
    }

    public void setTalleres$nombreTaller(String talleres$nombreTaller) {
        this.talleres$nombreTaller = talleres$nombreTaller;
    }

    public String getTalleres$descripcionTaller() {
        return talleres$descripcionTaller;
    }

    public void setTalleres$descripcionTaller(String talleres$descripcionTaller) {
        this.talleres$descripcionTaller = talleres$descripcionTaller;
    }

    public String getTalleres$responsableTaller() {
        return talleres$responsableTaller;
    }

    public void setTalleres$responsableTaller(String talleres$responsableTaller) {
        this.talleres$responsableTaller = talleres$responsableTaller;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<Talleres> getListaTalleres() {
        return listaTalleres;
    }

    public void setListaTalleres(List<Talleres> listaTalleres) {
        this.listaTalleres = listaTalleres;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Talleres getTalleres$taller() {
        return talleres$taller;
    }

    public void setTalleres$taller(Talleres talleres$taller) {
        this.talleres$taller = talleres$taller;
    }

//-------------------------------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();

        listaDocentes = docenteFacade.findAll();
        listaTalleres = talleresFacade.findAll();

        talleres$periodoEscolar = sessionBean.getPeriodoEscolar().getId();
        talleres$nombreTaller = "";
        talleres$descripcionTaller = "";
        talleres$responsableTaller = "";
    }

    public String actualizarTaller$action(ValueChangeEvent evt) {

        String taller = (String) evt.getNewValue();
        listaTalleres = new ArrayList<>();
        
                
        talleres$taller = getTalleres$taller();

        talleres$nombreTaller = getTalleres$nombreTaller();
        talleres$descripcionTaller = getTalleres$descripcionTaller();
        talleres$responsableTaller = getTalleres$responsableTaller();

        //talleresFacade.find(talleres$taller.getTalleresPK());

//        TalleresPK talleresPK = new TalleresPK();
//        talleresPK.setIdPeriodoEscolar(sessionBean.getPeriodoEscolar().getId());
//        talleresPK.setCodigoTaller(talleresFacade.max(2013)+1);
//
//        Talleres talleres = new Talleres();
//        talleres.setTalleresPK(talleresPK);
//
//        talleres.setNombre(talleres$nombreTaller);
//        talleres.setDescripcion(talleres$descripcionTaller);
//        talleres.setResponsable(talleres$nombreTaller);
//        talleresFacade.create(talleres);
//        
//        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Taller Actualizado exitosamente");
//        
//        talleres$nombreTaller = "";
//        talleres$descripcionTaller = "";
//        talleres$responsableTaller = "Seleccione un Docente";
//        listaTalleres = talleresFacade.findAll();

        return null;
    }

    public void editartaller$valueChangeListener(ValueChangeEvent evt) {
        talleres$taller = getTalleres$taller();

        talleres$nombreTaller = getTalleres$nombreTaller();
        talleres$descripcionTaller = getTalleres$descripcionTaller();
        talleres$responsableTaller = getTalleres$responsableTaller();


    }
}
